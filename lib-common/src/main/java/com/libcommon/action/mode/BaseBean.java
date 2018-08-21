package com.libcommon.action.mode;

import java.io.Serializable;

/**
 * 基类，Bean
 *
 * @author pujiang
 * @date 2018/8/15 16:23
 * @mail 515210530@qq.com
 * @Description:
 */
public class BaseBean implements Serializable {
    private int code = 0;
    private String message;
    private String status;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
