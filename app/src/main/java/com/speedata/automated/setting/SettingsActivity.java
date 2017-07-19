package com.speedata.automated.setting;

import android.os.Bundle;

import com.speedata.automated.BaseActivity;
import com.speedata.automated.R;

public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_settings);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_settings;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }
}
