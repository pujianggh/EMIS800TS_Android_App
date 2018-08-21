package com.android.ts.emis.mode;

import com.libcommon.action.mode.BaseBean;

import java.util.List;

/**
 * @author pujiang
 * @date 2018/8/16 15:19
 * @mail 515210530@qq.com
 * @Description:
 */
public class TicketDetailInfoBean extends BaseBean {

    /**
     * data : {"TicketsCode":"CM234-20180817-0078","TicketsStatus":1,"TicketsStatusName":"已派工","HouseCode":"7eb2bcd6-75e9-4f5e-a386-e8ababa7df38","HousePhaseCode":"9d642d20-7520-4027-8048-61299a040ebc","EstateCode":"1557cc8f-e614-4672-bc0a-906196aa1ea2","RepairBy":"王五","RepairMobile":"135624186547","Department":null,"TicketsTypeCode":"20180424150207146360","TicketsTypeName":"自检->cathy测试->子节点","TaskTypeCode":"20180424150236431577","TaskTypeName":"子-1->子-2","PriorityCode":"20150414170730110785","PriorityColor":"#d664b6","PriorityRemark":"2小时","TicketsTitle":"测试","TicketsDescription":"测试工单","ForecastBeginTime":"","ForecastEndTime":"","DistributerWorkContent":null,"ExecutorList":[{"ID":1,"TicketsCode":"CM234-20180817-0078","ExecutorCode":"ET_PROPERTY_20170619154230","ExecutorName":"葛丙乐","IsDirector":0,"Status":0,"StartTime":"","FinishTime":""},{"ID":2,"TicketsCode":"CM234-20180817-0078","ExecutorCode":"ET_PROPERTY_20170619154204","ExecutorName":"王希春","IsDirector":0,"Status":0,"StartTime":"","FinishTime":""}],"MaintenancePlan":{"MaintenancePlanSteps":[]},"EquipmentList":[{"TicketEquipID":7,"TicketsCode":"CM234-20180817-0078","EquipmentCode":"073c907a-4490-4708-bdc7-5028193d80a2","EquipmentName":"wr-03","EquipmentTypeCode":"ac7d0b30f80942a6b572584ecb2139c0","EquipmentTypeName":"苏泊尔002","Position":"","SceneDescription":null,"ProcessingMode":null,"Remark":""},{"TicketEquipID":8,"TicketsCode":"CM234-20180817-0078","EquipmentCode":"0a6cffec-348f-4cbe-ac4a-d015d5c1c849","EquipmentName":"212","EquipmentTypeCode":"af71da7d80544632bb59c51e801b5fbc","EquipmentTypeName":"洗衣机\\","Position":"","SceneDescription":null,"ProcessingMode":null,"Remark":""}],"LocationList":[],"MaterialList":[],"ToolList":[],"HistoryList":[{"TicketsCode":"CM234-20180817-0078","ActionTypeName":"新建工单","Remark":null,"Creator":"jimmy","CreateDate":"2018/8/17 19:35:55","HistoryAttachments":[]},{"TicketsCode":"CM234-20180817-0078","ActionTypeName":"派工","Remark":"根据匹配的SLA流程,创建的工单状态自动变更为已派工.","Creator":"jimmy","CreateDate":"2018/8/17 19:35:55","HistoryAttachments":[]}],"OrderAttachments":[]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * TicketsCode : CM234-20180817-0078
         * TicketsStatus : 1
         * TicketsStatusName : 已派工
         * HouseCode : 7eb2bcd6-75e9-4f5e-a386-e8ababa7df38
         * HousePhaseCode : 9d642d20-7520-4027-8048-61299a040ebc
         * EstateCode : 1557cc8f-e614-4672-bc0a-906196aa1ea2
         * RepairBy : 王五
         * RepairMobile : 135624186547
         * Department : null
         * TicketsTypeCode : 20180424150207146360
         * TicketsTypeName : 自检->cathy测试->子节点
         * TaskTypeCode : 20180424150236431577
         * TaskTypeName : 子-1->子-2
         * PriorityCode : 20150414170730110785
         * PriorityColor : #d664b6
         * PriorityRemark : 2小时
         * TicketsTitle : 测试
         * TicketsDescription : 测试工单
         * ForecastBeginTime :
         * ForecastEndTime :
         * DistributerWorkContent : null
         * ExecutorList : [{"ID":1,"TicketsCode":"CM234-20180817-0078","ExecutorCode":"ET_PROPERTY_20170619154230","ExecutorName":"葛丙乐","IsDirector":0,"Status":0,"StartTime":"","FinishTime":""},{"ID":2,"TicketsCode":"CM234-20180817-0078","ExecutorCode":"ET_PROPERTY_20170619154204","ExecutorName":"王希春","IsDirector":0,"Status":0,"StartTime":"","FinishTime":""}]
         * MaintenancePlan : {"MaintenancePlanSteps":[]}
         * EquipmentList : [{"TicketEquipID":7,"TicketsCode":"CM234-20180817-0078","EquipmentCode":"073c907a-4490-4708-bdc7-5028193d80a2","EquipmentName":"wr-03","EquipmentTypeCode":"ac7d0b30f80942a6b572584ecb2139c0","EquipmentTypeName":"苏泊尔002","Position":"","SceneDescription":null,"ProcessingMode":null,"Remark":""},{"TicketEquipID":8,"TicketsCode":"CM234-20180817-0078","EquipmentCode":"0a6cffec-348f-4cbe-ac4a-d015d5c1c849","EquipmentName":"212","EquipmentTypeCode":"af71da7d80544632bb59c51e801b5fbc","EquipmentTypeName":"洗衣机\\","Position":"","SceneDescription":null,"ProcessingMode":null,"Remark":""}]
         * LocationList : []
         * MaterialList : []
         * ToolList : []
         * HistoryList : [{"TicketsCode":"CM234-20180817-0078","ActionTypeName":"新建工单","Remark":null,"Creator":"jimmy","CreateDate":"2018/8/17 19:35:55","HistoryAttachments":[]},{"TicketsCode":"CM234-20180817-0078","ActionTypeName":"派工","Remark":"根据匹配的SLA流程,创建的工单状态自动变更为已派工.","Creator":"jimmy","CreateDate":"2018/8/17 19:35:55","HistoryAttachments":[]}]
         * OrderAttachments : []
         */

