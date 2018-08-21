package com.android.ts.emis.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.adapter.WorkModuleAdapter;
import com.android.ts.emis.base.BaseFragment;
import com.android.ts.emis.config.DataCenter;
import com.android.ts.emis.handle.RecycleViewDivider;
import com.android.ts.emis.mode.WorkModuleBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页-工作信息
 *
 * @author pujiang
 * @date 2018-4-12 13:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class MyFragment extends BaseFragment {
    @BindView(R.id.rly_work_bill)
    RelativeLayout rlyWorkBill;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.rlv_content)
    RecyclerView rlvContent;

    private WorkModuleAdapter mWorkModuleAdapter;
    private WorkModuleBean moduleBean;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_my);
        unBinder = ButterKnife.bind(this, mContentView);

        initData();
    }

    private void initData() {
        //rlyWorkBill.getBackground().mutate().setAlpha(100);
        moduleBean = DataCenter.getWorkModuleData();

        GridLayoutManager layoutManager = new GridLayoutManager(mAPPApplication, 3);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlvContent.setLayoutManager(layoutManager);
        rlvContent.addItemDecoration(new RecycleViewDivider(mAPPApplication));
        mWorkModuleAdapter = new WorkModuleAdapter(getActivity(), moduleBean.getBody());
        rlvContent.setAdapter(mWorkModuleAdapter);
    }
}
