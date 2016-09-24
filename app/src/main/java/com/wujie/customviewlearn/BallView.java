package com.wujie.customviewlearn;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by wujie on 2016/6/24.
 */
public class BallView extends View{
    private int radius;
    private int color;
    private int cX;
    private int cY;
    private Paint mPaint;
    public BallView(Context context) {
        this(context,null);
    }

    public BallView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BallView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.CustomView);
        radius = array.getInt(R.styleable.CustomView_customViewRadius, 30);
        color = array.getColor(R.styleable.CustomView_customViewColor,0xff9c27b0);
        array.recycle();
        mPaint = new Paint();
        mPaint.setColor(color);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        int centerX =  (int)radius + getLeft();
//        int centerY = (int)radius + getTop();
        cY = (int)radius +getTop();
        canvas.drawCircle(cX,cY,radius,mPaint);
    }

    public  void start() {
        ValueAnimator objectAnimator = ValueAnimator.ofInt(10,480,200);
        objectAnimator.setDuration(6000);
        objectAnimator.setInterpolator(new AccelerateInterpolator());


        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.setRepeatCount(ValueAnimator.REVERSE);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                cX = (int)animation.getAnimatedValue();
                invalidate();
            }
        });
        objectAnimator.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        if(widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = (int) radius*2 + getLeft() + getRight();
        }

        if(heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = (int) radius*2 + getTop() + getBottom();
        }
        setMeasuredDimension(width, height);
    }
}
