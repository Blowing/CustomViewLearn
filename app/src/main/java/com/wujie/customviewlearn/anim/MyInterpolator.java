package com.wujie.customviewlearn.anim;


import android.view.animation.Interpolator;

/**
 * Created by wujie
 * on 2018/12/30/030.
 */
public class MyInterpolator implements Interpolator {

    @Override
    public float getInterpolation(float input) {
        return 1-input;
    }
}
