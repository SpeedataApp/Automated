package com.speedata.automated.battery;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.os.IBinder;

import com.speedata.automated.AppAutomated;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * ----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 *
 * @author :Reginer in  2017/7/21 5:41.
 *         联系方式:QQ:282921012
 *         功能描述:获取电量信息Service
 */
public class BatteryService extends Service {
    private Disposable mDisposable;

    public BatteryService() {
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
        mDisposable = Observable.interval(5, TimeUnit.MINUTES)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> getAndSaveInfo());
    }

    /**
     * 获取信息并保存.
     */
    private void getAndSaveInfo() {
        Battery battery = new Battery();
        BatteryDao mBatteryDao = AppAutomated.getInstance().getDaoSession().getBatteryDao();
        BatteryManager mBatteryManager = (BatteryManager) getSystemService(Context.BATTERY_SERVICE);
        battery.setLevel(mBatteryManager.getLongProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY));
        battery.setTime(System.currentTimeMillis());
        mBatteryDao.insertOrReplace(battery);
    }
}
