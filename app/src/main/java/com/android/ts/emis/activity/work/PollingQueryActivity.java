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
import com.android.ts.emis.adapter.PollInfoQueryListAdapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.DataCenter;
import com.android.ts.emis.fragment.PollInfoQueryFragment;
import com.android.ts.emis.handle.DatePickerHandle;
import com.android.ts.emis.mode.PollingInfoListBean;
import com.android.ts.emis.utils.ThreadUtil;
import com.libcommon.action.utils.DateToolsUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * 工作-巡检-查询
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class PollingQueryActivity extends BaseActivity {
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

    private PollInfoQueryListAdapter mAdapter;
    private PollingInfoListBean moduleBean;
    private DatePickerHandle mDatePickerHandle;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_polling_query);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_polling_query_title), null, true);

        initData();
        initFrameLayout();
    }

    private void initData() {
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

        mAdapter = new PollInfoQueryListAdapter(this);
        lvListData.setAdapter(mAdapter);
        moduleBean = DataCenter.getPollingInfoListModuleData();
        mAdapter.setData(moduleBean.getData());
    }

    @OnClick({R.id.tv_agoMonth, R.id.tv_newMonth, R.id.tv_nextMonth, R.id.igv_query})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_agoMonth:
                break;
            case R.id.tv_newMonth:
                mDatePickerHandle.showTimePicker("yyyy-MM");
                break;
            case R.id.tv_nextMonth:
                break;
            case R.id.igv_query:
                drawerLayout.openDrawer(Gravity.RIGHT);
                break;
        }
    }

    /**
     * 查询条件初始化
     */
    private void initFrameLayout() {
        PollInfoQueryFragment fragment = new PollInfoQueryFragment();
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

    public void setQueryInfo() {
        drawerLayout.closeDrawer(Gravity.RIGHT);
    }
}
