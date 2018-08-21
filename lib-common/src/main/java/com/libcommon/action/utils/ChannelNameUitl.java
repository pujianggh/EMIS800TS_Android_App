package com.libcommon.action.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import static android.content.pm.PackageManager.GET_META_DATA;

/**
 * 获取渠道信息
 * @author pujiang
 * @date 2017-8-28 16:57
 * @mail 515210530@qq.com
 * @Description:
 */
public class ChannelNameUitl {

    /**
     * 获取Activity渠道信息
     *
     * @param activity 此处习惯性的设置为activity,context也可以
     * @return 如果没有获取成功，那么返回值为空
     */
    public static String getChannelNameActivity(Activity activity, String key) {
        if (activity == null|| TextUtils.isEmpty(key)) {
            return null;
        }
        String channelName = null;
        try {
            PackageManager packageManager = activity.getPackageManager();
            if (packageManager != null) {
                //注意此处为ActivityInfo
                ActivityInfo activityInfo = packageManager.getActivityInfo(activity.getComponentName(), PackageManager.GET_META_DATA);
                if (activityInfo != null) {
                    if (activityInfo.metaData != null) {
                        channelName = activityInfo.metaData.getString(key);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return channelName;
    }

    /**
     * 获取Application渠道信息
     *
     * @param context 此处习惯性的设置为activity,context也可以
     * @return 如果没有获取成功，那么返回值为空
     */
    public static String getChannelNameApplication(Context context, String key) {
        if (context == null|| TextUtils.isEmpty(key)) {
            return null;
        }
        String channelName = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                //注意此处为ApplicationInfo 而不是ActivityInfo,因为友盟设置的meta-data是在application标签中，而不是某activity标签中，所以用ApplicationInfo
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        channelName = applicationInfo.metaData.getString(key);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return channelName;
    }
}
