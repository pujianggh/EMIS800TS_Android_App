package com.android.ts.emis.mvp.impl;

import android.content.Context;

import com.android.ts.emis.config.ConstantsUrls;
import com.android.ts.emis.mode.UserInfoBean;
import com.android.ts.emis.mvp.iface.IUserLogin;
import com.android.ts.emis.net.OkhttpUtil;
import com.libcommon.action.net.INetWorkCallBack;
import com.libcommon.action.utils.APPToolsUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pujiang
 * @date 2018/8/14 17:46
 * @mail 515210530@qq.com
 * @Description:
 */
public class UserLoginImpl implements IUserLogin {

    /**
     * @param context
     * @param callBack
     * @param userCode
     * @param passWord
     * @param constantTag
     */
    public void login(Context context, INetWorkCallBack callBack,
                      String userCode, String passWord, String constantTag) {
        Map<String, String> params = new HashMap<>();
        params.put("jhVer", APPToolsUtil.getAppVersionName(context));
        params.put("UserCode", userCode);
        params.put("PassWord", passWord);
        params.put("device", OkhttpUtil.drivice);
        params.put("DeviceToken", OkhttpUtil.drivice);
        OkhttpUtil.postParamClass(context, ConstantsUrls.UserLogin, params, UserInfoBean.class,
                OkhttpUtil.GetUrlMode.NORMAL, callBack, constantTag);
    }

}
