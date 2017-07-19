package com.speedata.automated.sim;

import android.os.Bundle;

import com.speedata.automated.BaseActivity;
import com.speedata.automated.R;

public class SimActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sim);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_sim;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }
}
