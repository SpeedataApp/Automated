package com.speedata.automated.battery;

import android.os.Bundle;

import com.speedata.automated.BaseActivity;
import com.speedata.automated.R;

public class BatteryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_battery);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_battery;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }
}
