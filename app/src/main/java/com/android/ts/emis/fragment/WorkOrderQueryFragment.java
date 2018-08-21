package com.android.ts.emis.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.activity.work.WorkOrderQueryListActivity;
import com.android.ts.emis.adapter.StateModuleAdapter;
import com.android.ts.emis.base.BaseFragment;
import com.android.ts.emis.config.DataCenter;
import com.android.ts.emis.handle.DatePickerHandle;
import com.android.ts.emis.handle.RecycleSpacingHandle;
import com.android.ts.emis.listeners.OnRcyclerItemClickListener;
import com.android.ts.emis.mode.StateInfoBean;
import com.libcommon.action.utils.DateToolsUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 工单查询条件
 *
 * @author pujiang
 * @date 2018-4-12 13:52
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderQueryFragment extends BaseFragment {
    @BindView(R.id.rlv_priorityView)
    RecyclerView rlvPriorityView;
    @BindView(R.id.rlv_orderStateView)
    RecyclerView rlvOrderStateView;
    @BindView(R.id.edt_orderCode)
    EditText edtOrderCode;
    @BindView(R.id.edt_pfmCode)
    EditText edtPfmCode;
    @BindView(R.id.tv_startDate)
    TextView tvStartDate;
    @BindView(R.id.tv_endDate)
    TextView tvEndDate;
    @BindView(R.id.tv_workOrderType)
    TextView tvWorkOrderType;

    private StateModuleAdapter mPriorityAdapter, mOrderStateAdapter;
    private StateInfoBean modulePriorityBean, moduleOrderStateBean;
    private DatePickerHandle mPriorityDatePicker, mOrderStateDatePicker;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_workorder_query);
        unBinder = ButterKnife.bind(this, mContentView);

        initData();
    }

    @OnClick({R.id.btn_reset, R.id.btn_confirm, R.id.tv_startDate, R.id.tv_endDate})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_reset:
                edtOrderCode.setText("");
                edtPfmCode.setText("");
                tvStartDate.setText(DateToolsUtil.getYear(DateToolsUtil.getNewTime()) + "-" + DateToolsUtil.getMonth(DateToolsUtil.getNewTime()) + "-1");
                tvEndDate.setText(DateToolsUtil.getYear(DateToolsUtil.getNewTime()) + "-" + DateToolsUtil.getMonth(DateToolsUtil.getNewTime()) + "-31");
                tvWorkOrderType.setText("");
                mPriorityAdapter.setItemAllNoChecked();
                mPriorityAdapter.setItemCheckedOne();
                mOrderStateAdapter.setItemAllNoChecked();
                mOrderStateAdapter.setItemCheckedOne();
                break;
            case R.id.btn_confirm:
                ((WorkOrderQueryListActivity) getActivity()).setQueryInfoValue(edtOrderCode.getText().toString(), edtPfmCode.getText().toString(),
                        tvStartDate.getText().toString(), tvEndDate.getText().toString(), "", "");
                break;
            case R.id.tv_startDate:
                mPriorityDatePicker.showTimePicker("yyyy-MM-dd");
                break;
            case R.id.tv_endDate:
                mOrderStateDatePicker.showTimePicker("yyyy-MM-dd");
                break;
        }
    }

    private void initData() {
        mPriorityDatePicker = new DatePickerHandle(getActivity(), tvStartDate, true, true, true);
        mOrderStateDatePicker = new DatePickerHandle(getActivity(), tvEndDate, true, true, true);

        modulePriorityBean = DataCenter.getPriorityStateInfoBeanModuleData();
        GridLayoutManager layoutManager1 = new GridLayoutManager(mAPPApplication, 3);
        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        rlvPriorityView.setLayoutManager(layoutManager1);
        rlvPriorityView.addItemDecoration(new RecycleSpacingHandle(3, getResources().getDimensionPixelSize(R.dimen.spacing_min), true));
        rlvPriorityView.setHasFixedSize(true);
        mPriorityAdapter = new StateModuleAdapter(getActivity(), modulePriorityBean.getData());
        rlvPriorityView.setAdapter(mPriorityAdapter);
        mPriorityAdapter.setOnItemClickListener(new OnRcyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Object mode) {
                mPriorityAdapter.setItemClick(position);
            }
        });

        moduleOrderStateBean = DataCenter.getOrderStateStateInfoBeanModuleData();
        GridLayoutManager layoutManager2 = new GridLayoutManager(mAPPApplication, 3);
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        rlvOrderStateView.setLayoutManager(layoutManager2);
        rlvOrderStateView.addItemDecoration(new RecycleSpacingHandle(3, getResources().getDimensionPixelSize(R.dimen.spacing_min), true));
        rlvOrderStateView.setHasFixedSize(true);
        mOrderStateAdapter = new StateModuleAdapter(getActivity(), moduleOrderStateBean.getData());
        rlvOrderStateView.setAdapter(mOrderStateAdapter);
        mOrderStateAdapter.setOnItemClickListener(new OnRcyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Object mode) {
                mOrderStateAdapter.setItemClick(position);
            }
        });
    }
}
