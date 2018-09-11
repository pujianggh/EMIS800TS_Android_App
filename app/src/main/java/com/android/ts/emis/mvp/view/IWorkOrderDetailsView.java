package com.android.ts.emis.mvp.view;

import com.android.ts.emis.mode.TicketDetailInfoBean;

/**
 * @author pujiang
 * @date 2018/8/16 13:53
 * @mail 515210530@qq.com
 * @Description:
 */
public interface IWorkOrderDetailsView extends IParentView {

    void setUIData(TicketDetailInfoBean bean);

    void successBackPressed();
}
