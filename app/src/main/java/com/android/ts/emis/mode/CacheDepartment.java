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
public class CacheDepartment extends BaseBean implements Serializable {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * DictionaryName : 中餐部
         * DictionaryValue : 0
         * DictionaryCode : BU_App_CF
         */

        private String DictionaryName;
        private String DictionaryValue;
        private String DictionaryCode;

        public String getDictionaryName() {
            return DictionaryName;
        }

        public void setDictionaryName(String DictionaryName) {
            this.DictionaryName = DictionaryName;
        }

        public String getDictionaryValue() {
            return DictionaryValue;
        }

        public void setDictionaryValue(String DictionaryValue) {
            this.DictionaryValue = DictionaryValue;
        }

        public String getDictionaryCode() {
            return DictionaryCode;
        }

        public void setDictionaryCode(String DictionaryCode) {
            this.DictionaryCode = DictionaryCode;
        }
    }
}
