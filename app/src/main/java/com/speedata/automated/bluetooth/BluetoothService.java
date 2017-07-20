package com.speedata.automated.bluetooth;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.speedata.automated.utils.Logcat;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class BluetoothService extends Service {
    private Disposable mDisposable;
    public BluetoothService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startStatistics();
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        mDisposable.dispose();
        super.onDestroy();
    }

    /**
     * 开始统计.
     */
    private void startStatistics() {
        mDisposable = Observable.interval(5, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> getAndSaveInfo());
    }

    private void getAndSaveInfo() {
        Logcat.d("get bluetooth info --------------------------------");
    }
}
