package com.android.ts.emis.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.android.ts.emis.app.APPApplication
import com.libcommon.action.utils.LogAPPUtil

/**
 * 数据存储工具
 *
 * @author pujiang
 * @date 2018-1-4 19:50
 * @mail 515210530@qq.com
 * @Description:
 */
object SPUtil {
    private var mSharedPreferences: SharedPreferences? = null

    private val preferneces: SharedPreferences
        @Synchronized get() {
            return mSharedPreferences
                    ?: PreferenceManager.getDefaultSharedPreferences(APPApplication.getInstance())
        }

    fun clear() {
        preferneces.edit().clear().commit()
    }

    fun putString(key: String, value: String) {
        preferneces.edit().putString(key, value).commit()
    }

    fun putApplyString(key: String, value: String) {
        preferneces.edit().putString(key, value).apply()
    }

    fun getString(key: String): String? {
        return preferneces.getString(key, null)
    }

    fun putInt(key: String, value: Int) {
        preferneces.edit().putInt(key, value).commit()
    }

    fun getInt(key: String): Int {
        return preferneces.getInt(key, 0)
    }

    fun putFloat(key: String, value: Float) {
        preferneces.edit().putFloat(key, value).commit()
    }

    fun getFloat(key: String): Float {
        return preferneces.getFloat(key, 0f)
    }

    fun putBoolean(key: String, value: Boolean?) {
        preferneces.edit().putBoolean(key, value!!).commit()
    }

    fun putLong(key: String, value: Long) {
        preferneces.edit().putLong(key, value).commit()
    }

    fun getLong(key: String): Long {
        return preferneces.getLong(key, 0)
    }

    fun getBoolean(key: String, defValue: Boolean): Boolean {
        return preferneces.getBoolean(key, defValue)
    }

    fun remove(key: String) {
        preferneces.edit().remove(key).commit()
    }

    fun hasKey(key: String): Boolean {
        return preferneces.contains(key)
    }

    /**
     * 存储 T 所有(string, int, float, long)数据 key为 T 字段名
     * @param context 当前页面或AppContext.
     * @param t 需要存储的类
     * @param <T> 需要存储的类
    </T> */
    fun <T : Any> putAllModle(context: Context?, t: T?) {
        if (context == null || t == null) {
            return
        }
        val userClass = t.javaClass
        try {
            val fields = userClass.getDeclaredFields()
            for (field in fields) {
                field.isAccessible = true
                val name = t.javaClass.getName() + field.name
                val obj = field.get(t) ?: continue
                val type = field.type.toString()
                when (type) {
                    "class java.lang.String" -> putString(name, obj.toString())
                    "int" -> putInt(name, obj as Int)
                    "float" -> putFloat(name, obj as Float)
                    "long" -> putLong(name, obj as Long)
                }

            }
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

    }

    /**
     * 获取缓存SharedPreferences中的数据
     * @param context 当前页面或者AppContext.
     * @param t 需要获取的类
     * @param <T> 需要获取的类
     * @return 获取查询到的数据并返回实体类
    </T> */
    fun <T : Any> getAllModle(context: Context?, t: T?): T? {
        if (context == null || t == null) {
            LogAPPUtil.e("获取信息失败" + SPUtil::class.java)
            return t
        }
        val userClass = t.javaClass
        try {
            val fields = userClass.getDeclaredFields()
            for (field in fields) {
                field.isAccessible = true
                val name = t.javaClass.getName() + field.name
                val type = field.type.toString()
                when (type) {
                    "class java.lang.String" -> field.set(t, getString(name))
                    "int" -> field.set(t, getInt(name))
                    "float" -> field.set(t, getFloat(name))
                    "long" -> field.set(t, getLong(name))
                }

            }
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
        return t
    }

}