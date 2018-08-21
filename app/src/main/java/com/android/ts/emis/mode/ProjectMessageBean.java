package com.android.ts.emis.mode;

import com.libcommon.action.mode.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 消息选择信息
 *
 * @author pujiang
 * @date 2018-4-4 14:31
 * @mail 515210530@qq.com
 * @Description:
 */
public class ProjectMessageBean extends BaseBean implements Serializable {
    private int Total;
    private List<Data> Data;

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public List<ProjectMessageBean.Data> getData() {
        return Data;
    }

    public void setData(List<ProjectMessageBean.Data> data) {
        Data = data;
    }

    public static class Data implements Serializable {
        private String name;
        private String province;
        private String city;
        private String area;
        private String imgeURL;
        private int msgCount;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getImgeURL() {
            return imgeURL;
        }

        public void setImgeURL(String imgeURL) {
            this.imgeURL = imgeURL;
        }

        public int getMsgCount() {
            return msgCount;
        }

        public void setMsgCount(int msgCount) {
            this.msgCount = msgCount;
        }
    }
}
