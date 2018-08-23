package com.android.ts.emis.activity.my;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.mvp.iface.IConfigureInfo;
import com.android.ts.emis.mvp.impl.ConfigureInfoImpl;
import com.android.ts.emis.utils.SPUtil;
import com.libcommon.action.mode.BaseBean;
import com.libcommon.action.net.INetWorkCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Headers;

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

    private IConfigureInfo iConfigureInfo;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_offline_download);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_set_download_title), null, true);
        if (!TextUtils.isEmpty(SPUtil.INSTANCE.getString(StrRes.INSTANCE.getEquipmentJson()))) {
            tvDeviceState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
            tvDeviceState.setText(getResources().getString(R.string.text_set_download_state_d));
        }
        if (!TextUtils.isEmpty(SPUtil.INSTANCE.getString(StrRes.INSTANCE.getEquipmentTypeJson()))) {
            tvDeviceTypeState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
            tvDeviceTypeState.setText(getResources().getString(R.string.text_set_download_state_d));
        }
        if (!TextUtils.isEmpty(SPUtil.INSTANCE.getString(StrRes.INSTANCE.getEstateJson()))) {
            tvLocationState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
            tvLocationState.setText(getResources().getString(R.string.text_set_download_state_d));
        }
        if (!TextUtils.isEmpty(SPUtil.INSTANCE.getString(StrRes.INSTANCE.getBuJson()))) {
            tvDepartmentState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
            tvDepartmentState.setText(getResources().getString(R.string.text_set_download_state_d));
        }
        if (!TextUtils.isEmpty(SPUtil.INSTANCE.getString(StrRes.INSTANCE.getPriorityJson()))) {
            tvPriorityState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
            tvPriorityState.setText(getResources().getString(R.string.text_set_download_state_d));
        }
        if (!TextUtils.isEmpty(SPUtil.INSTANCE.getString(StrRes.INSTANCE.getSlaJson()))) {
            tvWorkProcessState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
            tvWorkProcessState.setText(getResources().getString(R.string.text_set_download_state_d));
        }
        if (!TextUtils.isEmpty(SPUtil.INSTANCE.getString(StrRes.INSTANCE.getTicketTypeJson()))) {
            tvServerTypeState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
            tvServerTypeState.setText(getResources().getString(R.string.text_set_download_state_d));
        }
        if (!TextUtils.isEmpty(SPUtil.INSTANCE.getString(StrRes.INSTANCE.getTaskTypeJson()))) {
            tvDemandTypeState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
            tvDemandTypeState.setText(getResources().getString(R.string.text_set_download_state_d));
        }
    }

    @OnClick({R.id.rly_deviceInfo, R.id.rly_deviceTypeInfo, R.id.rly_locationInfo, R.id.rly_departmentInfo,
            R.id.rly_priorityInfo, R.id.rly_workProcessInfo, R.id.rly_serverTypeInfo, R.id.rly_demandTypeInfo,
            R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rly_deviceInfo:
                getResponseData("equipment");
                break;
            case R.id.rly_deviceTypeInfo:
                getResponseData("equipmenttype");
                break;
            case R.id.rly_locationInfo:
                getResponseData("estate");
                break;
            case R.id.rly_departmentInfo:
                getResponseData("bu");
                break;
            case R.id.rly_priorityInfo:
                getResponseData("priority");
                break;
            case R.id.rly_workProcessInfo:
                getResponseData("sla");
                break;
            case R.id.rly_serverTypeInfo:
                getResponseData("tickettype");
                break;
            case R.id.rly_demandTypeInfo:
                getResponseData("tasktype");
                break;
            case R.id.btn_next:
                setDownLoadState("equipment");
                setDownLoadState("equipmenttype");
                setDownLoadState("estate");
                setDownLoadState("bu");
                setDownLoadState("priority");
                setDownLoadState("sla");
                setDownLoadState("tickettype");
                setDownLoadState("tasktype");
                break;
        }
    }

    /**
     * 设置下载状态
     */
    private void setDownLoadState(String dataType) {
        if ("equipment".equals(dataType)) {
            tvDeviceState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
            tvDeviceState.setText(getResources().getString(R.string.text_set_download_state_d));
        } else if ("equipmenttype".equals(dataType)) {
            tvDeviceTypeState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
            tvDeviceTypeState.setText(getResources().getString(R.string.text_set_download_state_d));
        } else if ("estate".equals(dataType)) {
            tvLocationState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
            tvLocationState.setText(getResources().getString(R.string.text_set_download_state_d));
        } else if ("bu".equals(dataType)) {
            tvDepartmentState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
            tvDepartmentState.setText(getResources().getString(R.string.text_set_download_state_d));
        } else if ("priority".equals(dataType)) {
            tvPriorityState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
            tvPriorityState.setText(getResources().getString(R.string.text_set_download_state_d));
        } else if ("sla".equals(dataType)) {
            tvWorkProcessState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
            tvWorkProcessState.setText(getResources().getString(R.string.text_set_download_state_d));
        } else if ("tickettype".equals(dataType)) {
            tvServerTypeState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
            tvServerTypeState.setText(getResources().getString(R.string.text_set_download_state_d));
        } else if ("tasktype".equals(dataType)) {
            tvDemandTypeState.setTextColor(getResources().getColor(R.color.text_blue_heigh));
            tvDemandTypeState.setText(getResources().getString(R.string.text_set_download_state_d));
        }
    }

    private void getResponseData(String dataType) {
        showLoadingDialog();
        if (iConfigureInfo == null)
            iConfigureInfo = new ConfigureInfoImpl();
        iConfigureInfo.getGetOfflineDataInfo(getApplicationContext(), new INetWorkCallBack() {
            @Override
            public void noNetWork() {
                hideLoading();
            }

            @Override
            public <T> void onSuccess(T t, Headers headers, Class cla, String constantUrl) {
                hideLoading();
                BaseBean baseBean = (BaseBean) t;
                if (baseBean == null) return;
                if (!"success".equals(baseBean.getStatus())) {
                    showToast(baseBean.getMessage());
                    return;
                }
                setDownLoadState(constantUrl);
            }

            @Override
            public void onError(int status, String str, Class cla, String constantUrl) {
                hideLoading();
            }
        }, dataType);
    }
}
