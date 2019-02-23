package com.wujie.customviewlearn;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import com.wujie.customviewlearn.activity.MagicCircleActivity;
import com.wujie.customviewlearn.activity.Main2Activity;
import com.wujie.customviewlearn.activity.PrimaryColorActivity;
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
        findViewById(R.id.btn_primaryColor).setOnClickListener(this);


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
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(getApplicationContext(),R.anim
                .set);
        AnimationSet animationSet1 = new AnimationSet(true);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1f);

        ScaleAnimation scaleAnimation1 = new ScaleAnimation(0,1.4f,0,1.4f,Animation
                .RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        TranslateAnimation translateAnimation = new TranslateAnimation(0,1f, 0,1f);
        RotateAnimation rotateAnimation = new RotateAnimation(0,180, 50,50);
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setAnimator(LayoutTransition.APPEARING, animator);
        layoutTransition.addTransitionListener(new LayoutTransition.TransitionListener() {
            @Override
            public void startTransition(LayoutTransition transition, ViewGroup container, View
                    view, int transitionType) {

            }

            @Override
            public void endTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_radar:
                showDialog();
                intent.setClass(this, Main2Activity.class);
                break;
            case R.id.btn_magic_circle:
                intent.setClass(this, MagicCircleActivity.class);
                break;
            case R.id.btn_wave_view:
                intent.setClass(this, WaveViewActivity.class);
                break;
            case R.id.btn_primaryColor:
                intent.setClass(this, PrimaryColorActivity.class);
                break;
        }
        startActivity(intent);
//        startActivityForResult(intent, 12);
//        Thread daemonThread = new Thread();
//        daemonThread.setDaemon(true);
//        daemonThread.start();


    }
    public class ObjectEvaluator implements TypeEvaluator {

        @Override
        public Object evaluate(float fraction, Object startValue, Object endValue) {
            return null;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("wuwu", "requestCode:"+requestCode+"resultCode"+resultCode);
        Toast.makeText(this, "requestCode:"+requestCode+"resultCode"+resultCode, Toast
                .LENGTH_LONG).show();
    }


    public void showDialog() {
        String[] items = {"第一个", "第二个", "第三个", "第四个", "第五个", "第六个", "第七个", "第八个", "第九个",
                "第一个", "第二个", "第三个", "第四个", "第五个", "第六个", "第七个", "第八个", "第九个"};
//        new AlertDialog.Builder(MainActivity.this)
//                .setTitle("这是一个普通的对话框")
////                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialog, int which) {
////                        Toast.makeText(getApplicationContext(), "选择了第"+which+"个", Toast
////                                .LENGTH_SHORT)
////                                .show();
////
////                    }
////                })
//                .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                        Toast.makeText(getApplicationContext(), "选择了第"+which+"个", Toast
//                                .LENGTH_SHORT)
//                                .show();
//                    }
//                })
//
//                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(), "点击了确定", Toast.LENGTH_SHORT).show();
//                        dialog.dismiss();
//                    }
//                })
//                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(), "点击了取消", Toast.LENGTH_SHORT)
//                                .show();
//                        dialog.dismiss();
//                    }
//                })
//                .setNeutralButton("中立", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(), "点击了中立", Toast.LENGTH_SHORT)
//                                .show();
//                        dialog.dismiss();
//                    }
//                })
//                .setCancelable(false)
//                .show();

        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMax(100);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setMessage("加载中...");
        dialog.setIndeterminate(true);
        dialog.setCancelable(true);
        dialog.show();

    }
}
