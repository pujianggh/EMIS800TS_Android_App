package com.android.ts.emis.config;

import com.android.ts.emis.mode.SelectInfoBean;
import com.android.ts.emis.mode.StateInfoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单、位置、类型模拟数据
 *
 * @author pujiang
 * @date 2018-5-16 13:06
 * @mail 515210530@qq.com
 * @Description:
 */
public class DataStateQueryCenter {

    /**
     * 模拟优先级型数据
     */
    public static StateInfoBean getYXJModuleData() {
        StateInfoBean dataBean = new StateInfoBean();
        List<StateInfoBean.Data> list = new ArrayList<>();

        StateInfoBean.Data data = new StateInfoBean.Data();
        data.setName("V紧急");
        StateInfoBean.Data data1 = new StateInfoBean.Data();
        data1.setName("1普通");
        StateInfoBean.Data data2 = new StateInfoBean.Data();
        data2.setName("2紧急关键");
        StateInfoBean.Data data3 = new StateInfoBean.Data();
        data3.setName("3紧急重大");
        StateInfoBean.Data data4 = new StateInfoBean.Data();
        data4.setName("客户报修");

        list.add(data);
        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data4);
        dataBean.setData(list);
        return dataBean;
    }

    /**
     * 模拟保修内容数据
     */
    public static StateInfoBean getBXNRModuleData() {
        StateInfoBean dataBean = new StateInfoBean();
        List<StateInfoBean.Data> list = new ArrayList<>();

        StateInfoBean.Data data = new StateInfoBean.Data();
        data.setName("ATM机");
        StateInfoBean.Data data1 = new StateInfoBean.Data();
        data1.setName("POS机");
        StateInfoBean.Data data2 = new StateInfoBean.Data();
        data2.setName("扫描仪");
        StateInfoBean.Data data3 = new StateInfoBean.Data();
        data3.setName("自助取票机");

        list.add(data);
        list.add(data1);
        list.add(data2);
        list.add(data3);
        dataBean.setData(list);
        return dataBean;
    }

    /**
     * 模拟服务类型数据
     */
    public static StateInfoBean getFWLXModuleData() {
        StateInfoBean dataBean = new StateInfoBean();
        List<StateInfoBean.Data> list = new ArrayList<>();

        StateInfoBean.Data data = new StateInfoBean.Data();
        data.setName("服务请求工单");
        List<StateInfoBean.Data> dataList = new ArrayList<>();
        StateInfoBean.Data data_1 = new StateInfoBean.Data();
        data_1.setName("维修工单");
        StateInfoBean.Data data_2 = new StateInfoBean.Data();
        data_2.setName("保安保洁");
        dataList.add(data_1);
        dataList.add(data_2);
        data.setData(dataList);

        StateInfoBean.Data data1 = new StateInfoBean.Data();
        data1.setName("test");
        StateInfoBean.Data data2 = new StateInfoBean.Data();
        data2.setName("服务类型");
        StateInfoBean.Data data3 = new StateInfoBean.Data();
        data3.setName("表扬");
        StateInfoBean.Data data4 = new StateInfoBean.Data();
        data4.setName("巡检类型");
        StateInfoBean.Data data5 = new StateInfoBean.Data();
        data5.setName("员工投诉/建议工单");
        StateInfoBean.Data data6 = new StateInfoBean.Data();
        data6.setName("员工表扬");

        list.add(data);
        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data4);
        list.add(data5);
        list.add(data6);
        dataBean.setData(list);
        return dataBean;
    }

    /**
     * 模拟工单类型数据
     */
    public static StateInfoBean getGDLXModuleData() {
        StateInfoBean dataBean = new StateInfoBean();
        List<StateInfoBean.Data> list = new ArrayList<>();

        StateInfoBean.Data data = new StateInfoBean.Data();
        data.setName("维修工单");
        StateInfoBean.Data data1 = new StateInfoBean.Data();
        data1.setName("保洁工单");
        StateInfoBean.Data data2 = new StateInfoBean.Data();
        data2.setName("保安工单");
        StateInfoBean.Data data3 = new StateInfoBean.Data();
        data3.setName("投诉工单");
        list.add(data);
        list.add(data1);
        list.add(data2);
        list.add(data3);
        dataBean.setData(list);
        return dataBean;
    }


    /**
     * 模拟部门数据
     */
    public static StateInfoBean getBMModuleData() {
        StateInfoBean dataBean = new StateInfoBean();
        List<StateInfoBean.Data> list = new ArrayList<>();

        StateInfoBean.Data data = new StateInfoBean.Data();
        data.setName("工程部");
        StateInfoBean.Data data1 = new StateInfoBean.Data();
        data1.setName("客服部");
        StateInfoBean.Data data2 = new StateInfoBean.Data();
        data2.setName("保安部");
        StateInfoBean.Data data3 = new StateInfoBean.Data();
        data3.setName("保洁部");

        list.add(data);
        list.add(data1);
        list.add(data2);
        list.add(data3);
        dataBean.setData(list);
        return dataBean;
    }

    /**
     * 模拟位置演示数据
     */
    public static StateInfoBean getWZTestModuleData() {
        StateInfoBean dataBean = new StateInfoBean();
        List<StateInfoBean.Data> list = new ArrayList<>();

        StateInfoBean.Data data = new StateInfoBean.Data();
        data.setName("東京都新宿区新宿1-8-1");
        StateInfoBean.Data data1 = new StateInfoBean.Data();
        data1.setName("東京都新宿区新宿1-8-2");
        StateInfoBean.Data data2 = new StateInfoBean.Data();
        data2.setName("東京都新宿区新宿1-8-3");
        StateInfoBean.Data data3 = new StateInfoBean.Data();
        data3.setName("東京都新宿区新宿1-8-4");
        StateInfoBean.Data data4 = new StateInfoBean.Data();
        data4.setName("東京都新宿区新宿1-8-5");
        StateInfoBean.Data data5 = new StateInfoBean.Data();
        data5.setName("東京都新宿区新宿1-8-10");

        list.add(data);
        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data4);
        list.add(data5);
        dataBean.setData(list);
        return dataBean;
    }

    /**
     * 派工人员
     */
    public static SelectInfoBean getPGRYModuleData() {
        SelectInfoBean dataBean = new SelectInfoBean();
        List<SelectInfoBean.Data> list = new ArrayList<>();

        SelectInfoBean.Data data = new SelectInfoBean.Data();
        data.setName("张工");
        SelectInfoBean.Data data1 = new SelectInfoBean.Data();
        data1.setName("李工");
        SelectInfoBean.Data data2 = new SelectInfoBean.Data();
        data2.setName("王工");

        list.add(data);
        list.add(data1);
        list.add(data2);
        dataBean.setData(list);
        return dataBean;
    }

    /**
     * 派工人员
     */
    public static SelectInfoBean getPGRYModuleData2() {
        SelectInfoBean dataBean = new SelectInfoBean();
        List<SelectInfoBean.Data> list = new ArrayList<>();

        SelectInfoBean.Data data = new SelectInfoBean.Data();
        data.setName("北村さん");
        SelectInfoBean.Data data1 = new SelectInfoBean.Data();
        data1.setName("篠原さん");
        SelectInfoBean.Data data2 = new SelectInfoBean.Data();
        data2.setName("佐藤さん");

        list.add(data);
        list.add(data1);
        list.add(data2);
        dataBean.setData(list);
        return dataBean;
    }

    /**
     * 模拟位置数据
     */
    public static StateInfoBean getWZModuleData() {
        StateInfoBean dataBean = new StateInfoBean();
        List<StateInfoBean.Data> list = new ArrayList<>();

        StateInfoBean.Data data = new StateInfoBean.Data();
        data.setName("国际公寓1");
        List<StateInfoBean.Data> dataList = new ArrayList<>();
        StateInfoBean.Data data_1 = new StateInfoBean.Data();
        data_1.setName("1楼");
        StateInfoBean.Data data_2 = new StateInfoBean.Data();
        data_2.setName("3楼");
        List<StateInfoBean.Data> dataList_1 = new ArrayList<>();
        StateInfoBean.Data data_1_1 = new StateInfoBean.Data();
        data_1_1.setName("卫生间");
        dataList_1.add(data_1_1);
        data_2.setData(dataList_1);
        dataList.add(data_1);
        dataList.add(data_2);
        data.setData(dataList);

        StateInfoBean.Data data1 = new StateInfoBean.Data();
        data1.setName("商贸广场南楼");

        StateInfoBean.Data data2 = new StateInfoBean.Data();
        data2.setName("苏悦广场");
        List<StateInfoBean.Data> dataList2 = new ArrayList<>();
        StateInfoBean.Data data_11 = new StateInfoBean.Data();
        data_11.setName("大润发超市");
        StateInfoBean.Data data_21 = new StateInfoBean.Data();
        data_21.setName("重庆火锅店");
        StateInfoBean.Data data_31 = new StateInfoBean.Data();
        data_31.setName("百货商场门口");
        dataList2.add(data_11);
        dataList2.add(data_21);
        dataList2.add(data_31);
        data.setData(dataList);

        StateInfoBean.Data data3 = new StateInfoBean.Data();
        data3.setName("公共区域");
        StateInfoBean.Data data4 = new StateInfoBean.Data();
        data4.setName("22号楼");
        StateInfoBean.Data data5 = new StateInfoBean.Data();
        data5.setName("国际公寓-物业中心");
        StateInfoBean.Data data6 = new StateInfoBean.Data();
        data6.setName("欢乐颂");

        StateInfoBean.Data data7 = new StateInfoBean.Data();
        data7.setName("天朗大新二期");
        List<StateInfoBean.Data> dataList7 = new ArrayList<>();
        StateInfoBean.Data data_71 = new StateInfoBean.Data();
        data_71.setName("59栋");
        StateInfoBean.Data data_72 = new StateInfoBean.Data();
        data_72.setName("物业中心");
        StateInfoBean.Data data_73 = new StateInfoBean.Data();
        data_73.setName("南大门口");
        dataList7.add(data_71);
        dataList7.add(data_72);
        dataList7.add(data_73);
        data.setData(dataList);

        StateInfoBean.Data data8 = new StateInfoBean.Data();
        data8.setName("实际锦绣");
        StateInfoBean.Data data9 = new StateInfoBean.Data();
        data9.setName("554南楼");

        list.add(data);
        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data4);
        list.add(data5);
        list.add(data6);
        list.add(data7);
        list.add(data8);
        list.add(data9);
        dataBean.setData(list);
        return dataBean;
    }

    /**
     * 模拟设备数据
     */
    public static StateInfoBean getDeviceModuleData() {
        StateInfoBean dataBean = new StateInfoBean();
        List<StateInfoBean.Data> list = new ArrayList<>();

        StateInfoBean.Data data = new StateInfoBean.Data();
        data.setName("设备1");
        data.setCode("ACS-01F-N01-060");
        data.setAddress("天朗大新二期");
        StateInfoBean.Data data1 = new StateInfoBean.Data();
        data1.setName("读卡器");
        data1.setCode("TS-01F-N01-283");
        data1.setAddress("国际公寓1");
        StateInfoBean.Data data2 = new StateInfoBean.Data();
        data2.setName("控制器");
        data2.setCode("TS-01F-N01-223");
        data2.setAddress("59栋");
        StateInfoBean.Data data3 = new StateInfoBean.Data();
        data3.setName("可是对话机");
        data3.setCode("TS-01F-N01-233");
        data3.setAddress("实际锦绣");
        StateInfoBean.Data data4 = new StateInfoBean.Data();
        data4.setName("紧急按钮");
        data4.setCode("TS-01F-N01-123");
        data4.setAddress("公共区域");
        StateInfoBean.Data data5 = new StateInfoBean.Data();
        data5.setName("设备2");
        data5.setCode("ACS-01F-N01-060");
        data5.setAddress("天朗大新二期1");
        StateInfoBean.Data data6 = new StateInfoBean.Data();
        data6.setName("设备4");
        data6.setCode("ACS-01F-N01-060");
        data6.setAddress("天朗大新二期2");
        StateInfoBean.Data data7 = new StateInfoBean.Data();
        data7.setName("设备13");
        data7.setCode("ACS-01F-N01-061");
        data7.setAddress("天朗大新二期3");
        StateInfoBean.Data data8 = new StateInfoBean.Data();
        data8.setName("设备10");
        data8.setCode("ACS-01F-N01-062");
        data8.setAddress("天朗大新二期4");
        StateInfoBean.Data data9 = new StateInfoBean.Data();
        data9.setName("设备34");
        data9.setCode("ACS-01F-N01-063");
        data9.setAddress("天朗大新二期5");
        StateInfoBean.Data data10 = new StateInfoBean.Data();
        data10.setName("设备55");
        data10.setCode("ACS-01F-N01-064");
        data10.setAddress("天朗大新二期6");
        StateInfoBean.Data data11 = new StateInfoBean.Data();
        data11.setName("设备09");
        data11.setCode("ACS-01F-N01-065");
        data11.setAddress("天朗大新二期7");

        list.add(data);
        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data4);
        list.add(data5);
        list.add(data6);
        list.add(data7);
        list.add(data8);
        list.add(data9);
        list.add(data10);
        list.add(data11);
        dataBean.setData(list);
        return dataBean;
    }
}
