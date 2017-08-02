package com.speedata.automated.sim;

import android.support.annotation.Keep;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

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
 * @author :Reginer in  2017/7/21 3:47.
 *         联系方式:QQ:282921012
 *         功能描述:SIM信息实体类
 */
@Entity
@Keep
public class Sim {
    @Id(autoincrement = true)
    private Long id;
    private long time;
    private int dbm;
    private int asu;
    @Generated(hash = 117710677)
    public Sim(Long id, long time, int dbm, int asu) {
        this.id = id;
        this.time = time;
        this.dbm = dbm;
        this.asu = asu;
    }
    @Generated(hash = 2123750318)
    public Sim() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public long getTime() {
        return this.time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public int getDbm() {
        return this.dbm;
    }
    public void setDbm(int dbm) {
        this.dbm = dbm;
    }
    public int getAsu() {
        return this.asu;
    }
    public void setAsu(int asu) {
        this.asu = asu;
    }
   
}
