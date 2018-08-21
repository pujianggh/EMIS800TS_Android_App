package com.android.ts.emis.activity.work;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.ts.emis.R;
import com.android.ts.emis.adapter.WorkModule2Adapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.DataCenter;
import com.android.ts.emis.handle.RecycleViewDivider;
import com.android.ts.emis.mode.WorkModuleBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 工作-工单
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderActivity extends BaseActivity {
    @BindView(R.id.rlv_content)
    RecyclerView rlvContent;

    private WorkModule2Adapter mWorkModule2Adapter;
    private WorkModuleBean moduleBean;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_work_order);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_title_gd), null, true);

        initData();
    }

    private void initData() {
        moduleBean = DataCenter.getWorkOrderModuleData2();

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlvContent.setLayoutManager(layoutManager);
        rlvContent.addItemDecoration(new RecycleViewDivider(this));
        mWorkModule2Adapter = new WorkModule2Adapter(this, moduleBean.getBody());
        rlvContent.setAdapter(mWorkModule2Adapter);
    }
}
