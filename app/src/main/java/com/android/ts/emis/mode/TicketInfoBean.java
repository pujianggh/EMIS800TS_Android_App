package com.android.ts.emis.mode;

import java.io.Serializable;

/**
 * 工单数据
 *
 * @author pujiang
 * @date 2018/8/20 15:44
 * @mail 515210530@qq.com
 * @Description:
 */
public class TicketInfoBean implements Serializable {

    private String TicketsCode;
    private int TicketsStatus;
    private String TicketsStatusName;
    private String CreateDate;
    private String TicketsDescription;
    private String PriorityCode;
    private String PriorityName;

    public String getTicketsCode() {
        return TicketsCode;
    }

    public void setTicketsCode(String ticketsCode) {
        TicketsCode = ticketsCode;
    }

    public int getTicketsStatus() {
        return TicketsStatus;
    }

    public void setTicketsStatus(int ticketsStatus) {
        TicketsStatus = ticketsStatus;
    }

    public String getTicketsStatusName() {
        return TicketsStatusName;
    }

    public void setTicketsStatusName(String ticketsStatusName) {
        TicketsStatusName = ticketsStatusName;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public String getTicketsDescription() {
        return TicketsDescription;
    }

    public void setTicketsDescription(String ticketsDescription) {
        TicketsDescription = ticketsDescription;
    }

    public String getPriorityCode() {
        return PriorityCode;
    }

    public void setPriorityCode(String priorityCode) {
        PriorityCode = priorityCode;
    }

    public String getPriorityName() {
        return PriorityName;
    }

    public void setPriorityName(String priorityName) {
        PriorityName = priorityName;
    }
}
