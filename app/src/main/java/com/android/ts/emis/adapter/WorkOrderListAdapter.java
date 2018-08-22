package com.android.ts.emis.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.activity.work.WorkOrderDetailsActivity;
import com.android.ts.emis.config.ConstantsResults;
import com.android.ts.emis.mode.TicketInfoBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 工单列表（不同类型）
 *
 * @author pujiang
 * @date 2018-5-13 22:48
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderListAdapter extends CommonBaseAdapter<TicketInfoBean> {

    public WorkOrderListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_work_order_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final TicketInfoBean bean = data.get(position);
        if (viewHolder != null && bean != null) {
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
            viewHolder.tvOrderCode.setText(bean.getTicketsCode());
            viewHolder.tvOrderStatus.setText(bean.getPriorityName());
            viewHolder.tvState.setText(bean.getTicketsStatusName());
            viewHolder.tvState.setBackgroundResource(ConstantsResults.getTicketsStatusColor(bean.getTicketsStatus()));
            viewHolder.tvTicketsStatus.setText(ConstantsResults.getTicketsStatusText(bean.getTicketsStatus()));
            viewHolder.tvPfmCode.setText(bean.getPriorityCode());
            viewHolder.tvOrderDescribe.setText(bean.getTicketsDescription());
            viewHolder.tvCreateTime.setText(bean.getCreateDate());
            viewHolder.llyItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext, WorkOrderDetailsActivity.class)
                            .putExtra(StrRes.INSTANCE.getTicketsCode(), bean.getTicketsCode()));
                }
            });
        }
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.lly_item)
        LinearLayout llyItem;
        @BindView(R.id.tv_orderCode)
        TextView tvOrderCode;
        @BindView(R.id.tv_orderStatus)
        TextView tvOrderStatus;
        @BindView(R.id.tv_state)
        TextView tvState;
        @BindView(R.id.tv_pfmCode)
        TextView tvPfmCode;
        @BindView(R.id.tv_createTime)
        TextView tvCreateTime;
        @BindView(R.id.tv_orderDescribe)
        TextView tvOrderDescribe;
        @BindView(R.id.tv_ticketsStatus)
        TextView tvTicketsStatus;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
