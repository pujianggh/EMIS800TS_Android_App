package com.android.ts.emis.activity.work;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.android.kotlinapp.action.config.StateType;
import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.adapter.StateQueryListAdapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.DataStateQueryCenter;
import com.android.ts.emis.mode.StateInfoBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * 工作-通用信息选择，部门、设备、状态、地址等
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class StateQueryListActivity extends BaseActivity {
    @BindView(R.id.rl_root_refresh)
    BGARefreshLayout rlRootRefresh;
    @BindView(R.id.lv_list_data)
    ListView lvListData;
    @BindView(R.id.edt_search)
    EditText edtSearch;

    private StateQueryListAdapter mAdapter;
    private StateInfoBean moduleBean;
    private int stateType = StateType.INSTANCE.getStateInfo();
    private String querySource = "";

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_state_query_list);
        ButterKnife.bind(this);
        stateType = getIntent().getIntExtra(StrRes.INSTANCE.getType(), StateType.INSTANCE.getStateInfo());

        initData();
    }

    private void initData() {
        rlRootRefresh.setRefreshViewHolder(new BGANormalRefreshViewHolder(mAPPApplication, true));
        rlRootRefresh.setDelegate(new BGARefreshLayout.BGARefreshLayoutDelegate() {
            @Override
            public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
                refreshLayout.endRefreshing();
            }

            @Override
            public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
                return false;
            }
        });

        mAdapter = new StateQueryListAdapter(this);
        lvListData.setAdapter(mAdapter);
        if (stateType == StateType.INSTANCE.getLocation()) {
            setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_title_wz), null, getResources().getString(R.string.text_button_qd), true);
            //moduleBean = DataStateQueryCenter.getWZModuleData();
            moduleBean = DataStateQueryCenter.getWZTestModuleData();
        } else if (stateType == StateType.INSTANCE.getStateInfo()) {
            setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_title_zt), null, getResources().getString(R.string.text_button_qd), true);
            moduleBean = DataStateQueryCenter.getBMModuleData();
        } else if (stateType == StateType.INSTANCE.getServerType()) {
            setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_title_fwlx), null, getResources().getString(R.string.text_button_qd), true);
            //moduleBean = DataStateQueryCenter.getFWLXModuleData();
            moduleBean = DataStateQueryCenter.getBXNRModuleData();
        } else if (stateType == StateType.INSTANCE.getWorkOrderType()) {
            setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_title_gdlx), null, getResources().getString(R.string.text_button_qd), true);
            moduleBean = DataStateQueryCenter.getGDLXModuleData();
        } else if (stateType == StateType.INSTANCE.getPriority()) {
            setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_title_yxj), null, getResources().getString(R.string.text_button_qd), true);
            moduleBean = DataStateQueryCenter.getYXJModuleData();
        } else if (stateType == StateType.INSTANCE.getDepartmentInfo()) {
            setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_title_bm), null, getResources().getString(R.string.text_button_qd), true);
            moduleBean = DataStateQueryCenter.getBMModuleData();
        } else if (stateType == StateType.INSTANCE.getDevice()) {
            setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_title_sb), null, getResources().getString(R.string.text_button_qd), true);
            moduleBean = DataStateQueryCenter.getDeviceModuleData();
        }
        mAdapter.setData(moduleBean.getData());

        mTitleBar.getRightCtv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishBackData(null, true);
            }
        });
    }

    /**
     * 改变参数
     *
     * @param querySourceMode
     */
    public void setSourceTitleData(StateInfoBean.Data querySourceMode) {
        if (TextUtils.isEmpty(this.querySource)) {
            this.querySource = querySourceMode.getName();
        } else {
            this.querySource = this.querySource + "/" + querySourceMode.getName();
        }
        if (!TextUtils.isEmpty(querySource))
            setTitleBarLayout(R.drawable.icon_back_white_bar, querySourceMode.getName(), null, getResources().getString(R.string.text_button_qd), true);
    }

    /**
     * 返回数据
     *
     * @param isHasData
     */
    public void finishBackData(StateInfoBean.Data mode, boolean isHasData) {
        if (isHasData && mode != null && stateType == StateType.INSTANCE.getDevice()) {//特殊处理设备信息
            setResult(RESULT_OK, new Intent().putExtra(StrRes.INSTANCE.getMode(), mode).putExtra(StrRes.INSTANCE.getSource(), querySource));
            onBackPressed();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(StrRes.INSTANCE.getSource(), querySource);
        if (!isHasData || TextUtils.isEmpty(querySource)) {
            intent = null;
        }
        setResult(RESULT_OK, intent);
        onBackPressed();
    }
}
