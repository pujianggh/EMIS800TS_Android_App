package com.android.ts.emis.mode;

import java.io.Serializable;

/**
 * 用户密码
 *
 * @author pujiang
 * @date 2018-6-8 22:59
 * @mail 515210530@qq.com
 * @Description:
 */
public class UserPasswordBean implements Serializable {

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
     */

    private String UserCode;
    private String UserName;
    private String UserLevel;
    private String UserMobile;
    private String UserTel;
    private String Email;
    private String UserType;
    private String UserTypeName;
    private int IsAdmin;

    private String HouseName;//楼盘名称
    private String HouseCode;//楼盘编号
    private String HousePhaseCode;//楼盘小区编号
    private String RuleCode;//楼盘编码

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

    public String getUserTel() {
        return UserTel;
    }

    public void setUserTel(String UserTel) {
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

    public String getHouseName() {
        return HouseName;
    }

    public void setHouseName(String houseName) {
        HouseName = houseName;
    }

    public String getHouseCode() {
        return HouseCode;
    }

    public void setHouseCode(String houseCode) {
        HouseCode = houseCode;
    }

    public String getRuleCode() {
        return RuleCode;
    }

    public void setRuleCode(String ruleCode) {
        RuleCode = ruleCode;
    }

    public String getHousePhaseCode() {
        return HousePhaseCode;
    }

    public void setHousePhaseCode(String housePhaseCode) {
        HousePhaseCode = housePhaseCode;
    }
}

