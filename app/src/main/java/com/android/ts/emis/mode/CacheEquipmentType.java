package com.android.ts.emis.mode;

import com.libcommon.action.mode.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author pujiang
 * @date 2018/8/23 15:23
 * @mail 515210530@qq.com
 * @Description:
 */
public class CacheEquipmentType extends BaseBean implements Serializable {

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
         * EquipmentType : [{"EquipmentTypeCode":"6a0da770e5804bdcaf734852b51adbca","EquipmentTypeName":"电器","ParentID":"0","SequenceNumber":10,"EquipmentTypeSeriesNumber":"","Children":[{"EquipmentTypeCode":"8f7fa032977c492f964456d53f80ad86","EquipmentTypeName":"电视","ParentID":"6a0da770e5804bdcaf734852b51adbca","SequenceNumber":2,"EquipmentTypeSeriesNumber":"ds","Children":[]},{"EquipmentTypeCode":"af71da7d80544632bb59c51e801b5fbc","EquipmentTypeName":"洗衣机\\","ParentID":"6a0da770e5804bdcaf734852b51adbca","SequenceNumber":100,"EquipmentTypeSeriesNumber":"","Children":[]}]}]
         */

        private String HouseCode;
        private List<EquipmentTypeBean> EquipmentType;

        public String getHouseCode() {
            return HouseCode;
        }

        public void setHouseCode(String HouseCode) {
            this.HouseCode = HouseCode;
        }

        public List<EquipmentTypeBean> getEquipmentType() {
            return EquipmentType;
        }

        public void setEquipmentType(List<EquipmentTypeBean> EquipmentType) {
            this.EquipmentType = EquipmentType;
        }

        public static class EquipmentTypeBean {
            /**
             * EquipmentTypeCode : 6a0da770e5804bdcaf734852b51adbca
             * EquipmentTypeName : 电器
             * ParentID : 0
             * SequenceNumber : 10
             * EquipmentTypeSeriesNumber :
             * Children : [{"EquipmentTypeCode":"8f7fa032977c492f964456d53f80ad86","EquipmentTypeName":"电视","ParentID":"6a0da770e5804bdcaf734852b51adbca","SequenceNumber":2,"EquipmentTypeSeriesNumber":"ds","Children":[]},{"EquipmentTypeCode":"af71da7d80544632bb59c51e801b5fbc","EquipmentTypeName":"洗衣机\\","ParentID":"6a0da770e5804bdcaf734852b51adbca","SequenceNumber":100,"EquipmentTypeSeriesNumber":"","Children":[]}]
             */

            private String EquipmentTypeCode;
            private String EquipmentTypeName;
            private String ParentID;
            private int SequenceNumber;
            private String EquipmentTypeSeriesNumber;
            private List<EquipmentTypeBean> Children;

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

            public String getEquipmentTypeSeriesNumber() {
                return EquipmentTypeSeriesNumber;
            }

            public void setEquipmentTypeSeriesNumber(String EquipmentTypeSeriesNumber) {
                this.EquipmentTypeSeriesNumber = EquipmentTypeSeriesNumber;
            }

            public List<EquipmentTypeBean> getChildren() {
                return Children;
            }

            public void setChildren(List<EquipmentTypeBean> Children) {
                this.Children = Children;
            }
        }
    }
}
