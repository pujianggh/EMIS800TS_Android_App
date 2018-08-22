package com.android.ts.emis.config;

import com.android.ts.emis.R;

/**
 * 常量
 *
 * @author pujiang
 * @date 2017-10-29 14:31
 * @mail 515210530@qq.com
 * @Description:
 */
public class ConstantsResults {

    public static final String SUCCESS = "success";

    /**
     * 工单已创建 0 派工
     * 工单已派工 1 接单
     * 工单待审批 2 审批
     * 工单处理中 3 完工
     * 工单暂停-继续 4 继续
     * 工单暂停-待派工 5 派工
     * 工单执行完成   6 验证
     * 工单已验证 7 存档
     * 工单已存档 8 评价
     * 工单已关闭 9 查看详情
     * 工单已作废 10 查看详情
     *
     * @param ticketsStatus
     * @return
     */
    public static String getTicketsStatusText(int ticketsStatus) {
        String status = "";
        switch (ticketsStatus) {
            case 0://工单已创建
                status = "派工";
                break;
            case 1://工单已派工
                status = "接单";
                break;
            case 2://工单待审批
                status = "审批";
                break;
            case 3://工单处理中
                status = "完工";
                break;
            case 4://工单暂停-继续
                status = "继续";
                break;
            case 5://工单暂停-待派工
                status = "派工";
                break;
            case 6://工单执行完成
                status = "验证";
                break;
            case 7://工单已验证
                status = "存档";
                break;
            case 8://工单已存档
                status = "评价";
                break;
            case 9://工单已关闭
                status = "查看详情";
                break;
            case 10://工单已作废
                status = "查看详情";
                break;
            default:
                status = "派工";
        }
        return status;
    }

    /**
     * 工单已创建 0 派工
     * 工单已派工 1 接单
     * 工单待审批 2 审批
     * 工单处理中 3 完工
     * 工单暂停-继续 4 继续
     * 工单暂停-待派工 5 派工
     * 工单执行完成   6 验证
     * 工单已验证 7 存档
     * 工单已存档 8 评价
     * 工单已关闭 9 查看详情
     * 工单已作废 10 查看详情
     *
     * @param ticketsStatus
     * @return
     */
    public static int getTicketsStatusColor(int ticketsStatus) {
        int colorId = 0;
        switch (ticketsStatus) {
            case 0://工单已创建
                colorId = R.color.color_order_status_0;
                break;
            case 1://工单已派工
                colorId = R.color.color_order_status_1;
                break;
            case 2://工单待审批
                colorId = R.color.color_order_status_2;
                break;
            case 3://工单处理中
                colorId = R.color.color_order_status_3;
                break;
            case 4://工单暂停-继续
                colorId = R.color.color_order_status_4;
                break;
            case 5://工单暂停-待派工
                colorId = R.color.color_order_status_5;
                break;
            case 6://工单执行完成
                colorId = R.color.color_order_status_6;
                break;
            case 7://工单已验证
                colorId = R.color.color_order_status_7;
                break;
            case 8://工单已存档
                colorId = R.color.color_order_status_8;
                break;
            case 9://工单已关闭
                colorId = R.color.color_order_status_9;
                break;
            case 10://工单已作废
                colorId = R.color.color_order_status_10;
                break;
            default:
                colorId = R.color.color_order_status_9;
        }
        return colorId;
    }

}
