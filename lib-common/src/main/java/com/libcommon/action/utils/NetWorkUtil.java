package com.libcommon.action.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetWorkUtil {
    public static final int NET_CONNECT_TYPE_UNNET = -1;  //UNKNOWN
    public static final int NET_CONNECT_TYPE_G = 0;  //4G
    public static final int NET_CONNECT_TYPE_WIFI = 1;  //wifi

    /**
     * 判断网络是否可用
     *
     * @return -1：网络不可用 0：移动网络 1：wifi网络 2：未知网络
     */
    public static int isNetworkEnabled(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            switch (networkInfo.getType()) {
                case ConnectivityManager.TYPE_MOBILE: { // 移动网络
                    return NET_CONNECT_TYPE_G;
                }
                case ConnectivityManager.TYPE_WIFI: { // wifi网络
                    return NET_CONNECT_TYPE_WIFI;
                }
                default: {
                    return NET_CONNECT_TYPE_UNNET;
                }
            }
        }
        return NET_CONNECT_TYPE_UNNET;
    }
}
