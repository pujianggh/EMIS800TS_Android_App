package com.android.ts.emis.mvp.presenter;

import android.content.Context;

import com.android.ts.emis.mode.TicketDetailInfoBean;
import com.android.ts.emis.mode.UpdateTicketBean;
import com.android.ts.emis.mode.json.UpdateTicketJson;
import com.android.ts.emis.mvp.iface.IWorkOrderInfo;
import com.android.ts.emis.mvp.impl.WrokOrderInfoImpl;
import com.android.ts.emis.mvp.view.IWorkOrderDetailsView;
import com.libcommon.action.net.INetWorkCallBack;

import okhttp3.Headers;

/**
 * @author pujiang
 * @date 2018/8/17 15:21
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderDetailsPresenter extends INetWorkCallBack {
    private Context mContext;
    private IWorkOrderInfo iWorkOrderInfo;
    private IWorkOrderDetailsView iWorkOrderDetailsView;

    public WorkOrderDetailsPresenter(Context mContext, IWorkOrderDetailsView iWorkOrderDetailsView) {
        this.mContext = mContext;
        this.iWorkOrderDetailsView = iWorkOrderDetailsView;
        iWorkOrderInfo = new WrokOrderInfoImpl();
    }

    /**
     * 获取详情信息
     *
     * @param ticketsCode
     */
    public void getWorkOrderDetailsInfo(String ticketsCode) {
        iWorkOrderInfo.getTicketsWorkOrderInfo(mContext, this, ticketsCode);
    }

    /**
     * 编辑
     *
     * @param updateTicketJson
     */
    public void getUpdateWorkOrderDetailsInfo(UpdateTicketJson updateTicketJson) {
        iWorkOrderInfo.getUpdateTickets(mContext, this, updateTicketJson);
    }

    @Override
    public <T> void onSuccess(T t, Headers headers, Class cla, String constantUrl) {
        iWorkOrderDetailsView.hideLoading();
        if (TicketDetailInfoBean.class == cla) {
            TicketDetailInfoBean bean = (TicketDetailInfoBean) t;
            iWorkOrderDetailsView.setUIData(bean);
        }
        if (UpdateTicketBean.class == cla) {
            UpdateTicketBean bean = (UpdateTicketBean) t;
            if (bean != null) {
                iWorkOrderDetailsView.showToast(bean.getMessage());
                if ("success".equals(bean.getStatus())) iWorkOrderDetailsView.successBackPressed();
            }
        }
    }

    @Override
    public <T> void onPullUpSuccess(T t, Class cla, String constantUrl) {
        iWorkOrderDetailsView.hideLoading();
    }

    @Override
    public void noNetWork() {
        iWorkOrderDetailsView.hideLoading();
    }

    @Override
    public void onError(int status, String str, Class cla, String constantUrl) {
        iWorkOrderDetailsView.hideLoading();
    }
}
