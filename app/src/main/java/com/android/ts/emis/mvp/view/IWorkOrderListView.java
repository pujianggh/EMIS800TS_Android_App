package com.android.ts.emis.mvp.view;

import com.android.ts.emis.mode.WorkOrderQueryListBean;

/**
 * @author pujiang
 * @date 2018/8/16 13:53
 * @mail 515210530@qq.com
 * @Description:
 */
public interface IWorkOrderListView extends IParentView {

    void getWorkOrderLists(WorkOrderQueryListBean workOrderQueryListBean);

    void addWorkOrderLists(WorkOrderQueryListBean workOrderQueryListBean);
}
