package com.wujie.customviewlearn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wujie on 2016/10/25.
 */
public class wheelView extends View {

    private Paint paint;
    private int maxWidth = 255;
    // 是否运行
    private boolean isStarting = false;
    private List<String> alphaList = new ArrayList<String>();
    private List<String> startWidthList = new ArrayList<String>();
    private List<String> circlWidthList = new ArrayList<>();
    private List<String> basicAlphaList = new ArrayList<>();


    public wheelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // TODO Auto-generated constructor stub

        init(context);
    }

    public wheelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        init(context);
    }

    public wheelView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        init(context);
    }

    private void init(Context mContext) {
        paint = new Paint();
        // 设置博文的颜色


        alphaList.add("90");// 圆心的不透明度
//        alphaList.add("61");
//        alphaList.add("38");
//        alphaList.add("25");
//        alphaList.add("15");
//        circlWidthList.add(String.valueOf(Utils.dip2px(mContext, 20)));
//        circlWidthList.add(String.valueOf(Utils.dip2px(mContext, 30)));
//        circlWidthList.add(String.valueOf(Utils.dip2px(mContext, 40)));
//        circlWidthList.add(String.valueOf(Utils.dip2px(mContext, 56)));
//        circlWidthList.add(String.valueOf(Utils.dip2px(mContext, 82)));
//        circlWidthList.add("80");
//        circlWidthList.add("120");
//        circlWidthList.add("160");
//        circlWidthList.add("224");
//        circlWidthList.add("328");
        basicAlphaList.add("90");// 圆心的不透明度
        basicAlphaList.add("61");
        basicAlphaList.add("38");
        basicAlphaList.add("25");
        basicAlphaList.add("15");
        basicAlphaList.add("0");

        startWidthList.add("0");
        paint.setAntiAlias(true);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(Color.TRANSPARENT);// 颜色：完全透明
        // 依次绘制 同心圆
        for (int i = 0; i < startWidthList.size(); i++) {
            float alpha = Float.valueOf(alphaList.get(i));
            // 圆半径
            int startWidth = Integer.parseInt(startWidthList.get(i));
            paint.setAlpha((int) alpha);
            int[] colors = new int[]{0x612C9E, 0x855BB5, 0xB59BD4, 0xF9F4FE};

                RadialGradient radialGradient = new RadialGradient(getWidth() / 2, getHeight() / 2, startWidth+50+i*5,
                        new int[]{0xff612C9E, 0xff855BB5, 0xffB59BD4, 0xffF9F4FE}, new float[]{0.0f, 0.7f, 0.9f, 1f}
                        , Shader.TileMode.CLAMP);
                paint.setShader(radialGradient);
          if(alphaList.size() > 4 & i < alphaList.size()-4) {
              paint.setStyle(Paint.Style.STROKE);
          } else {
              paint.setStyle(Paint.Style.FILL);
          }
            // 这个半径决定你想要多大的扩散面积
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, startWidth+50+i*5,
                    paint);
            // 同心圆扩散
            if (isStarting && alpha > 0 ) {
                switch (i) {
                    case 0:
                        alphaList.set(i, (alpha  - 0.6) + "");
                        break;
                    case 1:
                        alphaList.set(i, (alpha  - 0.4) + "");
                        break;
                    case 2:
                        alphaList.set(i, (alpha  - 0.3) + "");
                        break;
                    case 3:
                        alphaList.set(i, (alpha  - 0.5) + "");
                        break;
                    case 4:
                        alphaList.set(i, (alpha  - 0.1) + "");
                        break;
                    case 5:
                        alphaList.set(i, (alpha  - 0.1) + "");
                        break;
                    case 7:
                        alphaList.set(i, (alpha  - 0.1) + "");
                        break;
//
              }
                if(alpha == 0 ) {
                    alphaList.set(i, "15");
                }

                startWidthList.set(i, (startWidth + 1) + "");
            }
        }
        if (isStarting
                && Integer
                .parseInt(startWidthList.get(startWidthList.size() - 1)) == 50) {
//            if(alphaList.size() >= 4) {
//                alphaList.add("15");
//            }else {
                alphaList.add("90");
//            }
            startWidthList.add("0");
        }
        // 同心圆数量达到10个，删除最外层圆
        if (isStarting && startWidthList.size() == 8) {
            startWidthList.remove(0);
            alphaList.remove(0);
        }
        // 刷新界面
        invalidate();
    }

    // 执行动画
    public void start() {
        isStarting = true;
    }

    // 停止动画
    public void stop() {
        isStarting = false;
    }

    // 判断是都在不在执行
    public boolean isStarting() {
        return isStarting;
    }

}
