package com.android.ts.emis.mvp.view;

import com.android.ts.emis.mode.WorkOrderQueryListBean;

/**
 * @author pujiang
 * @date 2018/8/16 13:53
 * @mail 515210530@qq.com
 * @Description:
 */
public interface IWorkOrderQueryListView extends IParentView {

    void getWorkOrderQueryLists(WorkOrderQueryListBean workOrderQueryListBean);

    void addWorkOrderQueryLists(WorkOrderQueryListBean workOrderQueryListBean);
}
