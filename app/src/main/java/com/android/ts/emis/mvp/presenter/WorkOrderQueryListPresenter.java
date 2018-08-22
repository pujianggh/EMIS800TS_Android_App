package com.android.ts.emis.mvp.presenter;

import android.content.Context;

import com.android.ts.emis.mode.UserPasswordBean;
import com.android.ts.emis.mode.WorkOrderQueryListBean;
import com.android.ts.emis.mvp.iface.IWorkOrderInfo;
import com.android.ts.emis.mvp.impl.WrokOrderInfoImpl;
import com.android.ts.emis.mvp.view.IWorkOrderQueryListView;
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
public class WorkOrderQueryListPresenter extends INetWorkCallBack {
    private Context mContext;
    private IWorkOrderInfo iWorkOrderInfo;
    private IWorkOrderQueryListView iWorkOrderQueryListView;
    private UserPasswordBean mUserPasswrd = new UserPasswordBean();

    public WorkOrderQueryListPresenter(Context mContext, IWorkOrderQueryListView iWorkOrderQueryListView) {
        this.mContext = mContext;
        this.iWorkOrderQueryListView = iWorkOrderQueryListView;
        iWorkOrderInfo = new WrokOrderInfoImpl();
    }

    /**
     * 工单查询
     *
     * @param page
     * @param size
     * @param ticketsCode
     * @param estateCode
     * @param createStartTime
     * @param createEndTime
     * @param ticketsTypeCode
     * @param priorityCode
     * @param ticketsStatus
     * @param modle
     */
    public void getWorkOrderQueryLists(String page, String size,
                                       String ticketsCode, String estateCode, String createStartTime, String createEndTime, String ticketsTypeCode,
                                       String priorityCode, String ticketsStatus, OkhttpUtil.GetUrlMode modle) {

        mUserPasswrd = SPUtil.INSTANCE.getAllModle(mContext, mUserPasswrd);
//        iWorkOrderInfo.getWorkOrderQueryLists(mContext, this, page, size,
//                ticketsCode, mUserPasswrd.getHouseCode(), mUserPasswrd.getHousePhaseCode(), estateCode, createStartTime, createEndTime, ticketsTypeCode,
//                priorityCode, ticketsStatus, modle);

        iWorkOrderInfo.getWorkOrderQueryLists(mContext, this, page, size,
                "CM234-20180709-0072","7eb2bcd6-75e9-4f5e-a386-e8ababa7df38", "9d642d20-7520-4027-8048-61299a040ebc",
                "1557cc8f-e614-4672-bc0a-906196aa1ea2", "2018-07-01", "2018-07-31", "20180424150207150000",
                "20150414170730110785", "1", modle);
    }

    @Override
    public <T> void onSuccess(T t, Headers headers, Class cla, String constantUrl) {
        iWorkOrderQueryListView.hideLoading();
        WorkOrderQueryListBean workOrderQueryListBean = (WorkOrderQueryListBean) t;
        iWorkOrderQueryListView.getWorkOrderQueryLists(workOrderQueryListBean);
    }

    @Override
    public <T> void onPullUpSuccess(T t, Class cla, String constantUrl) {
        iWorkOrderQueryListView.hideLoading();
        if (WorkOrderQueryListBean.class == t) {
            WorkOrderQueryListBean workOrderQueryListBean = (WorkOrderQueryListBean) t;
            iWorkOrderQueryListView.addWorkOrderQueryLists(workOrderQueryListBean);
        }
    }

    @Override
    public void noNetWork() {

    }

    @Override
    public void onError(int status, String str, Class cla, String constantUrl) {
        iWorkOrderQueryListView.hideLoading();
    }
}
