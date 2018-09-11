package com.android.ts.emis.mvp.iface;

import android.content.Context;

import com.android.ts.emis.mode.json.UpdateTicketJson;
import com.android.ts.emis.mode.json.AddTicketJson;
import com.android.ts.emis.net.OkhttpUtil;
import com.libcommon.action.net.INetWorkCallBack;

/**
 * @author pujiang
 * @date 2018/8/14 17:44
 * @mail 515210530@qq.com
 * @Description:
 */
public interface IWorkOrderInfo {

    /**
     * 接单工单
     *
     * @param context
     * @param callBack
     * @param acceptTicketJson
     */
    public void getUpdateTickets(Context context, INetWorkCallBack callBack, UpdateTicketJson acceptTicketJson);

    /**
     * 添加工单
     *
     * @param context
     * @param callBack
     * @param addTicketJson
     */
    public void getAddTickets(Context context, INetWorkCallBack callBack, AddTicketJson addTicketJson);

    /**
     * 获取工单详细信息
     *
     * @param context
     * @param callBack
     * @param ticketsCode
     */
    public void getTicketsWorkOrderInfo(Context context, INetWorkCallBack callBack, String ticketsCode);

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
    public void getWorkOrderQueryLists(Context context, INetWorkCallBack callBack, String page, String size,
                                       String ticketsCode, String houseCode, String housePhaseCode, String estateCode, String createStartTime, String createEndTime, String ticketsTypeCode,
                                       String priorityCode, String ticketsStatus, OkhttpUtil.GetUrlMode modle);

}
