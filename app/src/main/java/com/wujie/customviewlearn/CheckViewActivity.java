package com.wujie.customviewlearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class CheckViewActivity extends AppCompatActivity implements View.OnClickListener{

    CheckView mCheckView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_view);
        initView();
    }

    private void initView() {
        mCheckView = (CheckView) findViewById(R.id.checkView);
        findViewById(R.id.check_btn).setOnClickListener(this);
        findViewById(R.id.uncheck_btn).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.uncheck_btn:
                mCheckView.unCheck();
                break;
            case R.id.check_btn:
                mCheckView.check();
                break;
        }
    }
}
