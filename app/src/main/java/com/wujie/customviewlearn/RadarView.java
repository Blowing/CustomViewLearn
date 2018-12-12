package com.wujie.customviewlearn;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wujie
 * on 2018/12/12/012.
 * https://blog.csdn.net/crazy__chen/article/details/50163693
 * 一个雷达图显示分布的view
 */
public class RadarView extends View {
    private int count = 8;
    private float radius;
    private float angel;

    private int centerX;
    private int centerY;

    private String[] titles = {"a", "b", "c", "d", "e", "f","g", "h", "i"};

    public void setData(double[] data) {
        this.data = data;
    }

    private double[] data = {100, 60, 60, 60, 35, 20, 45, 52, 96};
    private int maxValue = 100;
    private Paint mainPaint;
    private Paint valuePaint;
    private Paint textPaint;


    public RadarView(Context context) {
        this(context, null);
    }

    public RadarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RadarView);
        count = typedArray.getInteger(R.styleable.RadarView_count, 6);
        angel = (float) (2*Math.PI/ count);
        typedArray.recycle();


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        centerX = MeasureSpec.getSize(widthMeasureSpec) / 2;
        centerY = MeasureSpec.getSize(heightMeasureSpec) / 2;
        radius  = (float) (Math.min(centerX, centerY)  * 0.9);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(centerX, centerY);
        drawPolygon(canvas);
        drawLine(canvas);
        drawRegion(canvas);
        drawTitle(canvas);


    }

    private void initPaint() {
        mainPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mainPaint.setStyle(Paint.Style.STROKE);
        valuePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        valuePaint.setColor(0x3F51B5);
        valuePaint.setAlpha(50);
        textPaint = new Paint();
    }

    private void drawPolygon(Canvas canvas) {
        float r  = radius / (count -1);
        Path path = new Path();
        Path path1;
        for (int i = 1; i < count; i++) {
            path1 = new Path();
            float curR = r*i;
            for (int j = 0; j < count; j++) {
                if (j == 0) {
                    path1.moveTo(curR, 0);
                } else {
                    float x = (float) (curR*Math.cos(angel*j));
                    float y = (float) (curR*Math.sin(angel*j));
                    path1.lineTo(x, y);
                }
            }
            path1.close();
            path.addPath(path1);
        }
        canvas.drawPath(path, mainPaint);
    }

    private void drawLine(Canvas canvas) {

        Path path = new Path();
        for (int i = 0; i < count; i++) {
            path.moveTo(0, 0);
            float x = (float) (radius * Math.cos(angel * i));
            float y = (float) (radius * Math.sin(angel * i));
            path.lineTo(x, y);
        }
        canvas.drawPath(path, mainPaint);
    }

    private void drawRegion(Canvas canvas) {
        Path path = new Path();
        for (int i = 0; i < count; i++) {
            double percent = data[i] / maxValue;
            float x = (float) (radius*Math.cos(angel * i) * percent);
            float y = (float) (radius*Math.sin(angel * i) * percent);
            if (i == 0) {
                path.moveTo(x, 0);
            } else {
                path.lineTo(x, y);
            }
            canvas.drawCircle(x, y, 10, valuePaint);
        }
        path.close();
        canvas.drawPath(path, valuePaint);
    }

    private void drawTitle(Canvas canvas) {
        textPaint.setTextSize(32);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();

        float fontHeight = (fontMetrics.descent -fontMetrics.ascent)/ 2;
        Path path = new Path();
        for (int i = 0; i < count; i++) {
            path.moveTo(0, 0);
            float x = (float) ((radius+fontHeight) * Math.cos(angel * i));
            float y = (float) ((radius+fontHeight)* Math.sin(angel * i));
            canvas.drawText(titles[i], x, y, textPaint);
        }
    }
}
