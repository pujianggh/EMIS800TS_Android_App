package com.android.ts.emis.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.adapter.PollTaskListAdapter;
import com.android.ts.emis.base.BaseFragment;
import com.android.ts.emis.config.DataCenter;
import com.android.ts.emis.mode.PollingInfoListBean;
import com.android.ts.emis.utils.ThreadUtil;
import com.libcommon.action.utils.LogAPPUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * 巡检任务数据
 *
 * @author pujiang
 * @date 2018-4-12 13:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class PollTaskListFragment extends BaseFragment {
    @BindView(R.id.rl_root_refresh)
    BGARefreshLayout rlRootRefresh;
    @BindView(R.id.lv_list_data)
    ListView lvListData;
    @BindView(R.id.lly_dataNull)
    LinearLayout llyDataNull;
    @BindView(R.id.tv_messageTip)
    TextView tvMessageTip;

    private PollTaskListAdapter mAdapter;
    private PollingInfoListBean moduleBean;
    private int Type = 0;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_polltask_list);
        unBinder = ButterKnife.bind(this, mContentView);

        Type = getArguments().getInt(StrRes.INSTANCE.getType(), 0);
        initData();
        LogAPPUtil.i("@-->Type="+Type);
    }

    private void initData() {
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

        mAdapter = new PollTaskListAdapter(getActivity());
        lvListData.setAdapter(mAdapter);
        moduleBean = DataCenter.getPollingInfoListModuleData();
        mAdapter.setData(moduleBean.getData());

        if (Type == 1) {
            rlRootRefresh.setVisibility(View.GONE);
            llyDataNull.setVisibility(View.VISIBLE);
            tvMessageTip.setText(getResources().getString(R.string.text_frg_polling_task_details_zwxjrw));
        }
    }
}
