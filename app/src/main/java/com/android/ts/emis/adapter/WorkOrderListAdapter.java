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
import com.android.ts.emis.mode.WorkOrderListBean;

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
public class WorkOrderListAdapter extends CommonBaseAdapter<WorkOrderListBean.Data> {

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
        final WorkOrderListBean.Data bean = data.get(position);
        if (viewHolder != null && bean != null) {
            //1：待处理工单 2：待派批工单（待派工) 3：待审批工单 4：待存档工单 5：待评价工单
            viewHolder.tvOrderCode.setText(bean.getOrderCode());
            viewHolder.tvOrderStatus.setText(bean.getOrderStatus());
            if (1 == bean.getType()) {
                viewHolder.tvState.setText("处理中");
                viewHolder.tvState.setBackgroundResource(R.color.text_brown);
            } else if (2 == bean.getType()) {
                viewHolder.tvState.setText("已创建");
                viewHolder.tvState.setBackgroundResource(R.color.text_brown);
            } else if (3 == bean.getType()) {
                viewHolder.tvState.setText("待审批");
                viewHolder.tvState.setBackgroundResource(R.color.red_text);
            } else if (4 == bean.getType()) {
                viewHolder.tvState.setText("完成");
                viewHolder.tvState.setBackgroundResource(R.color.text_blue);
            } else if (5 == bean.getType()) {
                viewHolder.tvState.setText("可评价");
                viewHolder.tvState.setBackgroundResource(R.color.color_orange);
            }
            viewHolder.tvPfmCode.setText(bean.getPfmCode());
            viewHolder.tvOrderDescribe.setText(bean.getOrderDescribe());
            viewHolder.tvCreateTime.setText(bean.getCreateTime());
            viewHolder.llyItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext, WorkOrderDetailsActivity.class).putExtra(StrRes.INSTANCE.getId(), bean.getId()));
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
