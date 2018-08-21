package com.android.ts.emis.activity.work;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.adapter.PlanMaintainListAdapter;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.DataCenter;
import com.android.ts.emis.mode.PlanMaintainListBean;
import com.codbking.calendar.CaledarAdapter;
import com.codbking.calendar.CalendarBean;
import com.codbking.calendar.CalendarDateView;
import com.codbking.calendar.CalendarView;
import com.libcommon.action.utils.MeasureUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 工作-工单-计划性维护
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class PlanMaintainActivity extends BaseActivity {
    @BindView(R.id.cdv_calendarView)
    CalendarDateView cdvCalendarView;
    @BindView(R.id.lv_list_data)
    ListView lvListData;

    private PlanMaintainListAdapter mAdapter;
    private PlanMaintainListBean moduleBean;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_plan_maintain);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, "2018 06", null, true);

        initData();
    }

    private void initData() {
        cdvCalendarView.setAdapter(new CaledarAdapter() {
            @Override
            public View getView(View convertView, ViewGroup parentView, CalendarBean bean) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(parentView.getContext()).inflate(R.layout.item_calendar, null);
                    ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(MeasureUtils.dip2px(mContext, 48), MeasureUtils.dip2px(mContext, 48));
                    convertView.setLayoutParams(params);
                }
                TextView tvTime = (TextView) convertView.findViewById(R.id.tv_time);
                tvTime.setText("" + bean.day);
                if (bean.mothFlag != 0) {
                    tvTime.setTextColor(0xff9299a1);
                } else {
                    tvTime.setTextColor(0xffffffff);
                }
                return convertView;
            }
        });
        cdvCalendarView.setOnItemClickListener(new CalendarView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postion, CalendarBean bean) {
                mTitleBar.getTitleCtv().setText(bean.year + " " + getDisPlayNumber(bean.moth));
            }
        });

        mAdapter = new PlanMaintainListAdapter(this);
        lvListData.setAdapter(mAdapter);
        moduleBean = DataCenter.getPlanMaintainListModuleData();
        mAdapter.setData(moduleBean.getData());
    }

    private String getDisPlayNumber(int num) {
        return num < 10 ? "0" + num : "" + num;
    }
}
