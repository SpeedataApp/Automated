package com.speedata.automated.battery;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class BatteryService extends Service {
    public BatteryService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
