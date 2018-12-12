package com.wujie.customviewlearn.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wujie.customviewlearn.R;
import com.wujie.customviewlearn.RadarView;

public class RadarViewActivity extends AppCompatActivity {

    private RadarView radarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radar_view);
        radarView = findViewById(R.id.radar_view);
        double[] data =  {45, 69, 74, 100, 87, 33, 44 ,66, 82,20};
        radarView.setData(data);
        radarView.invalidate();
    }
}
