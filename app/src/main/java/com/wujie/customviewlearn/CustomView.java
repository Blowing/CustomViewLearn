package com.wujie.customviewlearn;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wujie on 2016/6/22.
 */
public class CustomView extends View{
    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
       invalidate();

    }

    public void setColor(int color) {
        this.color = color;

    }

    private int color;
    private float radius;
    private Rect mBound;

    public int getColor() {
        return color;
    }

    private Paint mPaint;
    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.CustomView);
        color = array.getInt(R.styleable.CustomView_customViewColor, 0xff9c27b0);
        radius = array.getDimension(R.styleable.CustomView_customViewRadius, 3);
        array.recycle();
        mPaint = new Paint();
        mPaint.setColor(color);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mBound = new Rect();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int centerX =  (int)radius + getLeft();
        int centerY = (int)radius + getTop();

        canvas.drawCircle(centerX,centerY,radius,mPaint);
        canvas.drawCircle(centerX + radius*3,centerY,radius,mPaint);
        canvas.drawCircle(centerX + radius*7,centerY,radius,mPaint);
        canvas.drawCircle(centerX + radius*11,centerY,radius,mPaint);
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(centerX,centerY-10,centerX+1000,centerY+10,mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heigthSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;

        if(widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = (int)radius*2+1 + getPaddingLeft() + getPaddingRight();
        }

        if(heightMode == MeasureSpec.EXACTLY) {
            height = heigthSize;
        } else {
            height = (int)radius*2+1 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(width,height);

    }


}
