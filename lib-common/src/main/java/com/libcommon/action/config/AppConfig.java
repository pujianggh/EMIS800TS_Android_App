package com.libcommon.action.config;

import com.libcommon.action.utils.FileUtil;

/**
 * 生产环境配置config
 *
 * @author pujiang
 * @date 2017-9-3 19:57
 * @mail 515210530@qq.com
 * @Description:
 */
public final class AppConfig {
    //SharedPreferences保存名字
    public static final String SHARED_PREFERENCE_NAME = "sharepreferences_iData";
    //首先默认缓存文件路径
    private static final String FILE_CACHE_PATH_ROOT = FileUtil.getCachePath();//保存到SD卡
    //文件路径保存的确切位置
    public static final String FILE_CACHE_PATH = FILE_CACHE_PATH_ROOT + "/EMIS_Cache";
    //图片地址
    public static final String FILE_PHOTO_PATH = FILE_CACHE_PATH + "/photo";
    //版本更新APK文件位置
    public static final String FILE_APK_PATH = FILE_CACHE_PATH + "/apkfile";
    //版本更新APK文件名称
    public static final String FILE_APK_NAME = "JRTZ_update_apk.apk";
    //补丁文件位置
    public static final String FILE_PATCH_PATH = FILE_CACHE_PATH + "/patchfile";
    //补丁文件名称
    public static final String FILE_PATCH_NAME = "JRTZ_android.apatch";

}
