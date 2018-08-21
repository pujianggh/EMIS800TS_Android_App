package com.codbking.calendar;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author pujiang
 * @date 2018-6-14 17:48
 * @mail 515210530@qq.com
 * @Description:
 */
public interface CaledarAdapter {
     View getView(View convertView, ViewGroup parentView, CalendarBean bean);
}
