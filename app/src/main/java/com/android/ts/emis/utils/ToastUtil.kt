package com.android.ts.emis.utils

import android.support.annotation.StringRes
import android.text.TextUtils
import android.widget.Toast

import com.android.ts.emis.app.APPApplication

/**
 * 自定义提示
 *
 * @author pujiang
 * @date 2017-9-4 19:50
 * @mail 515210530@qq.com
 * @Description:
 */
object ToastUtil {

    /**
     * 提示处理
     *
     * @param text
     */
    fun show(text: CharSequence) {
        if (TextUtils.isEmpty(text)) return
        if (text.length < 10) {
            Toast.makeText(APPApplication.getInstance(), text, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(APPApplication.getInstance(), text, Toast.LENGTH_LONG).show()
        }
    }

    /**
     * 提示处理
     *
     * @param resId
     */
    fun show(@StringRes resId: Int) {
        show(APPApplication.getInstance().getString(resId))
    }

}