package com.android.ts.emis.mode;

import com.libcommon.action.mode.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 巡检列表（根据不同类型）
 *
 * @author pujiang
 * @date 2018-4-4 14:31
 * @mail 515210530@qq.com
 * @Description:
 */
public class PollingInfoListBean extends BaseBean implements Serializable {
    private int Total;
    private List<Data> Data;

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public List<PollingInfoListBean.Data> getData() {
        return Data;
    }

    public void setData(List<PollingInfoListBean.Data> data) {
        Data = data;
    }

    public static class Data implements Serializable {
        private String id;
        private String pollName;
        private String pollPersonnel;
        private String pollStartTime;
        private String pollEndTime;
        private String polLocation;//
        private String location;//
        private String pollStatus;
        private String pollDevice;

        public String getPolLocation() {
            return polLocation;
        }

        public void setPolLocation(String polLocation) {
            this.polLocation = polLocation;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPollName() {
            return pollName;
        }

        public void setPollName(String pollName) {
            this.pollName = pollName;
        }

        public String getPollPersonnel() {
            return pollPersonnel;
        }

        public void setPollPersonnel(String pollPersonnel) {
            this.pollPersonnel = pollPersonnel;
        }

        public String getPollStartTime() {
            return pollStartTime;
        }

        public void setPollStartTime(String pollStartTime) {
            this.pollStartTime = pollStartTime;
        }

        public String getPollEndTime() {
            return pollEndTime;
        }

        public void setPollEndTime(String pollEndTime) {
            this.pollEndTime = pollEndTime;
        }

        public String getPollocation() {
            return polLocation;
        }

        public void setPollocation(String polLocation) {
            this.polLocation = polLocation;
        }

        public String getPollStatus() {
            return pollStatus;
        }

        public void setPollStatus(String pollStatus) {
            this.pollStatus = pollStatus;
        }

        public String getPollDevice() {
            return pollDevice;
        }

        public void setPollDevice(String pollDevice) {
            this.pollDevice = pollDevice;
        }
    }
}
