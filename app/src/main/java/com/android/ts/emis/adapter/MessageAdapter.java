package com.android.ts.emis.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.activity.work.WorkOrderDetailsActivity;
import com.android.ts.emis.mode.MessageInfoBean;
import com.android.ts.emis.mvp.iface.IMessageInfo;
import com.android.ts.emis.mvp.impl.MessageInfoImpl;
import com.libcommon.action.net.INetWorkCallBack;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import cn.bingoogolapple.swipeitemlayout.BGASwipeItemLayout;

/**
 * 多项目选择
 *
 * @author pujiang
 * @date 2018-5-18 16:15
 * @mail 515210530@qq.com
 * @Description:
 */
public class MessageAdapter extends BGAAdapterViewAdapter<MessageInfoBean.DataBean.MessageListBean> {
    //当前处于打开状态的item
    private List<BGASwipeItemLayout> mOpenedSil = new ArrayList<>();
    private IMessageInfo iMessageInfo;

    public MessageAdapter(Context context) {
        super(context, R.layout.item_message);
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
    protected void fillData(BGAViewHolderHelper viewHolderHelper, final int position, final MessageInfoBean.DataBean.MessageListBean model) {
        viewHolderHelper.setText(R.id.tv_date, model.getSendDate());
        viewHolderHelper.setText(R.id.tv_title, model.getTitle());
        viewHolderHelper.setText(R.id.tv_message, model.getContent());
        //CM:维修工单;
        //PM:计划性维护工单;
        //IM:巡检工单
        if ("1".equals(model.getIsRead())) {
            viewHolderHelper.getView(R.id.igv_tips).setVisibility(View.VISIBLE);
        } else {
            viewHolderHelper.getView(R.id.igv_tips).setVisibility(View.GONE);
        }
        BGASwipeItemLayout swipeItemLayout = viewHolderHelper.getView(R.id.swipe_root);
        if (position % 3 == 0) {
            swipeItemLayout.setSwipeAble(false);//不能滑动
        } else {
            swipeItemLayout.setSwipeAble(true);
        }

        //0:全部 1：待处理工单 2：待派批工单（待派工) 3：待审批工单 4：待存档工单 5：待评价工单
//        if (model.getMessageType() == 1) {
//            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_pd);
//            viewHolderHelper.setText(R.id.tv_state, mContext.getResources().getString(R.string.text_state_pg));
//        } else if (model.getMessageType() == 2) {
//            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_jd);
//            viewHolderHelper.setText(R.id.tv_state, mContext.getResources().getString(R.string.text_state_jd));
//        } else if (model.getMessageType() == 3) {
//            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_sh);
//            viewHolderHelper.setText(R.id.tv_state, mContext.getResources().getString(R.string.text_state_wg));
//        } else if (model.getMessageType() == 4) {
//            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_wg);
//            viewHolderHelper.setText(R.id.tv_state, mContext.getResources().getString(R.string.text_state_cd));
//        } else if (model.getMessageType() == 5) {
//            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_dpj);
//            viewHolderHelper.setText(R.id.tv_state, mContext.getResources().getString(R.string.text_state_dpj));
//        } else {
//            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_yz);
//            viewHolderHelper.setText(R.id.tv_state, mContext.getResources().getString(R.string.text_state_yz));
//        }

        viewHolderHelper.getView(R.id.lly_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, WorkOrderDetailsActivity.class).putExtra(StrRes.INSTANCE.getId(), model.getBDID()));

                if (iMessageInfo == null)
                    iMessageInfo = new MessageInfoImpl();
                iMessageInfo.setMessageRead(mContext, new INetWorkCallBack() {
                    @Override
                    public void noNetWork() {
                    }

                    @Override
                    public void onError(int status, String str, Class cla, String constantUrl) {
                    }
                }, model.getBDID() + "");
            }
        });

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
