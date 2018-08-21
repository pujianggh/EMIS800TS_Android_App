package com.android.ts.emis.handle;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.libcommon.action.utils.DateToolsUtil;
import com.stype.pickerview.builder.TimePickerBuilder;
import com.stype.pickerview.listenter.CustomListener;
import com.stype.pickerview.listenter.OnTimeSelectListener;
import com.stype.pickerview.view.TimePickerView;

import java.util.Calendar;
import java.util.Date;

/**
 * View层时间处理类
 *
 * @author pujiang
 * @date 2018-5-24 16:29
 * @mail 515210530@qq.com
 * @Description:
 */
public class DatePickerHandle {
    private Context mContext;
    public TextView tvDateView;
    private TimePickerView mTimePickerView;
    private String dateFormatter = "yyyy-MM-dd";

    public DatePickerHandle(Context mContext, boolean isYear, boolean isMouth, boolean isDay) {
        this.mContext = mContext;
        initTimePicker(isYear, isMouth, isDay);
    }

    public DatePickerHandle(Context mContext, TextView tvDateView, boolean isYear, boolean isMouth, boolean isDay) {
        this(mContext, isYear, isMouth, isDay);
        this.tvDateView = tvDateView;
    }

    /**
     * 显示选择器
     */
    public void showTimePicker(String dateFormatter) {
        if (mTimePickerView != null)
            mTimePickerView.show();
        if (!TextUtils.isEmpty(dateFormatter))
            this.dateFormatter = dateFormatter;
    }

    /**
     * 设置上一个月，下一个月
     */
    public void setMonthType(int type) {
        String dateText = tvDateView.getText().toString();
        String date = dateText.substring(0, dateText.indexOf("年"));
        String month = dateText.substring(dateText.indexOf("年") + 1, dateText.indexOf("月"));
        int newDate = 2018;
        int newMonth = 10;
        try {
            newDate = Integer.parseInt(date);
            if (month.startsWith("0")) {
                newMonth = Integer.parseInt(month.substring(1, month.length()));
            } else {
                newMonth = Integer.parseInt(month);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        if (type == -1) {
            if (newMonth == 1) {
                newDate--;
                newMonth = 12;
            } else {
                newMonth--;
            }
        } else {
            if (newMonth == 12) {
                newDate++;
                newMonth = 1;
            } else {
                newMonth++;
            }
        }
        if (newMonth < 10) {
            tvDateView.setText(newDate + "年0" + newMonth + "月");
        } else {
            tvDateView.setText(newDate + "年" + newMonth + "月");
        }
    }

    /**
     * 显示对话框
     */
    public void initTimePicker(boolean isYear, boolean isMouth, final boolean isDay) {
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(1998, 1, 1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2058, 1, 1);
        //时间选择器 ，自定义布局
        mTimePickerView = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                if (isDay) {
                    tvDateView.setText(DateToolsUtil.getDateFormatter(date, dateFormatter));
                } else {
                    tvDateView.setText(DateToolsUtil.getDateFormatter(date, "yyyy年MM月"));
                }
            }
        })
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setLayoutRes(R.layout.layout_pickerview_date, new CustomListener() {

                    @Override
                    public void customLayout(final View v) {
                        TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        TextView ivCancel = (TextView) v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mTimePickerView.returnData();
                                mTimePickerView.dismiss();
                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mTimePickerView.dismiss();
                            }
                        });
                    }
                })
                .setType(new boolean[]{isYear, isMouth, isDay, false, false, false})
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setDividerColor(mContext.getResources().getColor(R.color.line_gray))
                .build();
    }
}
