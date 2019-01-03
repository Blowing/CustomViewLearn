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
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(200, 200 , radius, paint);

    }


    public void setColor(int color) {
//        this.color = color;
        paint.setAlpha(color);
//        invalidate();
    }
}
