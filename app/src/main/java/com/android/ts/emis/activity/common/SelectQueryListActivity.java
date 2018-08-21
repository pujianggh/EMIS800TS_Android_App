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
import com.android.ts.emis.mode.SelectInfoBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

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
    private int stateType = StateType.INSTANCE.getPeopleInfo();

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

        mAdapter = new SelectQueryListAdapter(this);
        lvListData.setAdapter(mAdapter);
        if (stateType == StateType.INSTANCE.getPeopleInfo()) {
            setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_select_query_list_title), null, true);
            moduleBean = DataStateQueryCenter.getPGRYModuleData2();
        }
        mAdapter.setData(moduleBean.getData());
        mAdapter.setItemChecked(getIntent().getStringExtra(StrRes.INSTANCE.getSource()));
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
