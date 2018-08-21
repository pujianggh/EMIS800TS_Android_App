package com.android.ts.emis.activity.work;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.ts.emis.R;
import com.android.ts.emis.adapter.PlanMaintainDetailStepAdapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.DataCenter;
import com.android.ts.emis.mode.PlanMaintainDetailStepBean;
import com.android.ts.emis.utils.PopupWindowUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 工作-计划性维护详情
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class PlanMaintainDetailsActivity extends BaseActivity {
    @BindView(R.id.lly_root)
    LinearLayout llyToot;
    @BindView(R.id.lv_list_data)
    ListView lvListData;

    private PopupWindowUtil mPopupWindowUtil = null;
    private PlanMaintainDetailStepAdapter mAdapter;
    private PlanMaintainDetailStepBean moduleBean;

    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_plan_maintain_details);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_plan_maintain_details_title), null, "···", true);

        initData();
        initListData();
    }

    private void initListData() {
        mAdapter = new PlanMaintainDetailStepAdapter(this);
        lvListData.setAdapter(mAdapter);
        moduleBean = DataCenter.getPlanMaintainDetailStepModuleData();
        mAdapter.setData(moduleBean.getData());
    }

    private void initData() {
        mTitleBar.getRightCtv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopupWindowUtil == null)
                    mPopupWindowUtil = new PopupWindowUtil(mContext);
                mPopupWindowUtil.showPlanMaintainDetailsWindow(llyToot, new PopupWindowUtil.OnPopuwindowClick() {
                    @Override
                    public void onPopuwindowClick(int id) {
                        switch (id) {
                            case R.id.igv_dx:
                                break;
                            case R.id.igv_wxgd:
                                break;
                        }
                    }
                });
            }
        });
    }
}
