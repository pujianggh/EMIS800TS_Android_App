package com.android.ts.emis.utils

import android.os.Handler

/**
 * 子线程任务工具
 *
 * @author pujiang
 * @date 2018-1-4 19:50
 * @mail 515210530@qq.com
 * @Description:
 */
object ThreadUtil {
    private val sHandler = Handler()

    /**
     * 在子线程执行任务
     *
     * @param task
     */
    fun runInThread(task: Runnable) {
        Thread(task).start()
    }

    /**
     * 在UI线程执行任务
     *
     * @param task
     */
    fun runInUIThread(task: Runnable) {
        sHandler.post(task)
    }

    /**
     * 在UI线程延时执行任务
     *
     * @param task
     * @param delayMillis 延时时间，单位毫秒
     */
    fun runInUIThread(task: Runnable, delayMillis: Long) {
        sHandler.postDelayed(task, delayMillis)
    }
}