package com.wujie.customviewlearn;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/10/24.
 */
public class RoateImageView extends ImageView{
    public RoateImageView(Context context) {
        super(context);
    }

    public RoateImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        start();
    }

    public void start() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "rotation", 360.0f, 0.0f);
        animator.setDuration(1000);
        animator.setInterpolator(new LinearInterpolator());//不停顿
        animator.setRepeatCount(-1);//设置动画重复次数
        animator.setRepeatMode(ValueAnimator.RESTART);//动画重复模式
        animator.start();//开始动画
    }
}
