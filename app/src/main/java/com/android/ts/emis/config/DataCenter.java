package com.android.ts.emis.config;

import com.android.ts.emis.mode.MessageInfoBean2;
import com.android.ts.emis.mode.PlanMaintainDetailStepBean;
import com.android.ts.emis.mode.PlanMaintainListBean;
import com.android.ts.emis.mode.PollingInfoListBean;
import com.android.ts.emis.mode.ProjectMessageBean;
import com.android.ts.emis.mode.PropertyManageBean;
import com.android.ts.emis.mode.StateInfoBean;
import com.android.ts.emis.mode.WorkModuleBean;
import com.android.ts.emis.mode.WorkOrderListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟数据
 *
 * @author pujiang
 * @date 2018-5-16 13:06
 * @mail 515210530@qq.com
 * @Description:
 */
public class DataCenter {

    /**
     * 获取维护列表
     */
    public static PlanMaintainListBean getPlanMaintainListModuleData() {
        List<PlanMaintainListBean.Data> list = new ArrayList<>();
        PlanMaintainListBean dataBean = new PlanMaintainListBean();
        dataBean.setTotal(10);

        PlanMaintainListBean.Data data;
        for (int i = 0; i < 15; i++) {
            data = new PlanMaintainListBean.Data();
            data.setId("" + i);
            data.setPollPersonnel("Rain.HAO");
            if (i < 2) {
                data.setPollName("便利店设备巡检(新)");
                data.setPollPersonnel("JIANG.PU");
                data.setPollStartTime("2018-05-28 13:00");
                data.setPollEndTime("2018-05-29 00:00");
                data.setPollStatus("1");
                data.setPollDevice("2");
                data.setLocation("商贸广场18南楼/2");
            } else if (i < 5) {
                data.setPollName("计划巡检测试(新)");
                data.setPollStartTime("2018-05-18 13:00");
                data.setPollEndTime("2018-05-19 00:00");
                data.setPollStatus("1");
                data.setPollDevice("2");
                data.setLocation("绿地商业广场");
            } else if (i < 9) {
                data.setPollName("便商场客服巡检(新)");
                data.setPollStartTime("2018-04-18 13:00");
                data.setPollEndTime("2018-04-19 00:00");
                data.setPollStatus("1");
                data.setPollDevice("2");
                data.setLocation("SOHO广场");
            } else if (i < 12) {
                data.setPollName("全家店面设备巡检(新)");
                data.setPollStartTime("2018-05-28 13:00");
                data.setPollEndTime("2018-05-29 00:00");
                data.setPollStatus("0");
                data.setPollDevice("1");
                data.setLocation("上海浦东大厦");
            } else {
                data.setPollName("楼道保洁巡检(新)");
                data.setPollPersonnel("JIANG.PU");
                data.setPollStartTime("2018-05-28 13:00");
                data.setPollEndTime("2018-05-29 00:00");
                data.setPollStatus("2");
                data.setPollDevice("0");
                data.setLocation("商贸广场99南楼/9");
            }
            list.add(data);
        }

        dataBean.setData(list);
        return dataBean;
    }

