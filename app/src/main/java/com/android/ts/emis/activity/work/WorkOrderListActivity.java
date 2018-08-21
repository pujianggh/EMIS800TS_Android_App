package com.android.ts.emis.activity.work;

import android.os.Bundle;
import android.widget.ListView;

import com.android.kotlinapp.action.config.StrRes;
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
 * 工作-工单列表
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderListActivity extends BaseActivity {
    @BindView(R.id.rl_root_refresh)
    BGARefreshLayout rlRootRefresh;
    @BindView(R.id.lv_list_data)
    ListView lvListData;

    private WorkOrderListAdapter mAdapter;
    private List<WorkOrderListBean.Data> dataList;
    private int mType = 30002;
    private String mTitle = "";

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_work_order_list);
        ButterKnife.bind(this);

        mType = getIntent().getIntExtra(StrRes.INSTANCE.getType(), 30002);
        switch (mType) {
            case 30002://待处理工单
                mTitle = getResources().getString(R.string.text_title_dclgd);
                break;
            case 30003://待派批工单
                mTitle = getResources().getString(R.string.text_title_dppgd);
                break;
            case 30004://待审批工单
                mTitle = getResources().getString(R.string.text_title_dspgd);
                break;
            case 30005://待存档工单
                mTitle = getResources().getString(R.string.text_title_dcdgd);
                break;
            case 30006://待评价工单
                mTitle = getResources().getString(R.string.text_title_dpjgd);
                break;
        }
        setTitleBarLayout(R.drawable.icon_back_white_bar, mTitle, null, true);
        initEvent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        mAdapter = new WorkOrderListAdapter(this);
        lvListData.setAdapter(mAdapter);
        //1：待处理工单 2：待派批工单（待派工) 3：待审批工单 4：待存档工单 5：待评价工单
        switch (mType) {
            case 30002://待处理工单
                //dataList = mAPPApplication.getWorkOrderTypeList(1);
                break;
            case 30003://待派批工单
                //dataList = mAPPApplication.getWorkOrderTypeList(2);
                break;
            case 30004://待审批工单
                //dataList = mAPPApplication.getWorkOrderTypeList(3);
                break;
            case 30005://待存档工单
                break;
            case 30006://待评价工单
                break;
        }
        mAdapter.setData(dataList);
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
                }, 2000);
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
