package com.codbking.calendar;

/**
 * @author pujiang
 * @date 2018-6-14 17:48
 * @mail 515210530@qq.com
 * @Description:
 */
public interface CalendarTopView {

    int[] getCurrentSelectPositon();

    int getItemHeight();

    void setCaledarTopViewChangeListener(CaledarTopViewChangeListener listener);

}
