package com.android.ts.emis.activity.work;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.adapter.WorkOrderQueryListAdapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.fragment.WorkOrderQueryFragment;
import com.android.ts.emis.handle.DatePickerHandle;
import com.android.ts.emis.mode.TicketInfoBean;
import com.android.ts.emis.mode.WorkOrderQueryListBean;
import com.android.ts.emis.mvp.presenter.WorkOrderQueryListPresenter;
import com.android.ts.emis.mvp.view.IWorkOrderQueryListView;
import com.android.ts.emis.net.OkhttpUtil;
import com.libcommon.action.utils.DateToolsUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * 工作-工单列表查询
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderQueryListActivity extends BaseActivity implements IWorkOrderQueryListView {
    @BindView(R.id.rl_root_refresh)
    BGARefreshLayout rlRootRefresh;
    @BindView(R.id.lv_list_data)
    ListView lvListData;
    @BindView(R.id.tv_agoMonth)
    TextView tvAgoMonth;
    @BindView(R.id.tv_newMonth)
    TextView tvNewMonth;
    @BindView(R.id.tv_nextMonth)
    TextView tvNextMonth;
    @BindView(R.id.igv_query)
    ImageView igvQuery;
    @BindView(R.id.frm_content)
    FrameLayout frmContent;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private WorkOrderQueryListPresenter mPresenter;
    private WorkOrderQueryListAdapter mAdapter;
    private List<TicketInfoBean> datas;
    private DatePickerHandle mDatePickerHandle;

    private String ticketsCode, estateCode, createStartTime, createEndTime, ticketsTypeCode,
            priorityCode, ticketsStatus;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_work_order_query_list);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_title_gdcx), null, true);

        initData();
        initFrameLayout();
    }

    @OnClick({R.id.tv_agoMonth, R.id.tv_newMonth, R.id.tv_nextMonth, R.id.igv_query})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_agoMonth:
                mDatePickerHandle.setMonthType(-1);
                break;
            case R.id.tv_newMonth:
                mDatePickerHandle.showTimePicker("yyyy年MM月");
                break;
            case R.id.tv_nextMonth:
                mDatePickerHandle.setMonthType(1);
                break;
            case R.id.igv_query:
                drawerLayout.openDrawer(Gravity.RIGHT);
                break;
        }
    }

    @Override
    public void getWorkOrderQueryLists(WorkOrderQueryListBean workOrderQueryListBean) {
        rlRootRefresh.endRefreshing();
        if (workOrderQueryListBean != null && workOrderQueryListBean.getData() != null && workOrderQueryListBean.getData().getTicketsList() != null) {
            mAdapter = new WorkOrderQueryListAdapter(this);
            lvListData.setAdapter(mAdapter);
            datas = workOrderQueryListBean.getData().getTicketsList();
            mAdapter.setData(datas);
            mAdapter.notifyDataSetChanged();
            mTotalPage = workOrderQueryListBean.getData().getTotalPage();
        }
    }

    @Override
    public void addWorkOrderQueryLists(WorkOrderQueryListBean workOrderQueryListBean) {
        rlRootRefresh.endLoadingMore();
        datas.addAll(workOrderQueryListBean.getData().getTicketsList());
        mAdapter.notifyDataSetChanged();
    }

    private void initData() {
        getResponseData(true);
        tvNewMonth.setText(DateToolsUtil.getNewDateYM());
        mDatePickerHandle = new DatePickerHandle(this, tvNewMonth, true, true, false);
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                if (slideOffset > 0f) {
                    igvQuery.setVisibility(View.GONE);
                }
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                igvQuery.setVisibility(View.GONE);
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                igvQuery.setVisibility(View.VISIBLE);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });
        rlRootRefresh.setRefreshViewHolder(new BGANormalRefreshViewHolder(mAPPApplication, true));
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
    }

    /**
     * 查询条件初始化
     */
    private void initFrameLayout() {
        WorkOrderQueryFragment fragment = new WorkOrderQueryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(StrRes.INSTANCE.getType(), 1);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frm_content, fragment).commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            drawerLayout.closeDrawer(Gravity.RIGHT);
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void getResponseData(boolean isRefresh) {
        if (mPresenter == null)
            mPresenter = new WorkOrderQueryListPresenter(this, this);
        if (isRefresh) {
            mPage = 1;
            mPresenter.getWorkOrderQueryLists(mPage + "", mSize + "",
                    ticketsCode, estateCode, createStartTime, createEndTime, ticketsTypeCode,
                    priorityCode, ticketsStatus, OkhttpUtil.GetUrlMode.NORMAL);
        } else {
            if (mTotalPage > mPage) {
                mPage++;
                mPresenter.getWorkOrderQueryLists(mPage + "", mSize + "",
                        ticketsCode, estateCode, createStartTime, createEndTime, ticketsTypeCode,
                        priorityCode, ticketsStatus, OkhttpUtil.GetUrlMode.PULL_UP);
            } else {
                rlRootRefresh.endLoadingMore();
            }
        }
    }

    public void setQueryInfoValue(String ticketsCode, String estateCode, String createStartTime, String createEndTime, String priorityCode, String ticketsStatus) {
        drawerLayout.closeDrawer(Gravity.RIGHT);
        this.ticketsCode = ticketsCode;
        this.estateCode = estateCode;
        this.createStartTime = createStartTime;
        this.createEndTime = createEndTime;
        this.priorityCode = priorityCode;
        this.ticketsStatus = ticketsStatus;
        getResponseData(true);
    }
}
