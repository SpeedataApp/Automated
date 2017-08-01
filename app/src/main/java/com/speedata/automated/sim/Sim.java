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
    private int cdma;
    private int lte;
    @Generated(hash = 256084327)
    public Sim(Long id, long time, int cdma, int lte) {
        this.id = id;
        this.time = time;
        this.cdma = cdma;
        this.lte = lte;
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
    public int getCdma() {
        return this.cdma;
    }
    public void setCdma(int cdma) {
        this.cdma = cdma;
    }
    public int getLte() {
        return this.lte;
    }
    public void setLte(int lte) {
        this.lte = lte;
    }
}
