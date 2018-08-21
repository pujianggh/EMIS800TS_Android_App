package com.libcommon.action.utils;

import android.util.Log;

import com.libcommon.action.config.BuildConfigure;

/**
 * 日志项目打印工具
 *
 * @author pujiang
 * @date 2017-9-3 19:55
 * @mail 515210530@qq.com
 * @Description:
 */
public class LogAPPUtil {
    public static boolean isDebug = BuildConfigure.IS_DEBUG;     // 调试状态
    public static String isTagDebug = BuildConfigure.DEBUG_TAG;  // 调试Tag

    /**
     * 调试信息
     *
     * @param msg
     */
    public static void e(String msg) {
        if (isDebug) {
            Log.d(isTagDebug, "" + msg);
        }
    }

    /**
     * 调试信息
     *
     * @param msg
     */
    public static void d(String msg) {
        if (isDebug) {
            Log.d(isTagDebug, "" + msg);
        }
    }

    /**
     * 调试信息
     *
     * @param msg
     */
    public static void i(String msg) {
        if (isDebug) {
            Log.i(isTagDebug, "" + msg);
        }
    }

    /**
     * 调试信息
     *
     * @param msg
     */
    public static void i(String tag,String msg) {
        if (isDebug) {
            Log.i(tag, "" + msg);
        }
    }

    /**
     * 调试信息
     *
     * @param msg
     */
    public static void i(int msg) {
        if (isDebug) {
            Log.i(isTagDebug, "" + msg);
        }
    }

    /**
     * 调试信息
     *
     * @param msg
     */
    public static void i(long msg) {
        if (isDebug) {
            Log.i(isTagDebug, "" + msg);
        }
    }

    /**
     * 调试信息
     *
     * @param msg
     */
    public static void i(boolean msg) {
        if (isDebug) {
            Log.i(isTagDebug, "" + msg);
        }
    }

}
