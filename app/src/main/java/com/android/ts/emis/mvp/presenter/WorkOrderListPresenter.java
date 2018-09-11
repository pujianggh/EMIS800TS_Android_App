package com.android.ts.emis.mvp.presenter;

import android.content.Context;

import com.android.ts.emis.mode.UserPasswordBean;
import com.android.ts.emis.mode.WorkOrderQueryListBean;
import com.android.ts.emis.mvp.iface.IWorkOrderInfo;
import com.android.ts.emis.mvp.impl.WrokOrderInfoImpl;
import com.android.ts.emis.mvp.view.IWorkOrderListView;
import com.android.ts.emis.net.OkhttpUtil;
import com.android.ts.emis.utils.SPUtil;
import com.libcommon.action.net.INetWorkCallBack;

import okhttp3.Headers;

/**
 * @author pujiang
 * @date 2018/8/17 15:21
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderListPresenter extends INetWorkCallBack {
    private Context mContext;
    private IWorkOrderInfo iWorkOrderInfo;
    private IWorkOrderListView iWorkOrderListView;
    private UserPasswordBean mUserPasswrd = new UserPasswordBean();

    public WorkOrderListPresenter(Context mContext, IWorkOrderListView iWorkOrderListView) {
        this.mContext = mContext;
        this.iWorkOrderListView = iWorkOrderListView;
        iWorkOrderInfo = new WrokOrderInfoImpl();
    }

    /**
     * 根据不同类型：查询工单数据
     * <p>
     * 工单已创建 0
     * 工单已派工 1
     * 工单待审批 2
     * 工单处理中 3
     * 工单暂停-继续      4
     * 工单暂停-待派工 5
     * 工单执行完成   6
     * 工单已验证 7
     * 工单已存档 8
     * 工单已关闭 9
     * 工单已作废 10
     *
     * @param page
     * @param size
     * @param ticketsStatus
     * @param modle
     */
    public void getWorkOrderLists(String page, String size, String ticketsStatus, OkhttpUtil.GetUrlMode modle) {
        mUserPasswrd = SPUtil.INSTANCE.getAllModle(mContext, mUserPasswrd);
        iWorkOrderInfo.getWorkOrderQueryLists(mContext, this, page, size,
                "", mUserPasswrd.getHouseCode(), "", "", "", "", "",
                "", ticketsStatus, modle);
    }

    @Override
    public <T> void onSuccess(T t, Headers headers, Class cla, String constantUrl) {
        iWorkOrderListView.hideLoading();
        WorkOrderQueryListBean workOrderQueryListBean = (WorkOrderQueryListBean) t;
        iWorkOrderListView.getWorkOrderLists(workOrderQueryListBean);
    }

    @Override
    public <T> void onPullUpSuccess(T t, Class cla, String constantUrl) {
        iWorkOrderListView.hideLoading();
        if (WorkOrderQueryListBean.class == cla) {
            WorkOrderQueryListBean workOrderQueryListBean = (WorkOrderQueryListBean) t;
            iWorkOrderListView.addWorkOrderLists(workOrderQueryListBean);
        }
    }

    @Override
    public void noNetWork() {
        iWorkOrderListView.hideLoading();
    }

    @Override
    public void onError(int status, String str, Class cla, String constantUrl) {
        iWorkOrderListView.hideLoading();
    }
}
