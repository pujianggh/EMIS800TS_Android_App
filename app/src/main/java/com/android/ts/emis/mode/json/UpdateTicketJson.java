package com.android.ts.emis.mode.json;

import java.io.Serializable;
import java.util.List;

/**
 * @author pujiang
 * @date 2018/8/21 14:01
 * @mail 515210530@qq.com
 * @Description:
 */
public class UpdateTicketJson implements Serializable {

    /**
     * TicketsCode : CM234-20180822-0075
     * ActionType : 4
     * TicketsStatus : 3
     * UserCode : jimmy
     * ExecutorList : [{"ID":1044,"ExecutorCode":"ET_SUPPLIER_20170615164502"}]
     */

    private String TicketsCode;
    private int ActionType;
    private String IsPass;
    private int TicketsStatus;
    private String UserCode;
    private String Description;
    private List<ExecutorListBean> ExecutorList;

    public String getIsPass() {
        return IsPass;
    }

    public void setIsPass(String isPass) {
        IsPass = isPass;
    }

    public String getTicketsCode() {
        return TicketsCode;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setTicketsCode(String TicketsCode) {
        this.TicketsCode = TicketsCode;
    }

    public int getActionType() {
        return ActionType;
    }

    public void setActionType(int ActionType) {
        this.ActionType = ActionType;
    }

    public int getTicketsStatus() {
        return TicketsStatus;
    }

    public void setTicketsStatus(int TicketsStatus) {
        this.TicketsStatus = TicketsStatus;
    }

    public String getUserCode() {
        return UserCode;
    }

    public void setUserCode(String UserCode) {
        this.UserCode = UserCode;
    }

    public List<ExecutorListBean> getExecutorList() {
        return ExecutorList;
    }

    public void setExecutorList(List<ExecutorListBean> ExecutorList) {
        this.ExecutorList = ExecutorList;
    }

    public static class ExecutorListBean {
        /**
         * ID : 1044
         * ExecutorCode : ET_SUPPLIER_20170615164502
         */

        private int ID;
        private String ExecutorCode;
        private String Remark;

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String remark) {
            Remark = remark;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getExecutorCode() {
            return ExecutorCode;
        }

        public void setExecutorCode(String ExecutorCode) {
            this.ExecutorCode = ExecutorCode;
        }
    }
}
