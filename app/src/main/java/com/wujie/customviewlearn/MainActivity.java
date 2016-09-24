package com.wujie.customviewlearn;

import android.animation.ObjectAnimator;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    private Handler mHandler = new Handler() {
//
//        @Override
//        public void handleMessage(Message msg) {
//            if(msg.what == 0x123) {
//                animator.start();
//            }
//        }
//    };
    CustomView customView1;
    Animation animation;
    ObjectAnimator animator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        CustomView customView = (CustomView) findViewById(R.id.custom);
//        animation = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
//        customView.startAnimation(animation);
//
//         customView1 = (CustomView) findViewById(R.id.custom1);
//        Button button = (Button) findViewById(R.id.btn);
//        ViewWrapper viewWrapper = new ViewWrapper(customView1);
//        animator = ObjectAnimator.ofFloat(customView1,"radius",15,50,15);
//        animator.setDuration(2000);
//        animator.start();
        final BallView ballView = (BallView) findViewById(R.id.ball);
        TextView textView1 = (TextView) findViewById(R.id.icon_text1);
        TextView textView2 = (TextView) findViewById(R.id.icon_text2);
        TextView textView3 = (TextView) findViewById(R.id.icon_text3);
        TextView textView4 = (TextView) findViewById(R.id.icon_text4);
        TextView textView5 = (TextView) findViewById(R.id.icon_text5);
        TextView textView6 = (TextView) findViewById(R.id.icon_text6);
        String [] image = getResources().getStringArray(R.array.icon_array);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "iconfont.ttf");
        textView1.setTypeface(typeface);textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        textView1.setText(image[0]);
        textView2.setTypeface(typeface);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        textView2.setText(image[1]);
        textView3.setTypeface(typeface);
        textView3.setText(image[2]);
        textView4.setTypeface(typeface);
        textView4.setText(image[3]);
        textView5.setTypeface(typeface);
        textView5.setText(image[4]);
        textView6.setTypeface(typeface);
        textView6.setText(image[5]);





         final HeartProgressBar heartProgressBar = (HeartProgressBar) findViewById(R.id.heartprogress);
          findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  heartProgressBar.start();
                  ballView.start();
              }
          });
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                animator.start();
//                if(heartProgressBar.isStopped()) {
//
//                    heartProgressBar.start();
//                } else {
//
//                    heartProgressBar.dismiss();
//                }
//            }
//        });
//
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                mHandler.sendEmptyMessage(0x123);
//            }
//        },0,2000);


    }

    private

    static class
    ViewWrapper {

        private

        View mTarget;


        public ViewWrapper(View target) {

            mTarget
                    = target;

        }


        public int
        getWidth() {

            return

                    mTarget.getLayoutParams().width;

        }


        public void
        setWidth(int

                         width) {

            mTarget.getLayoutParams().width
                    = width;

            mTarget.requestLayout();

        }

        public int
        getHeight() {

            return

                    mTarget.getLayoutParams().height;

        }


        public void
        setHeight(int

                         height) {

            mTarget.getLayoutParams().height
                    = height;

            mTarget.requestLayout();
            mTarget.requestLayout();

        }


    }
}
