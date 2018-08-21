package com.android.ts.emis.mode;

import com.libcommon.action.mode.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 维修详情步骤列表
 *
 * @author pujiang
 * @date 2018-4-4 14:31
 * @mail 515210530@qq.com
 * @Description:
 */
public class PlanMaintainDetailStepBean extends BaseBean implements Serializable {
    private int Total;
    private List<Data> Data;

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public List<PlanMaintainDetailStepBean.Data> getData() {
        return Data;
    }

    public void setData(List<PlanMaintainDetailStepBean.Data> data) {
        Data = data;
    }

    public static class Data implements Serializable {
        private String id;
        private String workGroupName;
        private String planContent;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getWorkGroupName() {
            return workGroupName;
        }

        public void setWorkGroupName(String workGroupName) {
            this.workGroupName = workGroupName;
        }

        public String getPlanContent() {
            return planContent;
        }

        public void setPlanContent(String planContent) {
            this.planContent = planContent;
        }
    }
}
