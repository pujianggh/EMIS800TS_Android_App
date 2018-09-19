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
public class CacheLocation extends BaseBean implements Serializable {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * HouseCode : 0a6f5908-6d6e-41de-b138-d5e68966b572
         * Estate : [{"Name":"苏悦广场553北楼-物业中心","EstateCode":null,"EstateAddress":null,"HouseUnit":null,"HouseFloor":null,"HouseRoom":null,"BuildingAddress":null,"Province":null,"City":null,"Zip":null,"Children":[{"Name":"1","EstateCode":null,"EstateAddress":null,"HouseUnit":null,"HouseFloor":null,"HouseRoom":null,"BuildingAddress":null,"Province":null,"City":null,"Zip":null,"Children":[{"Name":"电梯间","EstateCode":"263b2195-18e6-4022-b14a-6494f7216d6c","EstateAddress":"Tishman(测试)苏悦广场553北楼-物业中心单元1层电梯间室","HouseUnit":"苏悦广场553北楼-物业中心","HouseFloor":"1","HouseRoom":"电梯间","BuildingAddress":"工业园区苏州大道118-119号苏悦广场","Province":"江苏省","City":"苏州市","Zip":"215021","Children":[]}]}]}]
         */

        private String HouseCode;
        private List<EstateBean> Estate;

        public String getHouseCode() {
            return HouseCode;
        }

        public void setHouseCode(String HouseCode) {
            this.HouseCode = HouseCode;
        }

        public List<EstateBean> getEstate() {
            return Estate;
        }

        public void setEstate(List<EstateBean> Estate) {
            this.Estate = Estate;
        }

        public static class EstateBean {

            /**
             * Name : 电梯间
             * EstateCode : 263b2195-18e6-4022-b14a-6494f7216d6c
             * EstateAddress : Tishman(测试)苏悦广场553北楼-物业中心单元1层电梯间室
             * HouseUnit : 苏悦广场553北楼-物业中心
             * HouseFloor : 1
             * HouseRoom : 电梯间
             * BuildingAddress : 工业园区苏州大道118-119号苏悦广场
             * Province : 江苏省
             * City : 苏州市
             * Zip : 215021
             * Children : []
             */

            private String Name;
            private String EstateCode;
            private String EstateAddress;
            private String HouseUnit;
            private String HouseFloor;
            private String HouseRoom;
            private String BuildingAddress;
            private String Province;
            private String City;
            private String Zip;
            private List<EstateBean> Children;

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getEstateCode() {
                return EstateCode;
            }

            public void setEstateCode(String EstateCode) {
                this.EstateCode = EstateCode;
            }

            public String getEstateAddress() {
                return EstateAddress;
            }

            public void setEstateAddress(String EstateAddress) {
                this.EstateAddress = EstateAddress;
            }

            public String getHouseUnit() {
                return HouseUnit;
            }

            public void setHouseUnit(String HouseUnit) {
                this.HouseUnit = HouseUnit;
            }

            public String getHouseFloor() {
                return HouseFloor;
            }

            public void setHouseFloor(String HouseFloor) {
                this.HouseFloor = HouseFloor;
            }

            public String getHouseRoom() {
                return HouseRoom;
            }

            public void setHouseRoom(String HouseRoom) {
                this.HouseRoom = HouseRoom;
            }

            public String getBuildingAddress() {
                return BuildingAddress;
            }

            public void setBuildingAddress(String BuildingAddress) {
                this.BuildingAddress = BuildingAddress;
            }

            public String getProvince() {
                return Province;
            }

            public void setProvince(String Province) {
                this.Province = Province;
            }

            public String getCity() {
                return City;
            }

            public void setCity(String City) {
                this.City = City;
            }

            public String getZip() {
                return Zip;
            }

            public void setZip(String Zip) {
                this.Zip = Zip;
            }

            public List<EstateBean> getChildren() {
                return Children;
            }

            public void setChildren(List<EstateBean> Children) {
                this.Children = Children;
            }
        }
    }
}
