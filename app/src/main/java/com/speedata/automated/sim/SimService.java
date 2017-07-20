package com.speedata.automated.sim;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.speedata.automated.utils.Logcat;

public class SimService extends Service {
    public SimService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logcat.d("SimService   start  ---------------------------------");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Logcat.d("SimService   destroy  ---------------------------------");
        super.onDestroy();
    }
}
