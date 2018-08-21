package com.android.ts.emis.mvp.impl;

import android.content.Context;

import com.android.ts.emis.config.ConstantsUrls;
import com.android.ts.emis.mode.MessageInfoBean;
import com.android.ts.emis.mvp.iface.IMessageInfo;
import com.android.ts.emis.net.OkhttpUtil;
import com.libcommon.action.mode.BaseBean;
import com.libcommon.action.net.INetWorkCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pujiang
 * @date 2018/8/14 17:46
 * @mail 515210530@qq.com
 * @Description:
 */
public class MessageInfoImpl implements IMessageInfo {

    /**
     * 获取消息信息列表
     *
     * @param context
     * @param callBack
     * @param page
     * @param size
     * @param userCode
     * @param houseCode
     * @param modle
     */
    @Override
    public void getMessageInfoLists(Context context, INetWorkCallBack callBack, String page, String size, String userCode, String houseCode, OkhttpUtil.GetUrlMode modle) {
        Map<String, String> params = new HashMap<>();
        params.put("PageIndex", page);
        params.put("PageSize", size);
        params.put("HouseCode", houseCode);
        params.put("UserCode", userCode);
        OkhttpUtil.postParamClass(context, ConstantsUrls.GetUnreadMessages, params, MessageInfoBean.class,
                modle, callBack, "");
    }

    /**
     * 标记信息读取
     *
     * @param context
     * @param callBack
     * @param bdid
     */
    @Override
    public void setMessageRead(Context context, INetWorkCallBack callBack, String bdid) {
        Map<String, String> params = new HashMap<>();
        params.put("BDID", bdid);
        OkhttpUtil.postParamClass(context, ConstantsUrls.SetUnreadMessage, params, BaseBean.class,
                OkhttpUtil.GetUrlMode.NORMAL, callBack, "");
    }
}
