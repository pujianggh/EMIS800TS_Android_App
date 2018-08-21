package com.android.ts.emis.activity.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.kotlinapp.action.config.StateType;
import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.adapter.SelectQueryListAdapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.DataStateQueryCenter;
import com.android.ts.emis.mode.MaintenancePlanInfoBean;
import com.android.ts.emis.mode.SelectInfoBean;
import com.android.ts.emis.mvp.iface.IConfigureInfo;
import com.android.ts.emis.mvp.impl.ConfigureInfoImpl;
import com.libcommon.action.net.INetWorkCallBack;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import okhttp3.Headers;

/**
 * 通用样式选择人员选择等
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class SelectQueryListActivity extends BaseActivity {
    @BindView(R.id.rl_root_refresh)
    BGARefreshLayout rlRootRefresh;
    @BindView(R.id.lv_listData)
    ListView lvListData;
    @BindView(R.id.lly_btnState)
    LinearLayout llyBtnState;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.btn_cancel)
    Button btnCancel;

    private SelectQueryListAdapter mAdapter;
    private SelectInfoBean moduleBean;
    private IConfigureInfo iConfigureInfo;
    private int stateType = StateType.INSTANCE.getPeopleInfo();
    private String mTicketsCode = "";

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_select_query_list);
        ButterKnife.bind(this);
        stateType = getIntent().getIntExtra(StrRes.INSTANCE.getType(), StateType.INSTANCE.getPeopleInfo());

        initData();
    }

    @OnClick({R.id.btn_next, R.id.btn_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next://确定
                setSelectData();
                break;
            case R.id.btn_cancel://取消
                setResult(RESULT_OK, null);
                onBackPressed();
                break;
        }
    }

    private void getResponseData() {
        if (stateType == StateType.INSTANCE.getPeopleInfo()) {
            setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_select_query_list_title), null, true);
            moduleBean = DataStateQueryCenter.getPGRYModuleData2();
            showLoading();
            if (iConfigureInfo == null)
                iConfigureInfo = new ConfigureInfoImpl();
            iConfigureInfo.getMaintenancePlanInfoLists(getApplicationContext(), new INetWorkCallBack() {
                @Override
                public void noNetWork() {
                    hideLoading();
                }

                @Override
                public <T> void onSuccess(T t, Headers headers, Class cla, String constantUrl) {
                    hideLoading();
                    MaintenancePlanInfoBean bean = (MaintenancePlanInfoBean) t;
                    if (bean != null && "success".equals(bean.getStatus())) {
                        if (bean.getData().getExecutorList() == null) return;
                        int size = bean.getData().getExecutorList().size();
                        SelectInfoBean dataBean = new SelectInfoBean();
                        List<SelectInfoBean.Data> list = new ArrayList<>();
                        SelectInfoBean.Data data;
                        for (int i = 0; i < size; i++) {
                            data = new SelectInfoBean.Data();
                            data.setName(bean.getData().getExecutorList().get(i).getExecutorName());
                            data.setCode(bean.getData().getExecutorList().get(i).getExecutorCode());
                            data.setPhone(bean.getData().getExecutorList().get(i).getTelephone());
                            list.add(data);
                            dataBean.setData(list);
                        }

                        mAdapter = new SelectQueryListAdapter(mContext);
                        lvListData.setAdapter(mAdapter);
                        mAdapter.setData(dataBean.getData());
                        mAdapter.setItemChecked(getIntent().getStringExtra(StrRes.INSTANCE.getSource()));
                    }
                }

                @Override
                public void onError(int status, String str, Class cla, String constantUrl) {
                    hideLoading();
                }
            }, mTicketsCode);
        }
    }

    private void initData() {
        mTicketsCode = "CM0218070008";
        getResponseData();
        rlRootRefresh.setRefreshViewHolder(new BGANormalRefreshViewHolder(mAPPApplication, true));
        rlRootRefresh.setDelegate(new BGARefreshLayout.BGARefreshLayoutDelegate() {
            @Override
            public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
                refreshLayout.endRefreshing();
                getResponseData();
            }

            @Override
            public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
                return false;
            }
        });
    }

    /**
     * 返回数据
     */
    public void setSelectData() {
        SelectInfoBean.Data selectModuleBean = mAdapter.getItemChecked();
        if (selectModuleBean == null) {
            showToast(getResources().getString(R.string.text_message_noselect));
            return;
        }
        if (selectModuleBean != null) {
            Intent intent = new Intent();
            intent.putExtra(StrRes.INSTANCE.getSource(), selectModuleBean.getName());
            setResult(RESULT_OK, intent);
            onBackPressed();
        }
    }
}
