package com.wujie.customviewlearn.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.wujie.customviewlearn.R;

/**
 * Created by wujie
 * on 2019/1/2/002.
 * 通过属性动画实现波浪扩散
 */
public class WaveView extends RelativeLayout {

    private Circle circle1;
    private Circle circle2;
    private Circle circle3;
    private AnimatorSet animatorSet;

    public WaveView(Context context) {
        this(context, null);
    }

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_wave_view, this, true);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        circle1 = findViewById(R.id.circle1);
        circle2 = findViewById(R.id.circle2);
        circle3 = findViewById(R.id.circle3);
    }



    public void startAnimation() {
        if (animatorSet == null) {
            PropertyValuesHolder radiusHolder = PropertyValuesHolder.ofInt("radius", 100,200);
            PropertyValuesHolder alphaHolder = PropertyValuesHolder.ofInt("color",255, 0);
            ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(circle1,
                    alphaHolder,radiusHolder);
            objectAnimator.setDuration(1500);
            objectAnimator.setRepeatMode(ValueAnimator.RESTART);
            objectAnimator.setRepeatCount(ValueAnimator.INFINITE);

            ObjectAnimator objectAnimator1 = objectAnimator.clone();
            objectAnimator1.setTarget(circle2);
            objectAnimator1.setStartDelay(500);

            ObjectAnimator objectAnimator2 = objectAnimator.clone();
            objectAnimator2.setTarget(circle3);
            objectAnimator2.setStartDelay(1000);

            animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimator, objectAnimator1, objectAnimator2);
        }
        if (!animatorSet.isRunning()) {
            animatorSet.start();
        }
    }

    public void cancelAnimation() {
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }


}
