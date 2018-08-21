package com.android.ts.emis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.mode.SelectInfoBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 不同类型选择
 *
 * @author pujiang
 * @date 2018-5-13 22:48
 * @mail 515210530@qq.com
 * @Description:
 */
public class SelectQueryListAdapter extends CommonBaseAdapter<SelectInfoBean.Data> {

    public SelectQueryListAdapter(Context context) {
        super(context);
    }

    public void setItemChecked(int position) {
        int size = data.size();
        for (int i = 0; i < size; i++) {
            data.get(i).setChecked(false);
        }
        data.get(position).setChecked(true);
        notifyDataSetChanged();
    }

    public void setItemChecked(String name) {
        int size = data.size();
        for (int i = 0; i < size; i++) {
            data.get(i).setChecked(false);
            if (name.equals(data.get(i).getName())) {
                data.get(i).setChecked(true);
            }
        }
        notifyDataSetChanged();
    }

    public SelectInfoBean.Data getItemChecked() {
        int size = data.size();
        for (int i = 0; i < size; i++) {
            if (data.get(i).isChecked()) {
                return data.get(i);
            }
        }
        return null;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_select_query_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final SelectInfoBean.Data bean = data.get(position);
        if (viewHolder != null && bean != null) {
            viewHolder.tvName.setText(bean.getName());
            viewHolder.igvIcon.setVisibility(View.GONE);
            if (bean.isChecked()) {
                viewHolder.igvIcon.setVisibility(View.VISIBLE);
            }
            viewHolder.llyItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setItemChecked(position);
                }
            });
        }
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.igv_icon)
        ImageView igvIcon;
        @BindView(R.id.lly_item)
        LinearLayout llyItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
