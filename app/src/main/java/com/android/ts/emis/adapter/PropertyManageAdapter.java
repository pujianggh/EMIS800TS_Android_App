package com.android.ts.emis.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.activity.work.PropertyManageDetailsActivity;
import com.android.ts.emis.mode.PropertyManageBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 资产列表
 *
 * @author pujiang
 * @date 2018-5-13 22:48
 * @mail 515210530@qq.com
 * @Description:
 */
public class PropertyManageAdapter extends CommonBaseAdapter<PropertyManageBean.Data> {

    public PropertyManageAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_property_manage, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final PropertyManageBean.Data bean = data.get(position);
        if (viewHolder != null && bean != null) {
            viewHolder.tvMessage.setText(bean.getMessage());
            viewHolder.tvState.setText("在用");
            viewHolder.tvSystemClass.setText(bean.getSystemClass());
            viewHolder.tvInstalLosition.setText(bean.getInstalLosition());
            viewHolder.llyItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext, PropertyManageDetailsActivity.class));
                }
            });
        }
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.lly_item)
        LinearLayout llyItem;
        @BindView(R.id.tv_message)
        TextView tvMessage;
        @BindView(R.id.tv_state)
        TextView tvState;
        @BindView(R.id.tv_systemClass)
        TextView tvSystemClass;
        @BindView(R.id.tv_instalLosition)
        TextView tvInstalLosition;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
