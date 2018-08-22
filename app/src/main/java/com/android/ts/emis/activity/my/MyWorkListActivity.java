package com.android.ts.emis.activity.my;

import android.os.Bundle;
import android.widget.ListView;

import com.android.ts.emis.R;
import com.android.ts.emis.adapter.WorkOrderListAdapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.mode.WorkOrderListBean;
import com.android.ts.emis.utils.ThreadUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * 设置-我的报障（我的工作列表）
 *
 * @author pujiang
 * @date 2018-4-13 16:47
 * @mail 515210530@qq.com
 * @Description:
 */
public class MyWorkListActivity extends BaseActivity {
    @BindView(R.id.rl_root_refresh)
    BGARefreshLayout rlRootRefresh;
    @BindView(R.id.lv_list_data)
    ListView lvListData;

    private WorkOrderListAdapter mAdapter;
    private List<WorkOrderListBean.Data> dataList;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_my_worklist);
        ButterKnife.bind(this);

        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_my_worklist_title), null, true);
        initData();
        initEvent();
    }

    private void initData() {
        mAdapter = new WorkOrderListAdapter(this);
        lvListData.setAdapter(mAdapter);
        //dataList = mAPPApplication.getWorkOrderTypeList(0);
        //mAdapter.setData(dataList);
        rlRootRefresh.endRefreshing();
    }

    private void initEvent() {
        rlRootRefresh.setRefreshViewHolder(new BGANormalRefreshViewHolder(mAPPApplication, true));
        rlRootRefresh.setDelegate(new BGARefreshLayout.BGARefreshLayoutDelegate() {
            @Override
            public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
                ThreadUtil.INSTANCE.runInUIThread(new Runnable() {
                    @Override
                    public void run() {
                        rlRootRefresh.endRefreshing();
                        mAdapter.notifyDataSetChanged();
                    }
                }, 1000);
            }

            @Override
            public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
                ThreadUtil.INSTANCE.runInUIThread(new Runnable() {
                    @Override
                    public void run() {
                        rlRootRefresh.endLoadingMore();
                    }
                }, 1000);
                return true;
            }
        });
    }
}
