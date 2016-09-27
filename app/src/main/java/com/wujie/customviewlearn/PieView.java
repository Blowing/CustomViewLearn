package com.wujie.customviewlearn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/27.
 */
public class PieView extends View{

    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000,0xFFFF8c69,
    0xFFE6B800};
    private float mStartAngle = 0;
    private ArrayList<PieData> mData = new ArrayList<>();
    private int mWidth, mHeight;

    private Paint mPaint = new Paint();
    public PieView(Context context) {
        super(context);
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    public PieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
        if(mData == null) {
            return;
        }
        float currentStartAngle = mStartAngle;
        canvas.translate(mWidth/2, mHeight / 2);

        float r = (float) (Math.min(mHeight, mWidth) / 2 * 0.8);
        RectF rectF = new RectF(-r, -r, r, r);
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rectF, currentStartAngle, pie.getAngle(), true, mPaint);
            currentStartAngle += pie.getAngle();
        }
    }

    private void initData() {
        PieData pieData = new PieData();
        pieData.setAngle(90);
        pieData.setColor(mColors[0]);
        mData.add(pieData);
        PieData pieData1 = new PieData();
        pieData1.setAngle(90);
        pieData1.setColor(mColors[1]);
        mData.add(pieData1);
        PieData pieData2 = new PieData();
        pieData2.setAngle(90);
        pieData2.setColor(mColors[2]);
        mData.add(pieData2);
        PieData pieData3 = new PieData();
        pieData3.setAngle(90);
        pieData3.setColor(mColors[3]);
        mData.add(pieData3);
    }
}
