package com.android.ts.emis.config;

/**
 * 网络连接环境配置
 *
 * @author pujiang
 * @date 2017-10-29 14:31
 * @mail 515210530@qq.com
 * @Description:
 */
public class ConstantsUrls {

    public static String[] WEBUrl = new String[]{
            "http://app3.800ts.com.cn/emis_openapi/api",
            "https://sjm-uat.flyfnd.com/sijimoney"
    };

    public static String[] APPUrl = new String[]{
            "http://app3.800ts.com.cn/emis_openapi/api",
            "https://sjm-uat.flyfnd.com/sijimoney"
    };

    //账号登录
    public static String UserLogin = "/v1/User/App_Login";
    //获取消息列表
    public static String GetUnreadMessages = "/Message/APP_GetUnreadMessages";
    //消息提醒设为已读
    public static String SetUnreadMessage = "/Message/APP_SetUnreadMessage";
    //工单查询列表
    public static String GetTicketsByConditionQuery = "/TicketsManage/GetTicketsByConditionQuery";
    //新增工单
    public static String AddTickets = "/TicketsManage/AddTickets";
    //获取工单详细信息
    public static String GetTicketsByTicketsCode = "/TicketsManage/GetTicketsByTicketsCode";


    //获取执行人列表
    public static String GetMaintenancePlanInfoByCalendarCode = "/v1/Executor/App_GetMaintenancePlanInfoByCalendarCode";

}
