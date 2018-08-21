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
import com.android.ts.emis.activity.work.PlanMaintainDetailsActivity;
import com.android.ts.emis.mode.PlanMaintainListBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 计划性维护
 *
 * @author pujiang
 * @date 2018-5-13 22:48
 * @mail 515210530@qq.com
 * @Description:
 */
public class PlanMaintainListAdapter extends CommonBaseAdapter<PlanMaintainListBean.Data> {

    public PlanMaintainListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_plan_maintain_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final PlanMaintainListBean.Data bean = data.get(position);
        if (viewHolder != null && bean != null) {
            viewHolder.tvPollName.setText(bean.getPollName());
            viewHolder.tvPollStartTime.setText(bean.getPollStartTime());
            viewHolder.tvPollEndTime.setText(bean.getPollEndTime());
            viewHolder.tvPolLocation.setText("1个");
            viewHolder.tvPollDevice.setText(bean.getPollDevice() + "个");
            if ("0".equals(bean.getPollStatus())) {
                viewHolder.tvState.setText("处理中");
            } else if ("1".equals(bean.getPollStatus())) {
                viewHolder.tvState.setText("暂停");
            } else if ("2".equals(bean.getPollStatus())) {
                viewHolder.tvState.setText("待处理");
            } else {
                viewHolder.tvState.setText("完成");
            }
            viewHolder.llyItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext, PlanMaintainDetailsActivity.class).putExtra(StrRes.INSTANCE.getId(), bean.getId() + ""));
                }
            });
        }
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.tv_pollName)
        TextView tvPollName;
        @BindView(R.id.tv_state)
        TextView tvState;
        @BindView(R.id.tv_pollPersonnel)
        TextView tvPollPersonnel;
        @BindView(R.id.tv_pollStartTime)
        TextView tvPollStartTime;
        @BindView(R.id.tv_pollEndTime)
        TextView tvPollEndTime;
        @BindView(R.id.tv_pollLocation)
        TextView tvPolLocation;
        @BindView(R.id.tv_pollDevice)
        TextView tvPollDevice;
        @BindView(R.id.lly_item)
        LinearLayout llyItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
