package com.libcommon.action.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * APK更新，安装功能类
 *
 * @author pujiang
 * @date 2018-3-23 10:01
 * @mail 515210530@qq.com
 * @Description:
 */
public class UpdateInstallUtil {
    private static final String MIME_TYPE_APK = "application/vnd.android.package-archive";

    /**
     * 安装 apk 文件
     *
     * @param context
     * @param apkFile
     */
    public static void installApk(Context context, File apkFile) {
        if (apkFile == null) return;
        Intent installApkIntent = new Intent();
        installApkIntent.setAction(Intent.ACTION_VIEW);
        installApkIntent.addCategory(Intent.CATEGORY_DEFAULT);
        installApkIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            installApkIntent.setDataAndType(FileProvider.getUriForFile(context, getFileProviderAuthority(context), apkFile), MIME_TYPE_APK);
            installApkIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            installApkIntent.setDataAndType(Uri.fromFile(apkFile), MIME_TYPE_APK);
        }

        if (context.getPackageManager().queryIntentActivities(installApkIntent, 0).size() > 0) {
            context.startActivity(installApkIntent);
        }
    }

    /**
     * 删除之前升级时下载的老的 apk 文件
     */
    public static void deleteOldApk(String apkFile) {
        if (apkFile == null || apkFile == "null" || apkFile == "") return;

        // 删除文件
        FileUtil.isFileExistDelete(apkFile);
    }

    /**
     * 获取FileProvider的auth
     *
     * @return
     */
    private static String getFileProviderAuthority(Context context) {
        try {
            for (ProviderInfo provider : context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_PROVIDERS).providers) {
                if (FileProvider.class.getName().equals(provider.name) && provider.authority.endsWith(".provider")) {
                    return provider.authority;
                }
            }
        } catch (PackageManager.NameNotFoundException ignore) {
        }
        return null;
    }
}
