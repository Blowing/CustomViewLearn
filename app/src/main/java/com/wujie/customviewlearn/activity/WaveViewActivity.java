package com.wujie.customviewlearn.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wujie.customviewlearn.R;
import com.wujie.customviewlearn.view.WaveView;

public class WaveViewActivity extends AppCompatActivity implements View.OnClickListener {

    private WaveView waveView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave_view);
        waveView = findViewById(R.id.waveView);
        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_cancel).setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                waveView.startAnimation();

                break;
            case R.id.btn_cancel:
                waveView.cancelAnimation();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (waveView != null) {
            waveView.cancelAnimation();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        setResult(34);
        finish();
    }

//    @Override
//    public void onBackPressed() {
//        setResult(RESULT_OK);
//        super.onBackPressed();
//    }
}
