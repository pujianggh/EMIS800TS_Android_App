package com.android.ts.emis.mvp.impl;

import android.content.Context;

import com.android.ts.emis.config.ConstantsUrls;
import com.android.ts.emis.mode.MaintenancePlanInfoBean;
import com.android.ts.emis.mvp.iface.IConfigureInfo;
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
        OkhttpUtil.getParamClass(context, ConstantsUrls.GetExecutorByTicketsCode, params, BaseBean.class,
                OkhttpUtil.GetUrlMode.NORMAL, callBack, ticketsCode);
    }

    /**
     * 离线数据
     * "equipment"://设备
     * "equipmenttype"://设备类型
     * "estate"://位置
     * "bu"://部门-暂定
     * "priority"://优先级
     * "sla"://工作流程-暂定
     * "tickettype"://服务类型
     * "tasktype"://需求类型
     *
     * @param context
     * @param callBack
     * @param dataType
     */
    @Override
    public void getGetOfflineDataInfo(Context context, INetWorkCallBack callBack, String dataType) {
        Map<String, String> params = new HashMap<>();
        params.put("dataType", dataType);
        OkhttpUtil.postParamClass(context, ConstantsUrls.GetOfflineData, params, MaintenancePlanInfoBean.class,
                OkhttpUtil.GetUrlMode.NORMAL, callBack, dataType);
    }
}
