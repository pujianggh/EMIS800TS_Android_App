package com.android.ts.emis.mode;

import com.libcommon.action.mode.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author pujiang
 * @date 2018/8/15 16:49
 * @mail 515210530@qq.com
 * @Description:
 */
public class UserInfoBean extends BaseBean implements Serializable{


    /**
     * data : {"UserCode":"cloud","UserName":"cloud","UserLevel":"Level1","UserMobile":"18616888666","UserTel":null,"Email":"cloud@cloud.com","UserType":"2","UserTypeName":"物业经理","IsAdmin":0,"HouseList":[{"RuleCode":"334","HouseCode":"3d99d0eb-ef31-4a62-9356-464dd2bf89f0","HouseName":"leo house","City":"上海市","Province":"上海","HouseDescriptionImage":null},{"RuleCode":"tom","HouseCode":"44bbf168-b7fb-4298-a2ad-2c8e45000915","HouseName":"TomHouse","City":"西安市","Province":"陕西省","HouseDescriptionImage":null},{"RuleCode":"100","HouseCode":"8a05baa2-3c1d-4dda-bf9d-bdae06ca29de","HouseName":"WayHouse","City":"上海市","Province":"上海","HouseDescriptionImage":null}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * UserCode : cloud
         * UserName : cloud
         * UserLevel : Level1
         * UserMobile : 18616888666
         * UserTel : null
         * Email : cloud@cloud.com
         * UserType : 2
         * UserTypeName : 物业经理
         * IsAdmin : 0
         * HouseList : [{"RuleCode":"334","HouseCode":"3d99d0eb-ef31-4a62-9356-464dd2bf89f0","HouseName":"leo house","City":"上海市","Province":"上海","HouseDescriptionImage":null},{"RuleCode":"tom","HouseCode":"44bbf168-b7fb-4298-a2ad-2c8e45000915","HouseName":"TomHouse","City":"西安市","Province":"陕西省","HouseDescriptionImage":null},{"RuleCode":"100","HouseCode":"8a05baa2-3c1d-4dda-bf9d-bdae06ca29de","HouseName":"WayHouse","City":"上海市","Province":"上海","HouseDescriptionImage":null}]
         */

        private String UserCode;
        private String UserName;
        private String UserLevel;
        private String UserMobile;
        private Object UserTel;
        private String Email;
        private String UserType;
        private String UserTypeName;
        private int IsAdmin;
        private List<HouseListBean> HouseList;

        public String getUserCode() {
            return UserCode;
        }

        public void setUserCode(String UserCode) {
            this.UserCode = UserCode;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getUserLevel() {
            return UserLevel;
        }

        public void setUserLevel(String UserLevel) {
            this.UserLevel = UserLevel;
        }

        public String getUserMobile() {
            return UserMobile;
        }

        public void setUserMobile(String UserMobile) {
            this.UserMobile = UserMobile;
        }

        public Object getUserTel() {
            return UserTel;
        }

        public void setUserTel(Object UserTel) {
            this.UserTel = UserTel;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public String getUserType() {
            return UserType;
        }

        public void setUserType(String UserType) {
            this.UserType = UserType;
        }

        public String getUserTypeName() {
            return UserTypeName;
        }

        public void setUserTypeName(String UserTypeName) {
            this.UserTypeName = UserTypeName;
        }

        public int getIsAdmin() {
            return IsAdmin;
        }

        public void setIsAdmin(int IsAdmin) {
            this.IsAdmin = IsAdmin;
        }

        public List<HouseListBean> getHouseList() {
            return HouseList;
        }

        public void setHouseList(List<HouseListBean> HouseList) {
            this.HouseList = HouseList;
        }
    }
}