    /**
     * 获取巡检信息数据
     */
    public static PollingInfoListBean getPollingInfoListModuleData() {
        List<PollingInfoListBean.Data> list = new ArrayList<>();
        PollingInfoListBean dataBean = new PollingInfoListBean();
        dataBean.setTotal(10);

        PollingInfoListBean.Data data;
        for (int i = 0; i < 15; i++) {
            data = new PollingInfoListBean.Data();
            data.setId("" + i);
            data.setPollPersonnel("Rain.HAO");
            if (i < 2) {
                data.setPollName("便利店设备巡检(新)");
                data.setPollPersonnel("JIANG.PU");
                data.setPollStartTime("2018-05-28 13:00");
                data.setPollEndTime("2018-05-29 00:00");
                data.setPollocation("1个点位");
                data.setPollStatus("1");
                data.setPollDevice("2");
                data.setLocation("商贸广场18南楼/2");
            } else if (i < 5) {
                data.setPollName("计划巡检测试(新)");
                data.setPollStartTime("2018-05-18 13:00");
                data.setPollEndTime("2018-05-19 00:00");
                data.setPollocation("1个点位");
                data.setPollStatus("1");
                data.setPollDevice("2");
                data.setLocation("绿地商业广场");
            } else if (i < 9) {
                data.setPollName("便商场客服巡检(新)");
                data.setPollStartTime("2018-04-18 13:00");
                data.setPollEndTime("2018-04-19 00:00");
                data.setPollocation("1个点位");
                data.setPollStatus("1");
                data.setPollDevice("2");
                data.setLocation("SOHO广场");
            } else if (i < 12) {
                data.setPollName("全家店面设备巡检(新)");
                data.setPollStartTime("2018-05-28 13:00");
                data.setPollEndTime("2018-05-29 00:00");
                data.setPollocation("1个点位");
                data.setPollStatus("0");
                data.setPollDevice("1");
                data.setLocation("上海浦东大厦");
            } else {
                data.setPollName("楼道保洁巡检(新)");
                data.setPollPersonnel("JIANG.PU");
                data.setPollStartTime("2018-05-28 13:00");
                data.setPollEndTime("2018-05-29 00:00");
                data.setPollocation("2个点位");
                data.setPollStatus("2");
                data.setPollDevice("0");
                data.setLocation("商贸广场99南楼/9");
            }
            list.add(data);
        }

        dataBean.setData(list);
        return dataBean;
    }

    /**
     * 获取工单数据
     */
    public static WorkOrderListBean getWorkOrderListModuleData() {
        List<WorkOrderListBean.Data> list = new ArrayList<>();
        WorkOrderListBean dataBean = new WorkOrderListBean();
        dataBean.setTotal(30);

        WorkOrderListBean.Data data;
        for (int i = 0; i < 15; i++) {
            data = new WorkOrderListBean.Data();
            if (i < 2) {
                data.setCreateTime("2018-03-24 12:40");
                data.setOrderCode("CM0201803004" + i);
                data.setOrderDescribe("停电");
                data.setPfmCode("SZ001-20180328-161" + i);
                data.setOrderStatus("1普通");
                data.setState("" + i);
            } else if (i < 5) {
                data.setCreateTime("2018-01-20 8:40");
                data.setOrderCode("CM02018030234");
                data.setOrderDescribe("楼道漏水");
                data.setPfmCode("SZ001-20180422-1321");
                data.setOrderStatus("紧急处理");
                data.setState("0");
            } else if (i < 9) {
                data.setCreateTime("2018-03-28 17:40");
                data.setOrderCode("CM02018030345");
                data.setOrderDescribe("没有按规定处理");
                data.setPfmCode("SZ001-20180328-1618");
                data.setOrderStatus("1普通");
                data.setState("2");
            } else if (i < 12) {
                data.setCreateTime("2018-02-28 9:40");
                data.setOrderCode("CM02018030545");
                data.setOrderDescribe("地板有垃圾未处理");
                data.setPfmCode("SZ001-20180328-1618");
                data.setOrderStatus("比较急");
                data.setState("4");
            } else {
                data.setCreateTime("2018-03-28 16:40");
                data.setOrderCode("CM02018030623");
                data.setOrderDescribe("停电");
                data.setPfmCode("SZ001-20180328-1618");
                data.setOrderStatus("1普通");
                data.setState("3");
            }
            data.setId("10000" + i);
            list.add(data);
        }

        dataBean.setData(list);
        return dataBean;
    }


