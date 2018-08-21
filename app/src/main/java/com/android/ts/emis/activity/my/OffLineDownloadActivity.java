package com.android.ts.emis.activity.my;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 设置-离线下载
 *
 * @author pujiang
 * @date 2018-4-13 16:47
 * @mail 515210530@qq.com
 * @Description:
 */
public class OffLineDownloadActivity extends BaseActivity {
    @BindView(R.id.tv_deviceState)
    TextView tvDeviceState;
    @BindView(R.id.tv_deviceTypeState)
    TextView tvDeviceTypeState;
    @BindView(R.id.tv_locationState)
    TextView tvLocationState;
    @BindView(R.id.tv_departmentState)
    TextView tvDepartmentState;
    @BindView(R.id.tv_priorityState)
    TextView tvPriorityState;
    @BindView(R.id.tv_workProcessState)
    TextView tvWorkProcessState;
    @BindView(R.id.tv_serverTypeState)
    TextView tvServerTypeState;
    @BindView(R.id.tv_demandTypeState)
    TextView tvDemandTypeState;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_offline_download);
        ButterKnife.bind(this);

        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_set_download_title), null, true);
    }

    @OnClick({R.id.rly_deviceInfo, R.id.rly_deviceTypeInfo, R.id.rly_locationInfo, R.id.rly_departmentInfo,
            R.id.rly_priorityInfo, R.id.rly_workProcessInfo, R.id.rly_serverTypeInfo, R.id.rly_demandTypeInfo,
            R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rly_deviceInfo:
                break;
            case R.id.rly_deviceTypeInfo:
                break;
            case R.id.rly_locationInfo:
                break;
            case R.id.rly_departmentInfo:
                break;
            case R.id.rly_priorityInfo:
                break;
            case R.id.rly_workProcessInfo:
                break;
            case R.id.rly_serverTypeInfo:
                break;
            case R.id.rly_demandTypeInfo:
                break;
            case R.id.btn_next:
                setDownLoadState();
                break;
        }
    }

    /**
     * 设置下载状态
     */
    private void setDownLoadState() {
        tvDeviceState.setText(getResources().getString(R.string.text_set_download_state_d));
        tvDeviceTypeState.setText(getResources().getString(R.string.text_set_download_state_d));
        tvLocationState.setText(getResources().getString(R.string.text_set_download_state_d));
        tvDepartmentState.setText(getResources().getString(R.string.text_set_download_state_d));
        tvPriorityState.setText(getResources().getString(R.string.text_set_download_state_d));
        tvWorkProcessState.setText(getResources().getString(R.string.text_set_download_state_d));
        tvServerTypeState.setText(getResources().getString(R.string.text_set_download_state_d));
        tvDemandTypeState.setText(getResources().getString(R.string.text_set_download_state_d));
        tvDeviceState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
        tvDeviceTypeState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
        tvLocationState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
        tvDepartmentState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
        tvPriorityState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
        tvWorkProcessState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
        tvServerTypeState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
        tvDemandTypeState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
    }
}
