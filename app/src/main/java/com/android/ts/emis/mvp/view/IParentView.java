package com.android.ts.emis.mvp.view;

/**
 * @author pujiang
 * @date 2017-11-20 17:33
 * @mail 515210530@qq.com
 * @Description:
 */
public interface IParentView {
    /**
     * 显示提示框
     */
    void showLoading(String message);

    /**
     * 显示提示框
     */
    void showLoading();

    /**
     * 关闭提示框
     */
    void hideLoading();

    /**
     * 无网提示
     */
    void noNetWork();

    /**
     * 错误提示
     *
     * @param message
     * @param status 错误码
     */
    void showError(int status, String message);

    /**
     * 提示信息
     *
     * @param message
     */
    void showToast(String message);
}
