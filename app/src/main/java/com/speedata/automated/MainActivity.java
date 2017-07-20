package com.speedata.automated;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.speedata.automated.about.AboutActivity;
import com.speedata.automated.battery.BatteryActivity;
import com.speedata.automated.battery.BatteryService;
import com.speedata.automated.bluetooth.BluetoothActivity;
import com.speedata.automated.bluetooth.BluetoothService;
import com.speedata.automated.setting.SettingsActivity;
import com.speedata.automated.sim.SimActivity;
import com.speedata.automated.sim.SimService;
import com.speedata.automated.wifi.WifiActivity;
import com.speedata.automated.wifi.WifiService;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Intent mBatteryIntent;
    private Intent mSimIntent;
    private Intent mWifiIntent;
    private Intent mBlueBoothIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        startStatisticsService();
    }

    /**
     * 开启统计Service.
     */
    private void startStatisticsService() {
        mBatteryIntent = new Intent(this, BatteryService.class);
        mSimIntent = new Intent(this, SimService.class);
        mWifiIntent = new Intent(this, WifiService.class);
        mBlueBoothIntent = new Intent(this, BluetoothService.class);
        startService(mBatteryIntent);
        startService(mSimIntent);
        startService(mWifiIntent);
        startService(mBlueBoothIntent);

    }

    /**
     * 结束统计Service.
     */
    private void stopStatisticsService() {
        stopService(mBatteryIntent);
        stopService(mSimIntent);
        stopService(mWifiIntent);
        stopService(mBlueBoothIntent);
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_battery:
                startActivity(new Intent(this, BatteryActivity.class));
                break;
            case R.id.nav_bluetooth:
                startActivity(new Intent(this, BluetoothActivity.class));
                break;
            case R.id.nav_sim:
                startActivity(new Intent(this, SimActivity.class));
                break;
            case R.id.nav_wifi:
                startActivity(new Intent(this, WifiActivity.class));
                break;
            case R.id.nav_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                break;
            case R.id.nav_about:
                startActivity(new Intent(this, AboutActivity.class));
                break;
            default:
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onDestroy() {
        stopStatisticsService();
        super.onDestroy();
    }


}
