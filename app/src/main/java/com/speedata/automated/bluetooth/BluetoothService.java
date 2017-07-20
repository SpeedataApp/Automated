package com.speedata.automated.bluetooth;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.speedata.automated.utils.Logcat;

public class BluetoothService extends Service {
    public BluetoothService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logcat.d("BluetoothService   start  ---------------------------------");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Logcat.d("BluetoothService   destroy  ---------------------------------");
        super.onDestroy();
    }
}
