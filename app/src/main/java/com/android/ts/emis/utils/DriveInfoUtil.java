package com.android.ts.emis.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

/**
 * 硬件设备驱动信息
 *
 * @author pujiang
 * @date 2018-4-2 15:03
 * @mail 515210530@qq.com
 * @Description:
 */
public class DriveInfoUtil {

    /**
     * 设备信息
     *
     * @return
     */
    public static String getDrivePhoneNumber(Context context) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return "";
        }
        TelephonyManager mTelephonyMgr;
        mTelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return mTelephonyMgr.getLine1Number();
    }
}
