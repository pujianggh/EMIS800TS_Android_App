package com.android.ts.emis.mode;

import com.libcommon.action.mode.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 资产管理
 *
 * @author pujiang
 * @date 2018-4-4 14:31
 * @mail 515210530@qq.com
 * @Description:
 */
public class PropertyManageBean extends BaseBean implements Serializable {
    private int Total;
    private List<Data> Data;

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public List<PropertyManageBean.Data> getData() {
        return Data;
    }

    public void setData(List<PropertyManageBean.Data> data) {
        Data = data;
    }

    public static class Data implements Serializable {
        private String id;
        private String message;
        private String systemClass;
        private String instalLosition;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getSystemClass() {
            return systemClass;
        }

        public void setSystemClass(String systemClass) {
            this.systemClass = systemClass;
        }

        public String getInstalLosition() {
            return instalLosition;
        }

        public void setInstalLosition(String instalLosition) {
            this.instalLosition = instalLosition;
        }
    }
}