    /**
     * 获取工单数据
     */
    public static List<WorkOrderListBean.Data> getWorkOrderTestList() {
        List<WorkOrderListBean.Data> list = new ArrayList<>();

        WorkOrderListBean.Data data;
        for (int i = 0; i < 20; i++) {
            data = new WorkOrderListBean.Data();

            data.setType(1);
            if (i == 1 || i == 4) {
                data.setType(2);
            } else if (i == 8 || i == 13 || i == 16) {
                data.setType(3);
            } else if (i == 6 || i == 11 || i == 17) {
                data.setType(4);
            } else if (i == 18) {
                data.setType(5);
            }
            data.setNew(false);
            data.setApplyName("EMIS管理员");
            data.setYuyueTime("13:00-15:00");
            data.setPhotosList(null);
            data.setDeviceList(null);
            data.setLocation("東京都新宿区新宿1-" + i);

            if (i < 2) {
                data.setCreateTime("2018-03-24 12:40");
                data.setOrderCode("CM0201803004" + i);
                data.setOrderDescribe("停电");
                data.setPfmCode("SZ001-20180328-161" + i);
                data.setOrderStatus("1普通");
                data.setPriority("1普通");
                data.setState("" + i);
                data.setDepartment("服务部");
                data.setPhoneNumber("1800891290" + i);
                data.setQestionContent("停电");
                data.setWorkOrderType("门卫工单");
                data.setServerType("POS机");
            } else if (i < 5) {
                data.setCreateTime("2018-01-20 8:40");
                data.setOrderCode("CM02018030234");
                data.setOrderDescribe("楼道漏水");
                data.setPfmCode("SZ001-20180422-1321");
                data.setPriority("紧急处理");
                data.setOrderStatus("紧急处理");
                data.setState("0");
                data.setDepartment("人事部");
                data.setPhoneNumber("1800891293" + i);
                data.setWorkOrderType("维修工单");
                data.setServerType("ATM机");
            } else if (i < 9) {
                data.setCreateTime("2018-03-28 17:40");
                data.setOrderCode("CM02018030345");
                data.setOrderDescribe("没有按规定处理");
                data.setPfmCode("SZ001-20180328-1618");
                data.setPriority("1普通");
                data.setOrderStatus("1普通");
                data.setState("2");
                data.setDepartment("保障部");
                data.setPhoneNumber("1362222787" + i);
                data.setWorkOrderType("保安工单");
                data.setServerType("打印机");
            } else if (i < 12) {
                data.setCreateTime("2018-02-28 9:40");
                data.setOrderCode("CM02018030545");
                data.setOrderDescribe("地板有垃圾未处理");
                data.setPfmCode("SZ001-20180328-1618");
                data.setPriority("比较急");
                data.setOrderStatus("比较急");
                data.setState("4");
                data.setDepartment("门卫部");
                data.setPhoneNumber("15000098" + i);
                data.setWorkOrderType("报修工单");
                data.setServerType("终端机");
            } else {
                data.setCreateTime("2018-03-28 16:40");
                data.setOrderCode("CM02018030623");
                data.setOrderDescribe("停电");
                data.setPfmCode("SZ001-20180328-1618");
                data.setOrderStatus("1普通");
                data.setPriority("1普通");
                data.setState("3");
                data.setDepartment("维修部");
                data.setPhoneNumber("0218-2333241" + i);
                data.setWorkOrderType("维修工单");
                data.setServerType("自动取款机");
            }
            data.setId("10000" + i);
            list.add(data);
        }
        return list;
    }


