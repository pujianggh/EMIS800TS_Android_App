package com.android.ts.emis.mvp.iface;

import android.content.Context;

import com.libcommon.action.net.INetWorkCallBack;

/**
 * @author pujiang
 * @date 2018/8/14 17:44
 * @mail 515210530@qq.com
 * @Description:
 */
public interface IConfigureInfo {

    /**
     * 获取执行人列表
     *
     * @param context
     * @param callBack
     * @param ticketsCode
     */
    public void getMaintenancePlanInfoLists(Context context, INetWorkCallBack callBack, String ticketsCode);

}
