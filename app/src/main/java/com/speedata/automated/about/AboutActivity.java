package com.speedata.automated.about;

import android.os.Bundle;

import com.speedata.automated.BaseActivity;
import com.speedata.automated.R;

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_about);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_about;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }
}
