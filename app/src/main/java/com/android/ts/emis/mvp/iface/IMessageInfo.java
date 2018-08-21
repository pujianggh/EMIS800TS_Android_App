package com.android.ts.emis.mvp.iface;

import android.content.Context;

import com.android.ts.emis.net.OkhttpUtil;
import com.libcommon.action.net.INetWorkCallBack;

/**
 * @author pujiang
 * @date 2018/8/14 17:44
 * @mail 515210530@qq.com
 * @Description:
 */
public interface IMessageInfo {

    /**
     * 获取信息列表
     *
     * @param context
     * @param callBack
     * @param page
     * @param size
     * @param userCode
     * @param houseCode
     * @param modle
     */
    public void getMessageInfoLists(Context context, INetWorkCallBack callBack, String page, String size, String userCode, String houseCode, OkhttpUtil.GetUrlMode modle);


    /**
     * 设置信息已读
     *
     * @param context
     * @param callBack
     * @param bdid
     */
    public void setMessageRead(Context context, INetWorkCallBack callBack, String bdid);

}
