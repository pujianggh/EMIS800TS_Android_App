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

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * ExecutorCode : 1_20180423145910
         * ExecutorName : rachel-执行人
         * Telephone : 13245678900
         * WorkGroupID : 147
         * IsDirector : 1
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