        private String TicketsCode;
        private int TicketsStatus;
        private String TicketsStatusName;
        private String HouseCode;
        private String HousePhaseCode;
        private String EstateCode;
        private String RepairBy;
        private String RepairMobile;
        private String Department;
        private String TicketsTypeCode;
        private String TicketsTypeName;
        private String TaskTypeCode;
        private String TaskTypeName;
        private String PriorityCode;
        private String PriorityColor;
        private String PriorityRemark;
        private String TicketsTitle;
        private String TicketsDescription;
        private String ForecastBeginTime;
        private String ForecastEndTime;
        private String DistributerWorkContent;
        private MaintenancePlanBean MaintenancePlan;
        private List<ExecutorListBean> ExecutorList;
        private List<EquipmentListBean> EquipmentList;
        private List<?> LocationList;
        private List<?> MaterialList;
        private List<?> ToolList;
        private List<HistoryListBean> HistoryList;
        private List<?> OrderAttachments;

        public String getTicketsCode() {
            return TicketsCode;
        }

        public void setTicketsCode(String TicketsCode) {
            this.TicketsCode = TicketsCode;
        }

        public int getTicketsStatus() {
            return TicketsStatus;
        }

        public void setTicketsStatus(int TicketsStatus) {
            this.TicketsStatus = TicketsStatus;
        }

        public String getTicketsStatusName() {
            return TicketsStatusName;
        }

