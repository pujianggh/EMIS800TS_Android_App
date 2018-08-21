package com.android.ts.emis.mode;

import com.libcommon.action.mode.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 工作模块信息
 *
 * @author pujiang
 * @date 2018-4-4 14:31
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkModuleBean extends BaseBean implements Serializable {
    private String BannerImgUrl;
    private int OrderNum;
    private int OffOrderNum;
    private List<BodyBean> body;

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public String getBannerImgUrl() {
        return BannerImgUrl;
    }

    public void setBannerImgUrl(String bannerImgUrl) {
        BannerImgUrl = bannerImgUrl;
    }

    public int getOrderNum() {
        return OrderNum;
    }

    public void setOrderNum(int orderNum) {
        OrderNum = orderNum;
    }

    public int getOffOrderNum() {
        return OffOrderNum;
    }

    public void setOffOrderNum(int offOrderNum) {
        OffOrderNum = offOrderNum;
    }

    public static class BodyBean {
        private String name;
        private String imageURL;
        private int workCode;
        private int count;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImageURL() {
            return imageURL;
        }

        public void setImageURL(String imageURL) {
            this.imageURL = imageURL;
        }

        public int getWorkCode() {
            return workCode;
        }

        public void setWorkCode(int workCode) {
            this.workCode = workCode;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
