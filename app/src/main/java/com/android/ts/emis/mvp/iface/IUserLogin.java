package com.android.ts.emis.mvp.iface;

import android.content.Context;

import com.libcommon.action.net.INetWorkCallBack;

/**
 * @author pujiang
 * @date 2018/8/14 17:44
 * @mail 515210530@qq.com
 * @Description:
 */
public interface IUserLogin {

    /**
     * 登录
     *
     * @param context
     * @param callBack
     * @param userCode
     * @param passWord
     * @param constantTag
     */
    public void login(Context context,INetWorkCallBack callBack,
                      String userCode, String passWord, String constantTag);

}