        public void setTicketsStatusName(String TicketsStatusName) {
            this.TicketsStatusName = TicketsStatusName;
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

        public String getPriorityColor() {
            return PriorityColor;
        }

        public void setPriorityColor(String PriorityColor) {
            this.PriorityColor = PriorityColor;
        }

        public String getPriorityRemark() {
            return PriorityRemark;
        }

        public void setPriorityRemark(String PriorityRemark) {
            this.PriorityRemark = PriorityRemark;
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

        public String getForecastBeginTime() {
            return ForecastBeginTime;
        }

        public void setForecastBeginTime(String ForecastBeginTime) {
            this.ForecastBeginTime = ForecastBeginTime;
        }

        public String getForecastEndTime() {
            return ForecastEndTime;
        }

        public void setForecastEndTime(String ForecastEndTime) {
            this.ForecastEndTime = ForecastEndTime;
        }

        public String getDistributerWorkContent() {
            return DistributerWorkContent;
        }

        public void setDistributerWorkContent(String DistributerWorkContent) {
            this.DistributerWorkContent = DistributerWorkContent;
        }

        public MaintenancePlanBean getMaintenancePlan() {
            return MaintenancePlan;
        }

        public void setMaintenancePlan(MaintenancePlanBean MaintenancePlan) {
            this.MaintenancePlan = MaintenancePlan;
        }

        public List<ExecutorListBean> getExecutorList() {
            return ExecutorList;
        }

        public void setExecutorList(List<ExecutorListBean> ExecutorList) {
            this.ExecutorList = ExecutorList;
        }

        public List<EquipmentListBean> getEquipmentList() {
            return EquipmentList;
        }

        public void setEquipmentList(List<EquipmentListBean> EquipmentList) {
            this.EquipmentList = EquipmentList;
        }

        public List<?> getLocationList() {
            return LocationList;
        }

        public void setLocationList(List<?> LocationList) {
            this.LocationList = LocationList;
        }

        public List<?> getMaterialList() {
            return MaterialList;
        }

        public void setMaterialList(List<?> MaterialList) {
            this.MaterialList = MaterialList;
        }

        public List<?> getToolList() {
            return ToolList;
        }

        public void setToolList(List<?> ToolList) {
            this.ToolList = ToolList;
        }

        public List<HistoryListBean> getHistoryList() {
            return HistoryList;
        }

        public void setHistoryList(List<HistoryListBean> HistoryList) {
            this.HistoryList = HistoryList;
        }

        public List<?> getOrderAttachments() {
            return OrderAttachments;
        }

        public void setOrderAttachments(List<?> OrderAttachments) {
            this.OrderAttachments = OrderAttachments;
        }

        public static class MaintenancePlanBean {
            private List<?> MaintenancePlanSteps;

            public List<?> getMaintenancePlanSteps() {
                return MaintenancePlanSteps;
            }

            public void setMaintenancePlanSteps(List<?> MaintenancePlanSteps) {
                this.MaintenancePlanSteps = MaintenancePlanSteps;
            }
        }

        public static class ExecutorListBean {
            /**
             * ID : 1
             * TicketsCode : CM234-20180817-0078
             * ExecutorCode : ET_PROPERTY_20170619154230
             * ExecutorName : 葛丙乐
             * IsDirector : 0
             * Status : 0
             * StartTime :
             * FinishTime :
             */

            private int ID;
            private String TicketsCode;
            private String ExecutorCode;
            private String ExecutorName;
            private int IsDirector;
            private int Status;
            private String StartTime;
            private String FinishTime;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public String getTicketsCode() {
                return TicketsCode;
            }

            public void setTicketsCode(String TicketsCode) {
                this.TicketsCode = TicketsCode;
            }

            public String getExecutorCode() {
                return ExecutorCode;
            }

            public void setExecutorCode(String ExecutorCode) {
                this.ExecutorCode = ExecutorCode;
            }

            public String getExecutorName() {
                return ExecutorName;
            }

            public void setExecutorName(String ExecutorName) {
                this.ExecutorName = ExecutorName;
            }

            public int getIsDirector() {
                return IsDirector;
            }

            public void setIsDirector(int IsDirector) {
                this.IsDirector = IsDirector;
            }

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
            }

            public String getStartTime() {
                return StartTime;
            }

            public void setStartTime(String StartTime) {
                this.StartTime = StartTime;
            }

            public String getFinishTime() {
                return FinishTime;
            }

            public void setFinishTime(String FinishTime) {
                this.FinishTime = FinishTime;
            }
        }

        public static class EquipmentListBean {
            /**
             * TicketEquipID : 7
             * TicketsCode : CM234-20180817-0078
             * EquipmentCode : 073c907a-4490-4708-bdc7-5028193d80a2
             * EquipmentName : wr-03
             * EquipmentTypeCode : ac7d0b30f80942a6b572584ecb2139c0
             * EquipmentTypeName : 苏泊尔002
             * Position :
             * SceneDescription : null
             * ProcessingMode : null
             * Remark :
             */

            private int TicketEquipID;
            private String TicketsCode;
            private String EquipmentCode;
            private String EquipmentName;
            private String EquipmentTypeCode;
            private String EquipmentTypeName;
            private String Position;
            private Object SceneDescription;
            private Object ProcessingMode;
            private String Remark;

            public int getTicketEquipID() {
                return TicketEquipID;
            }

            public void setTicketEquipID(int TicketEquipID) {
                this.TicketEquipID = TicketEquipID;
            }

            public String getTicketsCode() {
                return TicketsCode;
            }

            public void setTicketsCode(String TicketsCode) {
                this.TicketsCode = TicketsCode;
            }

            public String getEquipmentCode() {
                return EquipmentCode;
            }

            public void setEquipmentCode(String EquipmentCode) {
                this.EquipmentCode = EquipmentCode;
            }

            public String getEquipmentName() {
                return EquipmentName;
            }

            public void setEquipmentName(String EquipmentName) {
                this.EquipmentName = EquipmentName;
            }

            public String getEquipmentTypeCode() {
                return EquipmentTypeCode;
            }

            public void setEquipmentTypeCode(String EquipmentTypeCode) {
                this.EquipmentTypeCode = EquipmentTypeCode;
            }

            public String getEquipmentTypeName() {
                return EquipmentTypeName;
            }

            public void setEquipmentTypeName(String EquipmentTypeName) {
                this.EquipmentTypeName = EquipmentTypeName;
            }

            public String getPosition() {
                return Position;
            }

            public void setPosition(String Position) {
                this.Position = Position;
            }

            public Object getSceneDescription() {
                return SceneDescription;
            }

            public void setSceneDescription(Object SceneDescription) {
                this.SceneDescription = SceneDescription;
            }

            public Object getProcessingMode() {
                return ProcessingMode;
            }

            public void setProcessingMode(Object ProcessingMode) {
                this.ProcessingMode = ProcessingMode;
            }

            public String getRemark() {
                return Remark;
            }

            public void setRemark(String Remark) {
                this.Remark = Remark;
            }
        }

        public static class HistoryListBean {
            /**
             * TicketsCode : CM234-20180817-0078
             * ActionTypeName : 新建工单
             * Remark : null
             * Creator : jimmy
             * CreateDate : 2018/8/17 19:35:55
             * HistoryAttachments : []
             */

            private String TicketsCode;
            private String ActionTypeName;
            private Object Remark;
            private String Creator;
            private String CreateDate;
            private List<?> HistoryAttachments;

            public String getTicketsCode() {
                return TicketsCode;
            }

            public void setTicketsCode(String TicketsCode) {
                this.TicketsCode = TicketsCode;
            }

            public String getActionTypeName() {
                return ActionTypeName;
            }

            public void setActionTypeName(String ActionTypeName) {
                this.ActionTypeName = ActionTypeName;
            }

            public Object getRemark() {
                return Remark;
            }

            public void setRemark(Object Remark) {
                this.Remark = Remark;
            }

            public String getCreator() {
                return Creator;
            }

            public void setCreator(String Creator) {
                this.Creator = Creator;
            }

            public String getCreateDate() {
                return CreateDate;
            }

            public void setCreateDate(String CreateDate) {
                this.CreateDate = CreateDate;
            }

            public List<?> getHistoryAttachments() {
                return HistoryAttachments;
            }

            public void setHistoryAttachments(List<?> HistoryAttachments) {
                this.HistoryAttachments = HistoryAttachments;
            }
        }
    }
}
