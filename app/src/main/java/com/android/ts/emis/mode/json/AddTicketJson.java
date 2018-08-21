package com.android.ts.emis.mode.json;

import java.io.Serializable;
import java.util.List;

/**
 * @author pujiang
 * @date 2018/8/21 14:01
 * @mail 515210530@qq.com
 * @Description:
 */
public class AddTicketJson implements Serializable{

    /**
     * OrderType : CM
     * HouseCode : 7eb2bcd6-75e9-4f5e-a386-e8ababa7df38
     * HousePhaseCode : 9d642d20-7520-4027-8048-61299a040ebc
     * EstateCode : 1557cc8f-e614-4672-bc0a-906196aa1ea2
     * TicketsFrom : APP
     * RepairBy : jimmy
     * RepairMobile : 15948152635
     * Department : IT
     * TicketsTypeCode : 20180424150207146360
     * TicketsTypeName : 自检->cathy测试->子节点
     * TaskTypeCode : 20180424150236431577
     * TaskTypeName : 子-1->子-2
     * PriorityCode : 20150414170730110785
     * TicketsTitle : jimmy测试工单
     * TicketsDescription : 测试SLA匹配
     * UserCode : jimmy
     * EquipmentList : ["ACS-01F-N01-061","ACS-42F-S01-067"]
     * OrderAttachments : [{"AttName":"(CM234-20180626-0067)fba306d8bc3eb135d5d0a1f5aa1ea8d3fc1f4496.jpg","AttAddress":"/FileUpload/CM234-20180626-0067/(CM234-20180626-0067)fba306d8bc3eb135d5d0a1f5aa1ea8d3fc1f4496.jpg","FileLength":"63.2K","FileType":"Image"},{"AttName":"(CM234-20180626-0067)fba306d8bc3eb135d5d0a1f5aa1ea8d3fc1f4496.jpg","AttAddress":"/FileUpload/CM234-20180626-0067/(CM234-20180626-0067)fba306d8bc3eb135d5d0a1f5aa1ea8d3fc1f4496.jpg","FileLength":"63.2K","FileType":"Image"}]
     */

    private String OrderType;
    private String HouseCode;
    private String HousePhaseCode;
    private String EstateCode;
    private String TicketsFrom;
    private String RepairBy;
    private String RepairMobile;
    private String Department;
    private String TicketsTypeCode;
    private String TicketsTypeName;
    private String TaskTypeCode;
    private String TaskTypeName;
    private String PriorityCode;
    private String TicketsTitle;
    private String TicketsDescription;
    private String UserCode;
    private List<String> EquipmentList;
    private List<OrderAttachmentsBean> OrderAttachments;

    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String OrderType) {
        this.OrderType = OrderType;
    }

    public String getHouseCode() {
        return HouseCode;
    }

    public void setHouseCode(String HouseCode) {
        this.HouseCode = HouseCode;
    }

    public String getHousePhaseCode() {
        return HousePhaseCode;
    }

    public void setHousePhaseCode(String HousePhaseCode) {
        this.HousePhaseCode = HousePhaseCode;
    }

    public String getEstateCode() {
        return EstateCode;
    }

    public void setEstateCode(String EstateCode) {
        this.EstateCode = EstateCode;
    }

    public String getTicketsFrom() {
        return TicketsFrom;
    }

    public void setTicketsFrom(String TicketsFrom) {
        this.TicketsFrom = TicketsFrom;
    }

    public String getRepairBy() {
        return RepairBy;
    }

    public void setRepairBy(String RepairBy) {
        this.RepairBy = RepairBy;
    }

    public String getRepairMobile() {
        return RepairMobile;
    }

    public void setRepairMobile(String RepairMobile) {
        this.RepairMobile = RepairMobile;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getTicketsTypeCode() {
        return TicketsTypeCode;
    }

    public void setTicketsTypeCode(String TicketsTypeCode) {
        this.TicketsTypeCode = TicketsTypeCode;
    }

    public String getTicketsTypeName() {
        return TicketsTypeName;
    }

    public void setTicketsTypeName(String TicketsTypeName) {
        this.TicketsTypeName = TicketsTypeName;
    }

    public String getTaskTypeCode() {
        return TaskTypeCode;
    }

    public void setTaskTypeCode(String TaskTypeCode) {
        this.TaskTypeCode = TaskTypeCode;
    }

    public String getTaskTypeName() {
        return TaskTypeName;
    }

    public void setTaskTypeName(String TaskTypeName) {
        this.TaskTypeName = TaskTypeName;
    }

    public String getPriorityCode() {
        return PriorityCode;
    }

    public void setPriorityCode(String PriorityCode) {
        this.PriorityCode = PriorityCode;
    }

    public String getTicketsTitle() {
        return TicketsTitle;
    }

    public void setTicketsTitle(String TicketsTitle) {
        this.TicketsTitle = TicketsTitle;
    }

    public String getTicketsDescription() {
        return TicketsDescription;
    }

    public void setTicketsDescription(String TicketsDescription) {
        this.TicketsDescription = TicketsDescription;
    }

    public String getUserCode() {
        return UserCode;
    }

    public void setUserCode(String UserCode) {
        this.UserCode = UserCode;
    }

    public List<String> getEquipmentList() {
        return EquipmentList;
    }

    public void setEquipmentList(List<String> EquipmentList) {
        this.EquipmentList = EquipmentList;
    }

    public List<OrderAttachmentsBean> getOrderAttachments() {
        return OrderAttachments;
    }

    public void setOrderAttachments(List<OrderAttachmentsBean> OrderAttachments) {
        this.OrderAttachments = OrderAttachments;
    }

    public static class OrderAttachmentsBean {
        /**
         * AttName : (CM234-20180626-0067)fba306d8bc3eb135d5d0a1f5aa1ea8d3fc1f4496.jpg
         * AttAddress : /FileUpload/CM234-20180626-0067/(CM234-20180626-0067)fba306d8bc3eb135d5d0a1f5aa1ea8d3fc1f4496.jpg
         * FileLength : 63.2K
         * FileType : Image
         */

        private String AttName;
        private String AttAddress;
        private String FileLength;
        private String FileType;

        public String getAttName() {
            return AttName;
        }

        public void setAttName(String AttName) {
            this.AttName = AttName;
        }

        public String getAttAddress() {
            return AttAddress;
        }

        public void setAttAddress(String AttAddress) {
            this.AttAddress = AttAddress;
        }

        public String getFileLength() {
            return FileLength;
        }

        public void setFileLength(String FileLength) {
            this.FileLength = FileLength;
        }

        public String getFileType() {
            return FileType;
        }

        public void setFileType(String FileType) {
            this.FileType = FileType;
        }
    }
}
