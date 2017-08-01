package com.speedata.automated.sim;

import android.content.Context;
import android.text.format.DateUtils;

import com.speedata.automated.R;
import com.speedata.automated.utils.TimeUtils;

import java.util.List;

import win.reginer.rv.CommonAdapter;
import win.reginer.rv.adapter.BaseViewHolder;

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
 * @author :Reginer in  2017/8/2 4:30.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class SimAdapter extends CommonAdapter<Sim> {
    SimAdapter(Context context, List<Sim> data) {
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, Sim item, int position) {
          holder.setText(R.id.tv_time,  DateUtils.formatDateTime(holder.getView().getContext(), item.getTime(), DateUtils.FORMAT_SHOW_TIME));
          holder.setText(R.id.tv_time, TimeUtils.millis2String(item.getTime()));
          holder.setText(R.id.tv_cdma,item.getCdma()+"dBm");
          holder.setText(R.id.tv_lte,item.getLte()+"dBm");
    }

    @Override
    protected int getItemViewLayoutId(int position, Sim item) {
        return R.layout.view_item_sim_layout;
    }
}
