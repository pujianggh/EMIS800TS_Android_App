package com.android.ts.emis.mvp.impl;

import android.content.Context;

import com.android.ts.emis.config.ConstantsUrls;
import com.android.ts.emis.mode.MaintenancePlanInfoBean;
import com.android.ts.emis.mvp.iface.IConfigureInfo;
import com.android.ts.emis.net.OkhttpUtil;
import com.libcommon.action.net.INetWorkCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pujiang
 * @date 2018/8/14 17:46
 * @mail 515210530@qq.com
 * @Description:
 */
public class ConfigureInfoImpl implements IConfigureInfo {

    /**
     * 获取执行人列表
     *
     * @param context
     * @param callBack
     * @param ticketsCode
     */
    @Override
    public void getMaintenancePlanInfoLists(Context context, INetWorkCallBack callBack, String ticketsCode) {
        Map<String, String> params = new HashMap<>();
        params.put("TicketsCode", ticketsCode);
        OkhttpUtil.getParamClass(context, ConstantsUrls.GetMaintenancePlanInfoByCalendarCode, params, MaintenancePlanInfoBean.class,
                OkhttpUtil.GetUrlMode.NORMAL, callBack, "");
    }

}
