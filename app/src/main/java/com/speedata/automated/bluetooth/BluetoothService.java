package com.speedata.automated.bluetooth;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class BluetoothService extends Service {
    public BluetoothService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
