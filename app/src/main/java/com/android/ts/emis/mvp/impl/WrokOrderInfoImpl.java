package com.android.ts.emis.mvp.impl;

import android.content.Context;

import com.android.ts.emis.config.ConstantsUrls;
import com.android.ts.emis.mode.TicketDetailInfoBean;
import com.android.ts.emis.mode.WorkOrderQueryListBean;
import com.android.ts.emis.mvp.iface.IWorkOrderInfo;
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
public class WrokOrderInfoImpl implements IWorkOrderInfo {

    /**
     * 获取工单详细信息
     *
     * @param context
     * @param callBack
     * @param ticketsCode
     */
    @Override
    public void getTicketsWorkOrderInfo(Context context, INetWorkCallBack callBack, String ticketsCode) {
        Map<String, String> params = new HashMap<>();
        params.put("TicketsCode", ticketsCode);
        OkhttpUtil.getClass(context, ConstantsUrls.GetTicketsByTicketsCode, params, TicketDetailInfoBean.class,
                OkhttpUtil.GetUrlMode.NORMAL, callBack, "");
    }

    /**
     * 工单查询
     *
     * @param context
     * @param callBack
     * @param page
     * @param size
     * @param ticketsCode
     * @param houseCode
     * @param housePhaseCode
     * @param estateCode
     * @param createStartTime
     * @param createEndTime
     * @param ticketsTypeCode
     * @param priorityCode
     * @param ticketsStatus
     * @param modle
     */
    @Override
    public void getWorkOrderQueryLists(Context context, INetWorkCallBack callBack, String page, String size, String ticketsCode, String houseCode, String housePhaseCode, String estateCode, String createStartTime, String createEndTime, String ticketsTypeCode, String priorityCode, String ticketsStatus, OkhttpUtil.GetUrlMode modle) {
        Map<String, String> params = new HashMap<>();
        params.put("TicketsCode", ticketsCode);
        params.put("HouseCode", houseCode);
        params.put("HousePhaseCode", housePhaseCode);
        params.put("EstateCode", estateCode);
        params.put("CreateStartTime", createStartTime);
        params.put("CreateEndTime", createEndTime);
        params.put("TicketsTypeCode", ticketsTypeCode);
        params.put("PriorityCode", priorityCode);
        params.put("TicketsStatus", ticketsStatus);
        params.put("PageIndex", page);
        params.put("PageSize", size);
        OkhttpUtil.postGetClass(context, ConstantsUrls.GetTicketsByConditionQuery, params, WorkOrderQueryListBean.class,
                modle, callBack, "");
    }
}
