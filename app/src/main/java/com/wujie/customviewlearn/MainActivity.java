package com.wujie.customviewlearn;

import android.animation.AnimatorSet;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

import com.wujie.customviewlearn.activity.MagicCircleActivity;
import com.wujie.customviewlearn.activity.RadarViewActivity;
import com.wujie.customviewlearn.activity.WaveViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_radar).setOnClickListener(this);
        findViewById(R.id.btn_magic_circle).setOnClickListener(this);
        findViewById(R.id.btn_wave_view).setOnClickListener(this);

        AnimationDrawable drawable = new AnimationDrawable();
        ValueAnimator animator = ValueAnimator.ofInt(0, 3);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f,1.4f, 0.0f, 1.4f,Animation
                .RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        AnimationSet set = new AnimationSet(true);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                animation.getAnimatedValue();

            }
        });
        Keyframe scaleFrame1 = Keyframe.ofFloat(0f, 1f);
        Keyframe scaleFrame2 = Keyframe.ofFloat(0.5f, 2f);
        Keyframe scaleFrame3 = Keyframe.ofFloat(1.0f, 1.0f);
        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("scaleX", scaleFrame1,
                scaleFrame2, scaleFrame3);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(findViewById(R.id
                .btn_radar), holder);



//        Property<ImageView, Float> mScaleX = new Property<ImageView, Float>() {
//            @Override
//            public Float get(ImageView objec5t) {
//                return null;
//            }
//
//            @Override
//            public void set(ImageView object, Float value) {
//                super.set(object, value);
//            }
//        };
        animator.setTarget(findViewById(R.id.btn_radar));
        animator.setInterpolator(new AccelerateDecelerateInterpolator());

        animator.setEvaluator(new IntEvaluator());

        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet animatorSet1;



    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_radar:
                intent.setClass(this, RadarViewActivity.class);
                break;
            case R.id.btn_magic_circle:
                intent.setClass(this, MagicCircleActivity.class);
                break;
            case R.id.btn_wave_view:
                intent.setClass(this, WaveViewActivity.class);
                break;
        }
        startActivity(intent);

    }
    public class ObjectEvaluator implements TypeEvaluator {

        @Override
        public Object evaluate(float fraction, Object startValue, Object endValue) {
            return null;
        }
    }
}