    /**
     * 获取消息中心数据
     */
    public static ProjectMessageBean getProjectMessageModuleData() {
        ProjectMessageBean dataBean = new ProjectMessageBean();
        dataBean.setTotal(20);

        List<ProjectMessageBean.Data> list = new ArrayList<>();
        ProjectMessageBean.Data data;
        for (int i = 0; i < 6; i++) {
            data = new ProjectMessageBean.Data();
            if (i == 0) {
                data.setName("晶融汇广场");
                data.setProvince("四川");
                data.setCity("成都市");
                data.setArea("武侯区");
                data.setImgeURL("http://pic.58pic.com/58pic/12/85/53/06k58PICXIH.jpg");
                data.setMsgCount(3);
            } else if (i == 1) {
                data.setName("苏悦");
                data.setProvince("上海");
                data.setCity("上海");
                data.setArea("长宁区");
                data.setImgeURL("http://pic.58pic.com/58pic/12/85/89/48n58PICsRS.jpg");
                data.setMsgCount(0);
            } else if (i == 2) {
                data.setName("乔布斯公馆");
                data.setProvince("上海");
                data.setCity("上海");
                data.setArea("长宁区");
                data.setImgeURL("http://pic.58pic.com/58pic/12/85/53/06k58PICXIH.jpg");
                data.setMsgCount(129);
            } else if (i == 3) {
                data.setName("前滩验房缺陷统计");
                data.setProvince("香港");
                data.setCity("香港");
                data.setArea("九龙城区");
                data.setImgeURL("http://pic.58pic.com/58pic/12/85/31/86g58PICUZb.jpg");
                data.setMsgCount(1);
            } else if (i == 4) {
                data.setName("香港美心");
                data.setProvince("上海");
                data.setCity("上海");
                data.setArea("浦东新区");
                data.setImgeURL("http://pic.58pic.com/58pic/12/85/37/33x58PIC7gf.jpg");
                data.setMsgCount(48);
            } else {
                data.setName("测试楼盘");
                data.setProvince("江苏");
                data.setCity("常州");
                data.setArea("新区");
                data.setImgeURL("http://pic8.nipic.com/20100727/2572038_010122214489_2.jpg");
                data.setMsgCount(0);
            }
            list.add(data);
        }

        dataBean.setData(list);
        return dataBean;
    }

    /**
     * 获取消息中心数据
     */
    public static List<MessageInfoBean2.Data> getMessageListModuleData() {
        List<MessageInfoBean2.Data> list = new ArrayList<>();
        MessageInfoBean2 dataBean = new MessageInfoBean2();
        dataBean.setTotal(20);

        MessageInfoBean2.Data data;
        for (int i = 0; i < 20; i++) {
            data = new MessageInfoBean2.Data();
            if (i < 3) {
                data.setDate("2018-6-12");
                data.setState("0");
                data.setType(1);
            } else if (i < 10) {
                data.setDate("2018-5-3");
                data.setState("1");
                data.setType(2);
            } else if (i < 14) {
                data.setDate("2018-4-30");
                data.setState("0");
                data.setType(3);
            } else {
                data.setType(4);
            }
            data.setId("10000" + i);
            data.setMessage("尊敬的用户您好,巡检任务测试于2018-04-02开始，请提前准备。");
            data.setTitle("EMIS");
            list.add(data);
        }

        dataBean.setData(list);
        return list;
    }

    /**
     * 获取消息中心数据
     */
    public static List<MessageInfoBean2.Data> getMessageListModuleData2() {
        List<MessageInfoBean2.Data> list = new ArrayList<>();
        MessageInfoBean2 dataBean = new MessageInfoBean2();
        dataBean.setTotal(20);

        MessageInfoBean2.Data data;
        for (int i = 0; i < 20; i++) {
            data = new MessageInfoBean2.Data();
            if (i < 3) {
                data.setDate("2018-6-12");
                data.setState("0");
                data.setType(1);
            } else if (i < 10) {
                data.setDate("2018-5-3");
                data.setState("1");
                data.setType(2);
            } else if (i < 14) {
                data.setDate("2018-4-30");
                data.setState("0");
                data.setType(3);
            } else {
                data.setType(4);
            }
            data.setId("10000" + i);
            data.setMessage("チケット：SZ001-20180628-888割当完了！受取人：佐藤さん");
            data.setTitle("EMIS");
            list.add(data);
        }

        dataBean.setData(list);
        return list;
    }

