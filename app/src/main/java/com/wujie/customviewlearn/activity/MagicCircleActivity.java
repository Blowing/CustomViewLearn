package com.wujie.customviewlearn.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wujie.customviewlearn.MagicCircle;
import com.wujie.customviewlearn.R;

public class MagicCircleActivity extends AppCompatActivity {

    private MagicCircle circle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_circle);
        circle = findViewById(R.id.circle);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circle.startAnimation();
            }
        });
    }
}
