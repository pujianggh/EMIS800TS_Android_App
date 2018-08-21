package com.android.ts.emis.app;

import com.libcommon.action.base.CommonBaseApplication;
import com.libcommon.action.utils.APPToolsUtil;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackManager;

/**
 * Application类
 *
 * @author pujiang
 * @date 2018-01-25 17:21
 * @mail 515210530@qq.com
 * @Description:
 */
public class APPApplication extends CommonBaseApplication {
    public static Class toIntentMainClass = "MainActivity".getClass();  //需要跳转主页的类
    private static APPApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initConfigData();
        initOkHttpConfig();//初始化网络请求参数
        initAndFix(APPToolsUtil.getAppVersionName(this));
    }

    /**
     * 初始化项目配置文件数据
     */
    private void initConfigData() {
        // 必须在Application的onCreate 方法中执行
        // BGASwipeBackManager.getInstance().init(this)来初始化滑动返回
        BGASwipeBackManager.getInstance().init(this);
    }

    public static synchronized APPApplication getInstance() {
        return mInstance;
    }


//    //消息临时缓存，测试使用
//    private List<MessageInfoBean2.Data> messageDataList = DataCenter.getMessageListModuleData2();
//
//    public List<MessageInfoBean2.Data> getMessageDataList() {
//        return messageDataList;
//    }
//
//    public void setMessageDataList(List<MessageInfoBean2.Data> messageDataList) {
//        this.messageDataList = messageDataList;
//    }
//
//    public void addMessageDataList(List<MessageInfoBean2.Data> lists) {
//        if (lists != null) {
//            int size = lists.size();
//            for (int i = 0; i < size; i++) {
//                this.messageDataList.add(lists.get(i));
//            }
//        }
//    }
//
//    public void addMessageData(MessageInfoBean2.Data data) {
//        if (data != null) {
//            this.messageDataList.add(0, data);
//        }
//    }
//
//    //工单信息临时缓存，测试使用
//    private List<WorkOrderListBean.Data> workDataList = DataCenter.getWorkOrderTestList();
//
//    public void setWorkOrderType(String id, int type) {
//        int size = workDataList.size();
//        WorkOrderListBean.Data bean;
//        for (int i = 0; i < size; i++) {
//            if (id.equals(workDataList.get(i).getId())) {
//                bean = workDataList.get(i);
//                bean.setType(type);
//                workDataList.remove(workDataList.get(i));
//                workDataList.add(0, bean);
//            }
//        }
//    }
//
//    public void setInputWorkMessage(String id, String inputMessage) {
//        int size = workDataList.size();
//        WorkOrderListBean.Data bean;
//        for (int i = 0; i < size; i++) {
//            if (id.equals(workDataList.get(i).getId())) {
//                bean = workDataList.get(i);
//                bean.setMessage(bean.getMessage() + " 工作输入:" + inputMessage);
//                workDataList.remove(workDataList.get(i));
//                workDataList.add(0, bean);
//            }
//        }
//    }
//
//    public List<WorkOrderListBean.Data> getWorkOrderTypeList(int type) {
//        if (type == 0) {
//            return workDataList;
//        }
//        List<WorkOrderListBean.Data> typeList = new ArrayList<>();
//        int size = workDataList.size();
//        for (int i = 0; i < size; i++) {
//            if (type == workDataList.get(i).getType()) {
//                typeList.add(workDataList.get(i));
//            }
//        }
//        return typeList;
//    }
//
//    public WorkOrderListBean.Data getWorkOrderBean(String id) {
//        if (id == null)
//            return workDataList.get(0);
//        WorkOrderListBean.Data bean = null;
//        int size = workDataList.size();
//        for (int i = 0; i < size; i++) {
//            if (id.equals(workDataList.get(i).getId())) {
//                bean = workDataList.get(i);
//            }
//        }
//        if (bean == null) {
//            bean = workDataList.get(0);
//        }
//        return bean;
//    }
//
//    public List<WorkOrderListBean.Data> getWorkDataList() {
//        return workDataList;
//    }
//
//    public void setWorkDataList(List<WorkOrderListBean.Data> workDataList) {
//        this.workDataList = workDataList;
//    }
//
//    public void addWorkDataList(List<WorkOrderListBean.Data> workDataList) {
//        if (workDataList != null) {
//            int size = workDataList.size();
//            for (int i = 0; i < size; i++) {
//                this.workDataList.add(workDataList.get(i));
//            }
//        }
//    }
//
//    public void addWorkData(WorkOrderListBean.Data data) {
//        if (data != null) {
//            this.workDataList.add(data);
//        }
//    }
}