    /**
     * 获取工作模块数据
     */
    public static WorkModuleBean getWorkModuleData() {
        WorkModuleBean workModuleBean = new WorkModuleBean();
        workModuleBean.setBannerImgUrl("");
        workModuleBean.setOrderNum(200);
        workModuleBean.setOffOrderNum(130);

        List<WorkModuleBean.BodyBean> mDatas = new ArrayList<>();
        WorkModuleBean.BodyBean bodyBean = new WorkModuleBean.BodyBean();
        bodyBean.setName("巡店任务");
        bodyBean.setCount(2);
        bodyBean.setImageURL("");
        bodyBean.setWorkCode(10001);

        WorkModuleBean.BodyBean bodyBean1 = new WorkModuleBean.BodyBean();
        bodyBean1.setName("工单任务");
        bodyBean1.setCount(100);
        bodyBean1.setImageURL("");
        bodyBean1.setWorkCode(10002);

        WorkModuleBean.BodyBean bodyBean2 = new WorkModuleBean.BodyBean();
        bodyBean2.setName("巡检任务");
        bodyBean2.setCount(0);
        bodyBean2.setImageURL("");
        bodyBean2.setWorkCode(10003);

        WorkModuleBean.BodyBean bodyBean3 = new WorkModuleBean.BodyBean();
        bodyBean3.setName("现场收楼");
        bodyBean3.setCount(1);
        bodyBean3.setImageURL("");
        bodyBean3.setWorkCode(10004);

        WorkModuleBean.BodyBean bodyBean4 = new WorkModuleBean.BodyBean();
        bodyBean4.setName("计划性维护");
        bodyBean4.setCount(0);
        bodyBean4.setImageURL("");
        bodyBean4.setWorkCode(10005);

        WorkModuleBean.BodyBean bodyBean5 = new WorkModuleBean.BodyBean();
        bodyBean5.setName("厂库物料");
        bodyBean5.setCount(0);
        bodyBean5.setImageURL("");
        bodyBean5.setWorkCode(10006);

        WorkModuleBean.BodyBean bodyBean6 = new WorkModuleBean.BodyBean();
        bodyBean6.setName("能源管理");
        bodyBean6.setCount(0);
        bodyBean6.setImageURL("");
        bodyBean6.setWorkCode(10007);

        WorkModuleBean.BodyBean bodyBean7 = new WorkModuleBean.BodyBean();
        bodyBean7.setName("资产管理");
        bodyBean7.setCount(0);
        bodyBean7.setImageURL("");
        bodyBean7.setWorkCode(10008);

        WorkModuleBean.BodyBean bodyBean8 = new WorkModuleBean.BodyBean();
        bodyBean8.setName("查看报表");
        bodyBean8.setCount(0);
        bodyBean8.setImageURL("");
        bodyBean8.setWorkCode(10009);

        mDatas.add(bodyBean);
        mDatas.add(bodyBean1);
        mDatas.add(bodyBean2);
        mDatas.add(bodyBean3);
        mDatas.add(bodyBean4);
        mDatas.add(bodyBean5);
        mDatas.add(bodyBean6);
        mDatas.add(bodyBean7);
        mDatas.add(bodyBean8);

        workModuleBean.setBody(mDatas);
        return workModuleBean;
    }

    /**
     * 获取工作-巡检
     */
    public static WorkModuleBean getWorkPollingModuleData() {
        WorkModuleBean workModuleBean = new WorkModuleBean();
        workModuleBean.setBannerImgUrl("");
        workModuleBean.setOrderNum(200);
        workModuleBean.setOffOrderNum(130);

        List<WorkModuleBean.BodyBean> mDatas = new ArrayList<>();
        WorkModuleBean.BodyBean bodyBean = new WorkModuleBean.BodyBean();
        bodyBean.setName("巡检任务");
        bodyBean.setCount(41);
        bodyBean.setImageURL("");
        bodyBean.setWorkCode(20001);

        WorkModuleBean.BodyBean bodyBean1 = new WorkModuleBean.BodyBean();
        bodyBean1.setName("巡检查询");
        bodyBean1.setCount(100);
        bodyBean1.setImageURL("");
        bodyBean1.setWorkCode(20002);

        mDatas.add(bodyBean);
        mDatas.add(bodyBean1);

        workModuleBean.setBody(mDatas);
        return workModuleBean;
    }

