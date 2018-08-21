package com.libcommon.action.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * 计算相关
 *
 * @author pujiang
 * @date 2017-9-3 20:34
 * @mail 515210530@qq.com
 * @Description:
 */
public class MeasureUtils {

    /**
     * 获取屏幕宽度
     *
     * @param context
     * @param type
     * @return
     */
    public static int getScreenPixels(Context context, int type) {
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay()
                .getMetrics(dm);
        if (type == 0) {
            return dm.widthPixels;
        }
        return dm.heightPixels;
    }

    /**
     * px(像素)转成dip
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * dip转成px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px(像素)转成sp
     */
    public static int px2sp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / scale + 0.5f);
    }
}
