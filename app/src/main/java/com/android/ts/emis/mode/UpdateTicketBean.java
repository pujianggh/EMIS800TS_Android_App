package com.android.ts.emis.mode;

import com.libcommon.action.mode.BaseBean;

/**
 * @author pujiang
 * @date 2018/8/21 13:46
 * @mail 515210530@qq.com
 * @Description:
 */
public class UpdateTicketBean extends BaseBean {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * TicketsGroupCode : TM-CM234-20180709-0069
         * TicketsCode : CM234-20180709-0072
         */

        private String TicketsGroupCode;
        private String TicketsCode;

        public String getTicketsGroupCode() {
            return TicketsGroupCode;
        }

        public void setTicketsGroupCode(String TicketsGroupCode) {
            this.TicketsGroupCode = TicketsGroupCode;
        }

        public String getTicketsCode() {
            return TicketsCode;
        }

        public void setTicketsCode(String TicketsCode) {
            this.TicketsCode = TicketsCode;
        }
    }
}
