package com.android.ts.emis.mvp.presenter;

import android.content.Context;

import com.android.ts.emis.mode.MessageInfoBean;
import com.android.ts.emis.mvp.iface.IMessageInfo;
import com.android.ts.emis.mvp.impl.MessageInfoImpl;
import com.android.ts.emis.mvp.view.IMessageInfoView;
import com.android.ts.emis.net.OkhttpUtil;
import com.libcommon.action.net.INetWorkCallBack;

import okhttp3.Headers;

/**
 * @author pujiang
 * @date 2018/8/17 15:21
 * @mail 515210530@qq.com
 * @Description:
 */
public class MessageInfoPresenter extends INetWorkCallBack {
    private Context mContext;
    private IMessageInfo iMessageInfo;
    private IMessageInfoView iMessageInfoView;

    public MessageInfoPresenter(Context mContext, IMessageInfoView iMessageInfoView) {
        this.mContext = mContext;
        this.iMessageInfoView = iMessageInfoView;
        iMessageInfo = new MessageInfoImpl();
    }

    /***
     *
     * 获取消息列表
     * @param page  页数
     * @param size  每页显示条数
     * @param userCode  用户id
     * @param houseCode
     * @param modle  刷新modle
     */
    public void getMessageInfoLists(String page, String size, String userCode, String houseCode, OkhttpUtil.GetUrlMode modle) {
        iMessageInfo.getMessageInfoLists(mContext, this, page, size, userCode, houseCode, modle);
    }

    @Override
    public <T> void onSuccess(T t, Headers headers, Class cla, String constantUrl) {
        iMessageInfoView.hideLoading();
        MessageInfoBean messageInfoBean = (MessageInfoBean) t;
        iMessageInfoView.getMessageInfos(messageInfoBean);
    }

    @Override
    public <T> void onPullUpSuccess(T t, Class cla, String constantUrl) {
        iMessageInfoView.hideLoading();
        if (MessageInfoBean.class == t) {
            MessageInfoBean messageInfoBean = (MessageInfoBean) t;
            iMessageInfoView.addMessageInfos(messageInfoBean);
        }
    }

    @Override
    public void noNetWork() {

    }

    @Override
    public void onError(int status, String str, Class cla, String constantUrl) {
        iMessageInfoView.hideLoading();
    }
}
