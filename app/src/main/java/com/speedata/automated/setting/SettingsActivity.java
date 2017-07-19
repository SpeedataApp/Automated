package com.speedata.automated.setting;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.speedata.automated.BaseActivity;
import com.speedata.automated.R;

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
 * @author :Reginer in  2017/7/20 3:13.
 *         联系方式:QQ:282921012
 *         功能描述:设置界面
 */
public class SettingsActivity extends BaseActivity implements View.OnClickListener {

    private int mTitle;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_settings);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_settings;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        findViewById(R.id.time_battery).setOnClickListener(this);
        findViewById(R.id.time_bluetooth).setOnClickListener(this);
        findViewById(R.id.time_sim).setOnClickListener(this);
        findViewById(R.id.time_wifi).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.time_battery:
                mTitle = R.string.set_battery_time;
                break;
            case R.id.time_bluetooth:
                mTitle = R.string.set_bluetooth_time;
                break;
            case R.id.time_sim:
                mTitle = R.string.set_sim_time;
                break;
            case R.id.time_wifi:
                mTitle = R.string.set_wifi_time;
                break;

            default:
                break;
        }
        mEditText = getEditText();
        AlertUtils.dialog(this, 0, mTitle, mEditText, mOkClickListener);
    }

    /**
     * 配置EditText.
     *
     * @return EditText
     */
    private EditText getEditText() {
        EditText editText = new EditText(this);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        InputFilter[] filters = {new InputFilter.LengthFilter(4)};
        editText.setFilters(filters);
        return editText;
    }

    /**
     * 确认事件.
     */
    private DialogInterface.OnClickListener mOkClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if (TextUtils.isEmpty(mEditText.getText().toString()) || Integer.parseInt(mEditText.getText().toString()) == 0) {
                ToastUtils.showShortToastSafe(R.string.operation_failed);
                return;
            }
            switch (mTitle) {
                case R.string.set_battery_time:
                    SPUtils.put(SettingsActivity.this, ConstantsValue.BATTERY_TIME, Integer.parseInt(mEditText.getText().toString()));
                    break;
                case R.string.set_bluetooth_time:
                    SPUtils.put(SettingsActivity.this, ConstantsValue.BLUETOOTH_TIME, Integer.parseInt(mEditText.getText().toString()));
                    break;
                case R.string.set_sim_time:
                    SPUtils.put(SettingsActivity.this, ConstantsValue.SIM_TIME, Integer.parseInt(mEditText.getText().toString()));
                    break;
                case R.string.set_wifi_time:
                    SPUtils.put(SettingsActivity.this, ConstantsValue.WIFI_TIME, Integer.parseInt(mEditText.getText().toString()));
                    break;

                default:
                    break;
            }
            ToastUtils.showShortToastSafe(R.string.operation_successful);
        }
    };
}
