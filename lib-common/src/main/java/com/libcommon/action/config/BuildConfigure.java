package com.libcommon.action.config;

import com.libcommon.action.BuildConfig;

/**
 * 生产环境配置config
 *
 * @author pujiang
 * @date 2018-1-3 19:57
 * @mail 515210530@qq.com
 * @Description:
 */
public final class BuildConfigure {
    public static final boolean IS_DEBUG = BuildConfig.DEBUG;
    //主要用于日志打印Tag标记
    public static final String DEBUG_TAG = "pj";
}
