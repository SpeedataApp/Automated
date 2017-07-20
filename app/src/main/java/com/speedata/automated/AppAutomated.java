package com.speedata.automated;

import android.app.Application;

import com.speedata.automated.datebase.DbHelper;
import com.speedata.automated.setting.ConstantsValue;
import com.speedata.automated.wifi.DaoMaster;
import com.speedata.automated.wifi.DaoSession;

import org.greenrobot.greendao.database.Database;

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
 * @author :Reginer in  2017/7/20 4:13.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class AppAutomated extends Application {

    private static AppAutomated sAppAutomated;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppAutomated = this;

        init();
    }

    private void init() {
        DbHelper helper = new DbHelper(this, ConstantsValue.DB_NAME, null);
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public static AppAutomated getInstance() {
        return sAppAutomated;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
