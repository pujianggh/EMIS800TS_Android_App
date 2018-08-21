package com.android.ts.emis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.mode.PlanMaintainDetailStepBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 计划性维护详情-步骤
 *
 * @author pujiang
 * @date 2018-5-13 22:48
 * @mail 515210530@qq.com
 * @Description:
 */
public class PlanMaintainDetailStepAdapter extends CommonBaseAdapter<PlanMaintainDetailStepBean.Data> {

    public PlanMaintainDetailStepAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_plan_maintain_detailstep, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final PlanMaintainDetailStepBean.Data bean = data.get(position);
        if (viewHolder != null && bean != null) {
            viewHolder.tvIndex.setText((position + 1) + "");
            viewHolder.tvStepName.setText(bean.getWorkGroupName());
            viewHolder.tvStepContent.setText(bean.getPlanContent());
        }
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.lly_item)
        LinearLayout llyItem;
        @BindView(R.id.tv_index)
        TextView tvIndex;
        @BindView(R.id.tv_stepName)
        TextView tvStepName;
        @BindView(R.id.tv_stepContent)
        TextView tvStepContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
