package com.wujie.customviewlearn.anim;

import android.animation.TypeEvaluator;

/**
 * Created by wujie
 * on 2018/12/30/030.
 */
public class MyTypeEvaluator implements TypeEvaluator<Float> {
    @Override
    public Float evaluate(float fraction, Float startValue, Float endValue) {
        return 200+startValue+fraction*(endValue - startValue);
    }
}
