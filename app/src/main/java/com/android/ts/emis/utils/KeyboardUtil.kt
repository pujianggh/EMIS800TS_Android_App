package com.android.ts.emis.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Handler
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * 键盘工具
 *
 * @author pujiang
 * @date 2018-1-4 19:50
 * @mail 515210530@qq.com
 * @Description:
 */
object KeyboardUtil {

    /**
     * 关闭activity中打开的键盘
     *
     * @param activity
     */
    fun closeKeyboard(activity: Activity) {
        val view = activity.window.peekDecorView()
        if (view != null) {
            val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    /**
     * 关闭dialog中打开的键盘
     *
     * @param dialog
     */
    fun closeKeyboard(dialog: Dialog) {
        val view = dialog.window!!.peekDecorView()
        if (view != null) {
            val inputMethodManager = dialog.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    /**
     * 打开键盘
     *
     * @param context
     * @param editText
     */
    fun openKeyboard(context: Context, editText: EditText) {
        Handler().postDelayed({
            editText.requestFocus()
            editText.setSelection(editText.text.toString().length)
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED)
        }, 300)
    }

}