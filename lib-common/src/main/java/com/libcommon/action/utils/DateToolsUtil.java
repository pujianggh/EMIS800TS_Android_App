package com.libcommon.action.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理工具
 *
 * @author pujiang
 * @date 2017-8-24 17:00
 * @mail 515210530@qq.com
 * @Description:
 */
public class DateToolsUtil {

    /**
     * 转成点
     *
     * @param dateStr
     * @return
     */
    public static String getDateToDots(String dateStr) {
        if (!TextUtils.isEmpty(dateStr)) {
            return dateStr.replaceAll("/", ".").replaceAll("-", ".");
        }
        return "";
    }

    /**
     * 获取事件戳
     *
     * @param dateStr
     * @return
     */
    public static long getBeginTime(String dateStr, int type) {
        long beginTime = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Calendar beginTimeCalendar = Calendar.getInstance();
            if (type == 0) {
                beginTimeCalendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 11, 0);
            } else {
                beginTimeCalendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 11, 0);
            }
            beginTime = beginTimeCalendar.getTime().getTime();
            return beginTime;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beginTime;
    }

    /**
     * 获取到不同类型的时间
     *
     * @param timeStr
     * @param type
     * @return
     */
    public static String getFormatTime(String timeStr, int type) {
        String str = "";
        try {
            if (timeStr != null && !timeStr.equals("")) {
                long time = Long.parseLong(timeStr);
                str = DateFormat.format("yyyy-MM-dd kk:mm", time).toString();
                if (type == 1) {
                    str = DateFormat.format("yyyy-MM-dd", time).toString();
                } else if (type == 2) {
                    str = DateFormat.format("yyyy-MM-dd kk:mm:ss", time)
                            .toString();
                } else if (type == 3) {
                    str = DateFormat.format("MM月dd日 kk:mm", time)
                            .toString();
                } else if (type == 4) {
                    str = DateFormat.format("kk:mm", time)
                            .toString();
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 显示时间
     *
     * @param timeStr
     * @return
     */
    public static String getShowTime(String timeStr) {
        String str = "";
        try {
            if (timeStr != null && !"".equals(timeStr)) {
                Calendar oldCal = Calendar.getInstance();
                Calendar newCal = Calendar.getInstance();
                oldCal.setTime(new Date(System.currentTimeMillis()));
                newCal.setTime(new Date(Long.parseLong(timeStr)));
                long time = Long.parseLong(timeStr);
                if (Math.abs(newCal.get(Calendar.DAY_OF_YEAR)
                        - oldCal.get(Calendar.DAY_OF_YEAR)) == 1) {
                    str = DateFormat.format(" kk:mm", time).toString();
                    str = "昨天";
                } else if (Math.abs(newCal.get(Calendar.DAY_OF_YEAR)
                        - oldCal.get(Calendar.DAY_OF_YEAR)) <= 1) {
                    str = DateFormat.format("kk:mm", time).toString();
                    str = "今天";
                } else {
                    str = DateFormat.format("MM-dd", time).toString();
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 返回当前的时间
     *
     * @return
     */
    @NonNull
    public static String getNewDate() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        return year + "年" + month + "月" + day + "日";
    }

    /**
     * 返回当前的年月
     *
     * @return
     */
    @NonNull
    public static String getNewDateYM() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        return year + "年" + month + "月";
    }

    /**
     * 返回日期的天
     *
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 返回日期的月份
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 返回日期的年
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取当前年月日
     * @return
     */
    public static Date getNewTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 返回天
     *
     * @param year
     * @param month
     * @return
     */
    public static int getDaysOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 活动时间
     *
     * @param time
     * @return
     */
    public static String getMessageCenterTime(String time) {
        String timeStr = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date dat = formatter2.parse(time);
            timeStr = formatter.format(dat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeStr;
    }

    /**
     * 到账详情-到账时间
     *
     * @param time
     * @return
     */
    public static String getWithDrawDetailsTime(String time) {
        String timeStr = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date dat = formatter2.parse(time);
            timeStr = formatter.format(dat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeStr;
    }

    /**
     * 判断时间大小
     * 若是服务器时间大于拒绝时间，返回ture
     *
     * @param currentTime
     * @param rejectTime
     * @return
     */
    public static boolean checkTimeCompare(String currentTime, String rejectTime) {
        //格式化时间
        SimpleDateFormat CurrentTime = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date beginTime = CurrentTime.parse(currentTime);
            Date endTime = CurrentTime.parse(rejectTime);
            //判断是否大于两天
            if (endTime.getTime() > beginTime.getTime()) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取指定日期格式
     *
     * @param date
     * @param formatter
     * @return
     */
    public static String getDateFormatter(Date date, String formatter) {
        String typeDef = "yyyy-MM-dd";
        if (!TextUtils.isEmpty(formatter)) {
            typeDef = formatter;
        }
        String dateTime = "";
        try {
            SimpleDateFormat mFormatter = new SimpleDateFormat(typeDef);
            dateTime = mFormatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateTime;
    }
}