package com.speedata.automated.sim;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SimService extends Service {
    public SimService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
