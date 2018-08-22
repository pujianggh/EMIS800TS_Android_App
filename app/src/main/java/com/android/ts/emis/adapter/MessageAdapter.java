package com.android.ts.emis.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.activity.work.PlanMaintainActivity;
import com.android.ts.emis.activity.work.PollingTaskActivity;
import com.android.ts.emis.activity.work.WorkOrderDetailsActivity;
import com.android.ts.emis.config.ConstantsResults;
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

        //工单已创建 0 派工
        //工单已派工 1 接单
        //工单待审批 2 审批
        //工单处理中 3 完工
        //工单暂停-继续 4 继续
        //工单暂停-待派工 5 派工
        //工单执行完成   6 验证
        //工单已验证 7 存档
        //工单已存档 8 评价
        //工单已关闭 9 查看详情
        //工单已作废 10 查看详情
        viewHolderHelper.setText(R.id.tv_state, ConstantsResults.getTicketsStatusText(model.getTicketsStatus()));
        if (model.getTicketsStatus() == 0) {
            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_pd);
        } else if (model.getTicketsStatus() == 1) {
            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_pd);
        } else if (model.getTicketsStatus() == 2) {
            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_jd);
        } else if (model.getTicketsStatus() == 3) {
            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_sh);
        } else if (model.getTicketsStatus() == 4) {
            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_wg);
        } else if (model.getTicketsStatus() == 5) {
            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_dpj);
        } else {
            viewHolderHelper.getImageView(R.id.igv_icon).setImageResource(R.drawable.icon_message_yz);
        }

        viewHolderHelper.getView(R.id.lly_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CM:维修工单;
                //PM:计划性维护工单;
                //IM:巡检工单
                if ("CM".equals(model.getMessageType())) {
                    mContext.startActivity(new Intent(mContext, WorkOrderDetailsActivity.class)
                            .putExtra(StrRes.INSTANCE.getTicketsCode(), model.getObjectCode()));
                } else if ("PM".equals(model.getMessageType())) {
                    mContext.startActivity(new Intent(mContext, PlanMaintainActivity.class));
                } else if ("IM".equals(model.getMessageType())) {
                    mContext.startActivity(new Intent(mContext, PollingTaskActivity.class));
                }

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
