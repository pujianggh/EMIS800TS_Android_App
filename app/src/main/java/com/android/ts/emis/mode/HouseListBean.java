package com.android.ts.emis.mode;

import java.io.Serializable;

/**
 * @author pujiang
 * @date 2018/8/15 16:58
 * @mail 515210530@qq.com
 * @Description:
 */
public class HouseListBean implements Serializable {
    /**
     * RuleCode : 334
     * HouseCode : 3d99d0eb-ef31-4a62-9356-464dd2bf89f0
     * HouseName : leo house
     * City : 上海市
     * Province : 上海
     * HouseDescriptionImage : null
     */

    private String RuleCode;
    private String HouseCode;
    private String HouseName;
    private String City;
    private String Province;
    private String HouseDescriptionImage;
    private int UnreadCount;

    public String getRuleCode() {
        return RuleCode;
    }

    public void setRuleCode(String ruleCode) {
        RuleCode = ruleCode;
    }

    public String getHouseCode() {
        return HouseCode;
    }

    public void setHouseCode(String houseCode) {
        HouseCode = houseCode;
    }

    public String getHouseName() {
        return HouseName;
    }

    public void setHouseName(String houseName) {
        HouseName = houseName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getHouseDescriptionImage() {
        return HouseDescriptionImage;
    }

    public void setHouseDescriptionImage(String houseDescriptionImage) {
        HouseDescriptionImage = houseDescriptionImage;
    }

    public int getUnreadCount() {
        return UnreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        UnreadCount = unreadCount;
    }
}
