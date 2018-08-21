package com.android.ts.emis.mvp.view;

import com.android.ts.emis.mode.MessageInfoBean;

/**
 * @author pujiang
 * @date 2018/8/16 13:53
 * @mail 515210530@qq.com
 * @Description:
 */
public interface IMessageInfoView extends IParentView {

    void getMessageInfos(MessageInfoBean messageInfoBean);

    void addMessageInfos(MessageInfoBean messageInfoBean);
}
