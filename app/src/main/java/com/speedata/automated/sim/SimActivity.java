package com.speedata.automated.sim;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.speedata.automated.AppAutomated;
import com.speedata.automated.BaseActivity;
import com.speedata.automated.R;

import java.util.ArrayList;
import java.util.List;

import win.reginer.rv.RRecyclerView;

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
 * @author :Reginer in  2017/8/2 4:29.
 *         联系方式:QQ:282921012
 *         功能描述:sim信息显示
 */
public class SimActivity extends BaseActivity {

    private SimAdapter mAdapter;
    private List<Sim> mList;
    private SimDao mSimDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sim);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_sim;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mSimDao = AppAutomated.getInstance().getDaoSession().getSimDao();
        mList = new ArrayList<>();
        mAdapter = new SimAdapter(this, mList);
        RRecyclerView mRecyclerView = findViewById(R.id.rv_content);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.addHeaderView(LayoutInflater.from(this).inflate(R.layout.view_item_sim_layout, new LinearLayout(this), false));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mList.clear();
        mList.addAll(mSimDao.loadAll());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sim, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_clear:
                mSimDao.deleteAll();
                onResume();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
