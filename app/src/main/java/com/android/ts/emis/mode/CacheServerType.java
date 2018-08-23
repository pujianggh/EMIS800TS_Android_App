package com.android.ts.emis.mode;

import com.libcommon.action.mode.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author pujiang
 * @date 2018/8/23 15:28
 * @mail 515210530@qq.com
 * @Description:
 */
public class CacheServerType extends BaseBean implements Serializable {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * HouseCode : 0a6f5908-6d6e-41de-b138-d5e68966b572
         * TicketsType : [{"TicketsTypeCode":"20180515161148843500","TicketsTypeName":"维修","ParentID":"0","SequenceNumber":1,"BUCode":"4e6417c2-2520-4f9d-885c-f47006b66010","BUName":"售后部","Children":[{"TicketsTypeCode":"20180515161252287333","TicketsTypeName":"维修电器","ParentID":"20180515161148843500","SequenceNumber":1,"BUCode":"4e6417c2-2520-4f9d-885c-f47006b66010","BUName":"售后部","Children":[]},{"TicketsTypeCode":"20180515161304173653","TicketsTypeName":"维修手机","ParentID":"20180515161148843500","SequenceNumber":2,"BUCode":"4e6417c2-2520-4f9d-885c-f47006b66010","BUName":"售后部","Children":[]}]}]
         */

        private String HouseCode;
        private List<TicketsTypeBean> TicketsType;

        public String getHouseCode() {
            return HouseCode;
        }

        public void setHouseCode(String HouseCode) {
            this.HouseCode = HouseCode;
        }

        public List<TicketsTypeBean> getTicketsType() {
            return TicketsType;
        }

        public void setTicketsType(List<TicketsTypeBean> TicketsType) {
            this.TicketsType = TicketsType;
        }

        public static class TicketsTypeBean {
            /**
             * TicketsTypeCode : 20180515161148843500
             * TicketsTypeName : 维修
             * ParentID : 0
             * SequenceNumber : 1
             * BUCode : 4e6417c2-2520-4f9d-885c-f47006b66010
             * BUName : 售后部
             * Children : [{"TicketsTypeCode":"20180515161252287333","TicketsTypeName":"维修电器","ParentID":"20180515161148843500","SequenceNumber":1,"BUCode":"4e6417c2-2520-4f9d-885c-f47006b66010","BUName":"售后部","Children":[]},{"TicketsTypeCode":"20180515161304173653","TicketsTypeName":"维修手机","ParentID":"20180515161148843500","SequenceNumber":2,"BUCode":"4e6417c2-2520-4f9d-885c-f47006b66010","BUName":"售后部","Children":[]}]
             */

            private String TicketsTypeCode;
            private String TicketsTypeName;
            private String ParentID;
            private int SequenceNumber;
            private String BUCode;
            private String BUName;
            private List<TicketsTypeBean> Children;

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

            public String getParentID() {
                return ParentID;
            }

            public void setParentID(String ParentID) {
                this.ParentID = ParentID;
            }

            public int getSequenceNumber() {
                return SequenceNumber;
            }

            public void setSequenceNumber(int SequenceNumber) {
                this.SequenceNumber = SequenceNumber;
            }

            public String getBUCode() {
                return BUCode;
            }

            public void setBUCode(String BUCode) {
                this.BUCode = BUCode;
            }

            public String getBUName() {
                return BUName;
            }

            public void setBUName(String BUName) {
                this.BUName = BUName;
            }

            public List<TicketsTypeBean> getChildren() {
                return Children;
            }

            public void setChildren(List<TicketsTypeBean> Children) {
                this.Children = Children;
            }
        }
    }
}
