package com.speedata.automated.sim;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.CellInfoGsm;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.TelephonyManager;

import com.speedata.automated.AppAutomated;
import com.speedata.automated.utils.Logcat;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class SimService extends Service {
    private Disposable mDisposable;

    public SimService() {
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
        Sim sim = new Sim();
        SimDao mSimDao = AppAutomated.getInstance().getDaoSession().getSimDao();
        TelephonyManager telephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        if (TelephonyManager.SIM_STATE_READY == telephonyManager.getSimState()) {
            CellInfoGsm cellinfogsm = (CellInfoGsm) telephonyManager.getAllCellInfo().get(0);
            CellSignalStrengthGsm cellSignalStrengthGsm = cellinfogsm.getCellSignalStrength();
            sim.setLevel(cellSignalStrengthGsm.getDbm());
            sim.setTime(System.currentTimeMillis());
            mSimDao.insertOrReplace(sim);
        } else {
            Logcat.d("sim 卡不存在————————");
        }
    }
}