    /**
     * 获取工作-工单
     */
    public static WorkModuleBean getWorkOrderModuleData() {
        WorkModuleBean workModuleBean = new WorkModuleBean();
        workModuleBean.setBannerImgUrl("");
        workModuleBean.setOrderNum(200);
        workModuleBean.setOffOrderNum(130);

        List<WorkModuleBean.BodyBean> mDatas = new ArrayList<>();
        WorkModuleBean.BodyBean bodyBean = new WorkModuleBean.BodyBean();
        bodyBean.setName("创建工单");
        bodyBean.setCount(2);
        bodyBean.setImageURL("");
        bodyBean.setWorkCode(30001);

        WorkModuleBean.BodyBean bodyBean1 = new WorkModuleBean.BodyBean();
        bodyBean1.setName("待处理工单");
        bodyBean1.setCount(100);
        bodyBean1.setImageURL("");
        bodyBean1.setWorkCode(30002);

        WorkModuleBean.BodyBean bodyBean2 = new WorkModuleBean.BodyBean();
        bodyBean2.setName("待派工工单");
        bodyBean2.setCount(0);
        bodyBean2.setImageURL("");
        bodyBean2.setWorkCode(30003);

        WorkModuleBean.BodyBean bodyBean3 = new WorkModuleBean.BodyBean();
        bodyBean3.setName("待审批工单");
        bodyBean3.setCount(1);
        bodyBean3.setImageURL("");
        bodyBean3.setWorkCode(30004);

        WorkModuleBean.BodyBean bodyBean4 = new WorkModuleBean.BodyBean();
        bodyBean4.setName("待存档工单");
        bodyBean4.setCount(0);
        bodyBean4.setImageURL("");
        bodyBean4.setWorkCode(30005);

        WorkModuleBean.BodyBean bodyBean6 = new WorkModuleBean.BodyBean();
        bodyBean6.setName("待评价工单");
        bodyBean6.setCount(0);
        bodyBean6.setImageURL("");
        bodyBean6.setWorkCode(30006);

        WorkModuleBean.BodyBean bodyBean5 = new WorkModuleBean.BodyBean();
        bodyBean5.setName("工单查询");
        bodyBean5.setCount(2);
        bodyBean5.setImageURL("");
        bodyBean5.setWorkCode(30008);

        mDatas.add(bodyBean);
        mDatas.add(bodyBean1);
        mDatas.add(bodyBean2);
        mDatas.add(bodyBean3);
        mDatas.add(bodyBean4);
        mDatas.add(bodyBean5);
        mDatas.add(bodyBean6);

        workModuleBean.setBody(mDatas);
        return workModuleBean;
    }

    /**
     * 获取工作-工单
     */
    public static WorkModuleBean getWorkOrderModuleData2() {
        WorkModuleBean workModuleBean = new WorkModuleBean();
        workModuleBean.setBannerImgUrl("");
        workModuleBean.setOrderNum(200);
        workModuleBean.setOffOrderNum(130);

        List<WorkModuleBean.BodyBean> mDatas = new ArrayList<>();
        WorkModuleBean.BodyBean bodyBean = new WorkModuleBean.BodyBean();
        bodyBean.setName("创建工单");
        bodyBean.setCount(2);
        bodyBean.setImageURL("");
        bodyBean.setWorkCode(30001);

        WorkModuleBean.BodyBean bodyBean1 = new WorkModuleBean.BodyBean();
        bodyBean1.setName("待处理工单");
        bodyBean1.setCount(100);
        bodyBean1.setImageURL("");
        bodyBean1.setWorkCode(30002);

        WorkModuleBean.BodyBean bodyBean2 = new WorkModuleBean.BodyBean();
        bodyBean2.setName("待派工工单");
        bodyBean2.setCount(0);
        bodyBean2.setImageURL("");
        bodyBean2.setWorkCode(30003);

        WorkModuleBean.BodyBean bodyBean3 = new WorkModuleBean.BodyBean();
        bodyBean3.setName("待审批工单");
        bodyBean3.setCount(1);
        bodyBean3.setImageURL("");
        bodyBean3.setWorkCode(30004);

        WorkModuleBean.BodyBean bodyBean4 = new WorkModuleBean.BodyBean();
        bodyBean4.setName("待存档工单");
        bodyBean4.setCount(0);
        bodyBean4.setImageURL("");
        bodyBean4.setWorkCode(30005);

        WorkModuleBean.BodyBean bodyBean6 = new WorkModuleBean.BodyBean();
        bodyBean6.setName("待评价工单");
        bodyBean6.setCount(0);
        bodyBean6.setImageURL("");
        bodyBean6.setWorkCode(30006);

        WorkModuleBean.BodyBean bodyBean5 = new WorkModuleBean.BodyBean();
        bodyBean5.setName("工单查询");
        bodyBean5.setCount(2);
        bodyBean5.setImageURL("");
        bodyBean5.setWorkCode(30008);

        mDatas.add(bodyBean);
        mDatas.add(bodyBean1);
        mDatas.add(bodyBean2);
        mDatas.add(bodyBean3);
        mDatas.add(bodyBean4);
        mDatas.add(bodyBean5);
        mDatas.add(bodyBean6);

        workModuleBean.setBody(mDatas);
        return workModuleBean;
    }


