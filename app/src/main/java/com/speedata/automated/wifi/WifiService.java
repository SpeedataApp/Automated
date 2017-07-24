package com.speedata.automated.wifi;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
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
 * @author :Reginer in  2017/7/20 1:50.
 *         联系方式:QQ:282921012
 *         功能描述:wifi 信息收集Service
 */
public class WifiService extends Service {

    private Disposable mDisposable;

    public WifiService() {
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

    /**
     * 获取信息并保存.
     */
    private void getAndSaveInfo() {
        Wifi wifi = new Wifi();
        WifiDao mWifiDao = AppAutomated.getInstance().getDaoSession().getWifiDao();
        WifiManager mWifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        WifiInfo mWifiInfo = mWifiManager.getConnectionInfo();
        wifi.setLevel(mWifiInfo.getRssi());
        wifi.setTime(System.currentTimeMillis());
        mWifiDao.insertOrReplace(wifi);
    }
}
