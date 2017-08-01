package com.speedata.automated.sim;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

import com.speedata.automated.AppAutomated;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class SimService extends Service {
    private Disposable mDisposable;
    private SimDao mSimDao;
    private int cdma;
    private int lte;
    private SimStateListener mSimStateListener;

    public SimService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mSimStateListener = new SimStateListener();
        mSimDao = AppAutomated.getInstance().getDaoSession().getSimDao();
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        assert telephonyManager != null;
        telephonyManager.listen(mSimStateListener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
        startStatistics();
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        mDisposable.dispose();
        mSimStateListener = null;
        super.onDestroy();
    }

    /**
     * 开始统计.
     */
    private void startStatistics() {
        mDisposable = Observable.interval(10, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> getAndSaveInfo());
    }

    @SuppressLint("MissingPermission")
    private void getAndSaveInfo() {
        Sim sim = new Sim();
        sim.setCdma(cdma);
        sim.setLte(lte);
        sim.setTime(System.currentTimeMillis());
        mSimDao.insertOrReplace(sim);
    }

    private class SimStateListener extends PhoneStateListener {
        @Override
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            cdma = signalStrength.getCdmaDbm();
            lte = signalStrength.getEvdoDbm();
        }
    }
}
