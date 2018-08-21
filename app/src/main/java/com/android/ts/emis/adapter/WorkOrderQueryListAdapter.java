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
import com.android.ts.emis.mode.TicketInfoBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 工单查询列表
 *
 * @author pujiang
 * @date 2018-5-13 22:48
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkOrderQueryListAdapter extends CommonBaseAdapter<TicketInfoBean> {

    public WorkOrderQueryListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_work_order_query_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final TicketInfoBean bean = data.get(position);
        if (viewHolder != null && bean != null) {
            viewHolder.tvOrderCode.setText(bean.getTicketsCode());
            viewHolder.tvState.setText(bean.getTicketsStatusName());
            viewHolder.tvPfmCode.setText(bean.getPriorityCode());
            viewHolder.tvOrderDescribe.setText(bean.getTicketsDescription());
            viewHolder.tvCreateTime.setText(bean.getCreateDate());
            viewHolder.llyItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext, WorkOrderDetailsActivity.class)
                            .putExtra(StrRes.INSTANCE.getTicketsCode(), bean.getTicketsCode())
                            .putExtra(StrRes.INSTANCE.getTitle(), bean.getTicketsCode()));
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

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
