package com.libcommon.action.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import java.util.Locale;

/**
 * 语言切换
 *
 * @author pujiang
 * @date 2018-7-11 10:51
 * @mail 515210530@qq.com
 * @Description:
 */
public class LanguageUtil {
    public static final String ENGLISH = "en";
    public static final String CHINESE = "zh";
    public static final String JAPANESE = "ja";
    private static final String LANGUAGE_KEY = "language_key";

    /**
     * 语言APP设置
     *
     * @param language
     */
    public static void setAPPLanguage(Context context, String language) {
        setLanguageConfig(context, language);
    }


    /**
     * 语言APP设置
     *
     * @param context
     */
    public static Context setAPPLanguage(Context context) {
        return setLanguageConfig(context, getAPPLanguage(context));
    }

    /**
     * 语言设置
     *
     * @param language
     */
    public static Context setLanguageConfig(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        //做版本兼容性判断
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(locale);
            context = context.createConfigurationContext(config);
        } else {
            config.locale = locale;
            //点进去看方法详情
            res.updateConfiguration(config, res.getDisplayMetrics());
        }
        putCacheLanguage(context, language);
        return context;
    }

    /**
     * 获取语言环境
     *
     * @param context
     * @return
     */
    public static String getAPPLanguage(Context context) {
        String language = getCacheLanguage(context);
        if (TextUtils.isEmpty(language)) {
            language = getAppLocaleLanguage();
        }
        return language;
    }

    /**
     * 获取本地系统语言
     *
     * @return
     */
    public static String getAppLocaleLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * SharedPreferences获取语言环境
     *
     * @param context
     * @return
     */
    public static String getCacheLanguage(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(LANGUAGE_KEY, "zh");
    }

    /**
     * 缓存语言环境
     *
     * @param context
     * @param language
     */
    private static void putCacheLanguage(Context context, String language) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences.edit().putString(LANGUAGE_KEY, language).commit();
    }
}