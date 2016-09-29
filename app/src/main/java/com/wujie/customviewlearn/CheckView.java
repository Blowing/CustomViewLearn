package com.wujie.customviewlearn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2016/9/29.
 */
public class CheckView extends View {

    private static final int ANIM_NULL = 0;
    private static final int ANIM_CHEK = 1;
    private static final int ANIM_UNCHECK = 2;

    private Context mContext;
    private int mWidth, mHeight;
    private Handler mHandler;

    private Paint mPaint;
    private Bitmap okBitmap;

    private int animCurrentPage = -1;
    private int animMaxPage = 13;
    private int animDuration = 500;
    private int animstate = ANIM_NULL;

    private boolean isCheck = false;

    public CheckView(Context context) {
        super(context);
    }

    public CheckView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mPaint = new Paint();
        mPaint.setColor(0xffFF5317);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

        okBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.checkmark);

        mHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                if(animCurrentPage < animMaxPage && animCurrentPage >= 0) {
                    invalidate();
                    if(animstate == ANIM_NULL){
                        return;
                    } else if (animstate == ANIM_CHEK) {
                        animCurrentPage++;
                    } else {
                        animCurrentPage--;
                    }
                    this.sendEmptyMessageDelayed(0,  animDuration / animMaxPage);
                } else {
                    if (isCheck) {
                        animCurrentPage = animMaxPage -1;
                    } else {
                        animCurrentPage = -1;
                    }
                    invalidate();
                    animstate = ANIM_NULL;
                }
            }
        };
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.drawCircle(0,0,240,mPaint);
        int sideLength = okBitmap.getHeight();
        int sideWidth = okBitmap.getWidth();
        Log.e("width+height", sideLength +"-" + sideWidth);
        //Rect src = new Rect(0, 0, (int)(sideWidth *animCurrentPage / 10) , (int)(sideLength * animCurrentPage / 10));
        Rect src = new Rect(sideLength * animCurrentPage, 0, sideLength * (animCurrentPage + 1), sideLength);
        //Rect src = new Rect(0,0,50,50);

        Rect dist = new Rect(-200, -200, 200, 200);
        canvas.drawBitmap(okBitmap, src, dist, null);
        //canvas.drawBitmap(okBitmap,0,0,mPaint);

    }

    public void check() {
        if (animstate != ANIM_NULL || isCheck)
            return;
        animstate = ANIM_CHEK;
        animCurrentPage = 0;
        mHandler.sendEmptyMessageDelayed(0, animDuration / animMaxPage);
        isCheck = true;
    }

    public void unCheck() {
        if (animstate != ANIM_NULL || !isCheck)
            return;
        animstate = ANIM_UNCHECK;
        animCurrentPage = animMaxPage -1;
        mHandler.sendEmptyMessageDelayed(0, animDuration / animMaxPage);
        isCheck = false;
    }

    public void setAnimDuration(int animDuration) {
        if (animDuration <= 0)
            return;
        this.animDuration = animDuration;
    }

    public void setBackgroundColor(int color) {
        mPaint.setColor(color);
    }
}
