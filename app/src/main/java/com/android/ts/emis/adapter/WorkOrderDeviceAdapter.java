package com.android.ts.emis.adapter;

import android.content.Context;
import android.view.View;

import com.android.ts.emis.R;
import com.android.ts.emis.activity.work.WorkOrderCreateActivity;
import com.android.ts.emis.mode.StateInfoBean;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import cn.bingoogolapple.swipeitemlayout.BGASwipeItemLayout;

/**
 * 工单设备信息
 *
 * @author pujiang
 * @date 2018-5-18 16:15
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderDeviceAdapter extends BGAAdapterViewAdapter<StateInfoBean.Data> {
    //当前处于打开状态的item
    private List<BGASwipeItemLayout> mOpenedSil = new ArrayList<>();

    public WorkOrderDeviceAdapter(Context context) {
        super(context, R.layout.item_work_order_device);
    }

    @Override
    protected void setItemChildListener(BGAViewHolderHelper viewHolderHelper) {
        BGASwipeItemLayout swipeItemLayout = viewHolderHelper.getView(R.id.swipe_root);
        swipeItemLayout.setDelegate(new BGASwipeItemLayout.BGASwipeItemLayoutDelegate() {
            @Override
            public void onBGASwipeItemLayoutOpened(BGASwipeItemLayout swipeItemLayout) {
                closeOpenedSwipeItemLayoutWithAnim();
                mOpenedSil.add(swipeItemLayout);
            }

            @Override
            public void onBGASwipeItemLayoutClosed(BGASwipeItemLayout swipeItemLayout) {
                mOpenedSil.remove(swipeItemLayout);
            }

            @Override
            public void onBGASwipeItemLayoutStartOpen(BGASwipeItemLayout swipeItemLayout) {
                closeOpenedSwipeItemLayoutWithAnim();
            }
        });
        viewHolderHelper.setItemChildClickListener(R.id.tv_delete);
    }

    @Override
    protected void fillData(BGAViewHolderHelper viewHolderHelper, final int position, StateInfoBean.Data model) {
        viewHolderHelper.setText(R.id.tv_deviceCode, model.getCode());
        viewHolderHelper.setText(R.id.tv_deviceName, model.getName());
        viewHolderHelper.setText(R.id.tv_deviceLocation, model.getAddress());
        viewHolderHelper.getView(R.id.tv_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
                ((WorkOrderCreateActivity) mContext).refreshDeviceInfo(mData);
                closeOpenedSwipeItemLayout();
            }
        });
        BGASwipeItemLayout swipeItemLayout = viewHolderHelper.getView(R.id.swipe_root);
        swipeItemLayout.setSwipeAble(true);
    }

    /**
     * 关闭滑动开关
     */
    public void closeOpenedSwipeItemLayoutWithAnim() {
        for (BGASwipeItemLayout sil : mOpenedSil) {
            sil.closeWithAnim();
        }
        mOpenedSil.clear();
    }

    /**
     * 清除滑动开关
     */
    public void closeOpenedSwipeItemLayout() {
        for (BGASwipeItemLayout sil : mOpenedSil) {
            sil.close();
        }
        mOpenedSil.clear();
    }
}