    /**
     * 获取工作-库存管理
     */
    public static WorkModuleBean getWorkRepertoryModuleData() {
        WorkModuleBean workModuleBean = new WorkModuleBean();
        workModuleBean.setBannerImgUrl("");
        workModuleBean.setOrderNum(200);
        workModuleBean.setOffOrderNum(130);

        List<WorkModuleBean.BodyBean> mDatas = new ArrayList<>();
        WorkModuleBean.BodyBean bodyBean = new WorkModuleBean.BodyBean();
        bodyBean.setName("入库");
        bodyBean.setCount(0);
        bodyBean.setImageURL("");
        bodyBean.setWorkCode(50001);

        WorkModuleBean.BodyBean bodyBean1 = new WorkModuleBean.BodyBean();
        bodyBean1.setName("出库");
        bodyBean1.setCount(1);
        bodyBean1.setImageURL("");
        bodyBean1.setWorkCode(50002);

        WorkModuleBean.BodyBean bodyBean2 = new WorkModuleBean.BodyBean();
        bodyBean2.setName("移库");
        bodyBean2.setCount(0);
        bodyBean2.setImageURL("");
        bodyBean2.setWorkCode(50003);

        WorkModuleBean.BodyBean bodyBean3 = new WorkModuleBean.BodyBean();
        bodyBean3.setName("盘点");
        bodyBean3.setCount(0);
        bodyBean3.setImageURL("");
        bodyBean3.setWorkCode(50004);

        WorkModuleBean.BodyBean bodyBean4 = new WorkModuleBean.BodyBean();
        bodyBean4.setName("物资预定");
        bodyBean4.setCount(0);
        bodyBean4.setImageURL("");
        bodyBean4.setWorkCode(50005);

        WorkModuleBean.BodyBean bodyBean5 = new WorkModuleBean.BodyBean();
        bodyBean5.setName("我的预定");
        bodyBean5.setCount(0);
        bodyBean5.setImageURL("");
        bodyBean5.setWorkCode(50008);

        WorkModuleBean.BodyBean bodyBean6 = new WorkModuleBean.BodyBean();
        bodyBean6.setName("库存审核");
        bodyBean6.setCount(0);
        bodyBean6.setImageURL("");
        bodyBean6.setWorkCode(50009);

        WorkModuleBean.BodyBean bodyBean7 = new WorkModuleBean.BodyBean();
        bodyBean7.setName("库存查询");
        bodyBean7.setCount(0);
        bodyBean7.setImageURL("");
        bodyBean7.setWorkCode(50010);

        mDatas.add(bodyBean);
        mDatas.add(bodyBean1);
        mDatas.add(bodyBean2);
        mDatas.add(bodyBean3);
        mDatas.add(bodyBean4);
        mDatas.add(bodyBean5);
        mDatas.add(bodyBean6);
        mDatas.add(bodyBean7);

        workModuleBean.setBody(mDatas);
        return workModuleBean;
    }

