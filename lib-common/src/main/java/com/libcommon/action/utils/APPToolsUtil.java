package com.libcommon.action.utils;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.libcommon.action.utils.setroom.HuaweiUtils;
import com.libcommon.action.utils.setroom.MeizuUtils;
import com.libcommon.action.utils.setroom.MiuiUtils;
import com.libcommon.action.utils.setroom.QikuUtils;
import com.libcommon.action.utils.setroom.RomUtils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/**
 * 主要调取手机内部数据
 * 工具类
 *
 * @author pujiang
 * @date 2017-9-4 14:40
 * @mail 515210530@qq.com
 * @Description:
 */
public class APPToolsUtil {

    /**
     * 打开系统权限设置
     *
     * @param context
     */
    public static void startAppSettings(Context context) {
        if (RomUtils.checkIsMiuiRom()) {
            MiuiUtils.applyMiuiPermission(context);
        } else if (RomUtils.checkIsMeizuRom()) {
            MeizuUtils.applyPermission(context);
        } else if (RomUtils.checkIsHuaweiRom()) {
            HuaweiUtils.applyPermission(context);
        } else if (RomUtils.checkIs360Rom()) {
            QikuUtils.applyPermission(context);
        } else {
            /**
             * 启动当前应用设置页面
             */
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.parse("package:" + APPToolsUtil.getAppPackageName(context)));
            context.startActivity(intent);
        }
    }

    /**
     * 获取IP
     *
     * @return
     */
    public static String getHostIp() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception e) {
            LogAPPUtil.e("getHostIp->" + e.getStackTrace());
        }
        return "";
    }

    /**
     * 获取设备ID
     *
     * @param context
     * @return
     */
    @RequiresPermission(android.Manifest.permission.READ_PHONE_STATE)
    public static String getDeviceId(Context context) {
        try {
            String result = "";
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (telephonyManager == null) {
                return "";
            }
            result = telephonyManager.getDeviceId();
            if (TextUtils.isEmpty(result)) {
                return "";
            } else {
                return result;
            }
        } catch (Exception e) {
            LogAPPUtil.e("getDeviceId->" + e.getStackTrace());
            return "";
        }
    }

    /**
     * 返回当前程序code
     *
     * @param context
     * @return
     */
    public static int getAppVersionCode(Context context) {
        int versionName = 1;
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionCode;
        } catch (Exception e) {
            LogAPPUtil.e("VersionInfo->" + e.getStackTrace());
        }
        return versionName;
    }

    /**
     * 返回当前程序版本
     *
     * @param context
     * @return
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            LogAPPUtil.e("VersionInfo->" + e.getStackTrace());
        }
        return versionName;
    }

    /**
     * 获取包名
     *
     * @param context
     * @return
     */
    public static String getAppPackageName(Context context) {
        try {
            int pid = android.os.Process.myPid();//当前应用pid
            ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);//任务管理类
            List<ActivityManager.RunningAppProcessInfo> infos = manager.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo info : infos) {
                if (info.pid == pid)//得到当前应用
                    return info.processName;//返回包名
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return "";
    }

    /**
     * 拨打电话 （直接拨打电话）
     *
     * @param context
     * @param phoneNum
     */
    public static void callPhone(Context context, String phoneNum) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        context.startActivity(intent);
    }

    /**
     * 拨打电话 （添加到系统拨号界面，由用户手动拨打）
     *
     * @param context
     * @param phoneNum
     */
    public static void diallPhone(Context context, String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        context.startActivity(intent);
    }
}
