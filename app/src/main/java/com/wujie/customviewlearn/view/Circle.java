package com.wujie.customviewlearn.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wujie
 * on 2019/1/2/002.
 */
public class Circle extends View {
    private int radius;
    private Paint paint;
    private int maxRadius = 200;

    private int defaultWidth = 400; // px
    private int defaultHeight = 400; // px

    private int w; // 实际View的宽度
    private int h; // 实际View的高度

    private int color = 0xFFfe626d;

    public Circle(Context context) {
        this(context, null);
    }

    public Circle(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        radius = maxRadius /2;
        paint.setColor(color);
    }

    public void setRadius(int radius) {
        this.radius = radius;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        w = (widthMode == MeasureSpec.AT_MOST ? Math.min(defaultWidth, widthSize) : widthSize);
        h = (heightMode == MeasureSpec.AT_MOST ? Math.min(defaultHeight, heightSize) : heightSize);
        setMeasuredDimension(w, h);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int pLeft = getPaddingLeft();
        int pRight = getPaddingRight();
        int pTop = getPaddingTop();
        int pBottom = getPaddingBottom();
//        radius = Math.min(Math.min((w-pLeft -pRight)/ 2, (h-pTop-pBottom)/2), radius);
        canvas.drawCircle((w-pLeft -pRight)/2 + pLeft, (h-pTop-pBottom)/2+ pTop , radius, paint);

    }


    public void setColor(int color) {
//        this.color = color;
        paint.setAlpha(color);
//        invalidate();
    }
}
