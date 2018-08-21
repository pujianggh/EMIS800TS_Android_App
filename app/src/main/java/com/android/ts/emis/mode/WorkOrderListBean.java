package com.android.ts.emis.mode;

import com.libcommon.action.mode.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 工单列表（根据不同类型）
 *
 * @author pujiang
 * @date 2018-4-4 14:31
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderListBean extends BaseBean implements Serializable {
    private int Total;
    private List<Data> Data;

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public List<WorkOrderListBean.Data> getData() {
        return Data;
    }

    public void setData(List<WorkOrderListBean.Data> data) {
        Data = data;
    }

    public static class Data implements Serializable {
        private String id;
        private int type = 0;//0:全部 1：待处理工单 2：待派批工单（待派工) 3：待审批工单 4：待存档工单 5：待评价工单
        private String orderCode;
        private String pfmCode;
        private String createTime;
        private String state;
        private String orderDescribe;//
        private String orderStatus;

        private String applyName;
        private String phoneNumber;
        private String department;
        private String location;
        private String workOrderType;
        private String serverType;
        private String serverDepartment;
        private String priority;
        private String yuyueTime;
        private String qestionContent;
        private String message;
        private boolean isNew = false;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public boolean isNew() {
            return isNew;
        }

        public void setNew(boolean aNew) {
            isNew = aNew;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        private List<String> photosList;

        private List<StateInfoBean.Data> deviceList;

        public List<StateInfoBean.Data> getDeviceList() {
            return deviceList;
        }

        public void setDeviceList(List<StateInfoBean.Data> deviceList) {
            this.deviceList = deviceList;
        }

        public List<String> getPhotosList() {
            return photosList;
        }

        public void setPhotosList(List<String> photosList) {
            this.photosList = photosList;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getApplyName() {
            return applyName;
        }

        public void setApplyName(String applyName) {
            this.applyName = applyName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getWorkOrderType() {
            return workOrderType;
        }

        public void setWorkOrderType(String workOrderType) {
            this.workOrderType = workOrderType;
        }

        public String getServerType() {
            return serverType;
        }

        public void setServerType(String serverType) {
            this.serverType = serverType;
        }

        public String getServerDepartment() {
            return serverDepartment;
        }

        public void setServerDepartment(String serverDepartment) {
            this.serverDepartment = serverDepartment;
        }

        public String getPriority() {
            return priority;
        }

        public void setPriority(String priority) {
            this.priority = priority;
        }

        public String getYuyueTime() {
            return yuyueTime;
        }

        public void setYuyueTime(String yuyueTime) {
            this.yuyueTime = yuyueTime;
        }

        public String getQestionContent() {
            return qestionContent;
        }

        public void setQestionContent(String qestionContent) {
            this.qestionContent = qestionContent;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrderCode() {
            return orderCode;
        }

        public void setOrderCode(String orderCode) {
            this.orderCode = orderCode;
        }

        public String getPfmCode() {
            return pfmCode;
        }

        public void setPfmCode(String pfmCode) {
            this.pfmCode = pfmCode;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getOrderDescribe() {
            return orderDescribe;
        }

        public void setOrderDescribe(String orderDescribe) {
            this.orderDescribe = orderDescribe;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }
    }
}
