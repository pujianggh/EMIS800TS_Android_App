package com.android.ts.emis.activity.work;

import android.os.Bundle;
import android.widget.ListView;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.adapter.WorkOrderListAdapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.mode.TicketInfoBean;
import com.android.ts.emis.mode.WorkOrderQueryListBean;
import com.android.ts.emis.mvp.presenter.WorkOrderListPresenter;
import com.android.ts.emis.mvp.view.IWorkOrderListView;
import com.android.ts.emis.net.OkhttpUtil;

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
public class WorkOrderListActivity extends BaseActivity implements IWorkOrderListView {
    @BindView(R.id.rl_root_refresh)
    BGARefreshLayout rlRootRefresh;
    @BindView(R.id.lv_list_data)
    ListView lvListData;

    private WorkOrderListPresenter mPresenter;
    private WorkOrderListAdapter mAdapter;
    private List<TicketInfoBean> datas;
    private int mType = 30002;
    private String mTicketsStatus = "";

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_work_order_list);
        ButterKnife.bind(this);

        rlRootRefresh.setRefreshViewHolder(new BGANormalRefreshViewHolder(mAPPApplication, true));
        rlRootRefresh.beginRefreshing();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        mType = getIntent().getIntExtra(StrRes.INSTANCE.getType(), 30002);
        setTitleBarLayout(R.drawable.icon_back_white_bar, "", null, true);
        switch (mType) {
            case 30002://待处理工单
                mTitleBar.setTitleText(getResources().getString(R.string.text_title_dclgd));
                mTicketsStatus = "3";
                break;
            case 30003://待派批工单
                mTitleBar.setTitleText(getResources().getString(R.string.text_title_dppgd));
                mTicketsStatus = "0";
                break;
            case 30004://待审批工单
                mTitleBar.setTitleText(getResources().getString(R.string.text_title_dspgd));
                mTicketsStatus = "2";
                break;
            case 30005://待存档工单
                mTitleBar.setTitleText(getResources().getString(R.string.text_title_dcdgd));
                mTicketsStatus = "8";
                break;
            case 30006://待评价工单
                mTitleBar.setTitleText(getResources().getString(R.string.text_title_dpjgd));
                mTicketsStatus = "7";
                break;
        }

        rlRootRefresh.setDelegate(new BGARefreshLayout.BGARefreshLayoutDelegate() {
            @Override
            public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
                getResponseData(true);
            }

            @Override
            public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
                getResponseData(false);
                return mTotalPage > mPage;
            }
        });
        getResponseData(true);
    }

    @Override
    public void getWorkOrderLists(WorkOrderQueryListBean workOrderQueryListBean) {
        rlRootRefresh.endRefreshing();
        if (workOrderQueryListBean != null && workOrderQueryListBean.getData() != null && workOrderQueryListBean.getData().getTicketsList() != null) {
            mAdapter = new WorkOrderListAdapter(this);
            lvListData.setAdapter(mAdapter);
            datas = workOrderQueryListBean.getData().getTicketsList();
            mAdapter.setData(datas);
            mAdapter.notifyDataSetChanged();
            mTotalPage = workOrderQueryListBean.getData().getTotalPage();
        }
    }

    @Override
    public void addWorkOrderLists(WorkOrderQueryListBean workOrderQueryListBean) {
        datas.addAll(workOrderQueryListBean.getData().getTicketsList());
        mAdapter.notifyDataSetChanged();
        rlRootRefresh.endLoadingMore();
    }

    private void getResponseData(boolean isRefresh) {
        if (mPresenter == null)
            mPresenter = new WorkOrderListPresenter(this, this);
        if (isRefresh) {
            mPage = 1;
            mPresenter.getWorkOrderLists(mPage + "", mSize + "",
                    mTicketsStatus, OkhttpUtil.GetUrlMode.NORMAL);
        } else {
            if (mTotalPage > mPage) {
                mPage++;
                mPresenter.getWorkOrderLists(mPage + "", mSize + "",
                        mTicketsStatus, OkhttpUtil.GetUrlMode.PULL_UP);
            } else {
                rlRootRefresh.endLoadingMore();
            }
        }
    }
}