    /**
     * 获取优先级数据
     */
    public static StateInfoBean getPriorityStateInfoBeanModuleData() {
        StateInfoBean dataBean = new StateInfoBean();
        List<StateInfoBean.Data> list = new ArrayList<>();

        StateInfoBean.Data data = new StateInfoBean.Data();
        data.setName("不限");
        StateInfoBean.Data data1 = new StateInfoBean.Data();
        data1.setName("V应急");
        StateInfoBean.Data data2 = new StateInfoBean.Data();
        data2.setName("1普通");
        StateInfoBean.Data data3 = new StateInfoBean.Data();
        data3.setName("2紧急关键");
        StateInfoBean.Data data4 = new StateInfoBean.Data();
        data4.setName("3紧急重大");
        StateInfoBean.Data data5 = new StateInfoBean.Data();
        data5.setName("客户报修");

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
     * 获取订单状态数据
     */
    public static StateInfoBean getOrderStateStateInfoBeanModuleData() {
        StateInfoBean dataBean = new StateInfoBean();
        List<StateInfoBean.Data> list = new ArrayList<>();

        StateInfoBean.Data data = new StateInfoBean.Data();
        data.setName("不限");
        StateInfoBean.Data data1 = new StateInfoBean.Data();
        data1.setName("已创建");
        StateInfoBean.Data data2 = new StateInfoBean.Data();
        data2.setName("已派工");
        StateInfoBean.Data data3 = new StateInfoBean.Data();
        data3.setName("处理中");
        StateInfoBean.Data data4 = new StateInfoBean.Data();
        data4.setName("已暂停");
        StateInfoBean.Data data5 = new StateInfoBean.Data();
        data5.setName("已终止");
        StateInfoBean.Data data6 = new StateInfoBean.Data();
        data6.setName("已完成");
        StateInfoBean.Data data7 = new StateInfoBean.Data();
        data7.setName("已验证");
        StateInfoBean.Data data8 = new StateInfoBean.Data();
        data8.setName("已存档");
        StateInfoBean.Data data9 = new StateInfoBean.Data();
        data9.setName("待审批");

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
     * 获取维护详情-步骤列表
     */
    public static PlanMaintainDetailStepBean getPlanMaintainDetailStepModuleData() {
        List<PlanMaintainDetailStepBean.Data> list = new ArrayList<>();
        PlanMaintainDetailStepBean dataBean = new PlanMaintainDetailStepBean();
        dataBean.setTotal(10);

        PlanMaintainDetailStepBean.Data data;
        for (int i = 0; i < 4; i++) {
            data = new PlanMaintainDetailStepBean.Data();
            data.setId("" + i);
            if (i == 0) {
                data.setWorkGroupName("九龙区工程部");
                data.setPlanContent("测试");
            } else if (i == 1) {
                data.setWorkGroupName("天府广场");
                data.setPlanContent("维修天然气管道");
            } else if (i == 2) {
                data.setWorkGroupName("绿地商务广场");
                data.setPlanContent("广场巡逻");
            } else if (i >= 2) {
                data.setWorkGroupName("陆家嘴商务中心");
                data.setPlanContent("江边巡逻");
            }
            list.add(data);
        }

        dataBean.setData(list);
        return dataBean;
    }

    /**
     * 资产数据
     */
    public static PropertyManageBean getPropertyManageModuleData() {
        List<PropertyManageBean.Data> list = new ArrayList<>();
        PropertyManageBean dataBean = new PropertyManageBean();
        dataBean.setTotal(10);

        PropertyManageBean.Data data;
        for (int i = 0; i < 4; i++) {
            data = new PropertyManageBean.Data();
            data.setId("" + i);
            data.setMessage((i + 1) + "#监视中心管理服务");
            if (i == 0) {
                data.setInstalLosition("绿地中心");
                data.setSystemClass("停车");
            } else if (i > 0) {
                data.setInstalLosition("商务广场");
                data.setSystemClass("广告牌");
            }
            list.add(data);
        }

        dataBean.setData(list);
        return dataBean;
    }
}
