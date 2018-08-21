package com.android.ts.emis.mode;

import com.libcommon.action.mode.BaseBean;

import java.util.List;

/**
 * @author pujiang
 * @date 2018/8/16 15:19
 * @mail 515210530@qq.com
 * @Description:
 */
public class MaintenancePlanInfoBean extends BaseBean {

    /**
     * data : {"ExecutorList":[{"ExecutorCode":"ET_PROPERTY_20170619153506","ExecutorName":"董宁","Telephone":"13564639789","WorkGroupID":152,"IsDirector":0},{"ExecutorCode":"ET_SUPPLIER_20170615164502","ExecutorName":"中建八局","Telephone":"18626096310","WorkGroupID":152,"IsDirector":1}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<ExecutorListBean> ExecutorList;

        public List<ExecutorListBean> getExecutorList() {
            return ExecutorList;
        }

        public void setExecutorList(List<ExecutorListBean> ExecutorList) {
            this.ExecutorList = ExecutorList;
        }

        public static class ExecutorListBean {
            /**
             * ExecutorCode : ET_PROPERTY_20170619153506
             * ExecutorName : 董宁
             * Telephone : 13564639789
             * WorkGroupID : 152
             * IsDirector : 0
             */

            private String ExecutorCode;
            private String ExecutorName;
            private String Telephone;
            private int WorkGroupID;
            private int IsDirector;

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

            public String getTelephone() {
                return Telephone;
            }

            public void setTelephone(String Telephone) {
                this.Telephone = Telephone;
            }

            public int getWorkGroupID() {
                return WorkGroupID;
            }

            public void setWorkGroupID(int WorkGroupID) {
                this.WorkGroupID = WorkGroupID;
            }

            public int getIsDirector() {
                return IsDirector;
            }

            public void setIsDirector(int IsDirector) {
                this.IsDirector = IsDirector;
            }
        }
    }
}
