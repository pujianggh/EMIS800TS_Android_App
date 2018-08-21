package com.android.ts.emis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.activity.work.StateQueryListActivity;
import com.android.ts.emis.mode.StateInfoBean;

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
public class StateQueryListAdapter extends CommonBaseAdapter<StateInfoBean.Data> {

    public StateQueryListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_state_query_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final StateInfoBean.Data bean = data.get(position);
        if (viewHolder != null && bean != null) {
            viewHolder.tvName.setText(bean.getName());
            viewHolder.igvIcon.setVisibility(View.GONE);
            if (bean.getData() != null) {
                viewHolder.igvIcon.setVisibility(View.VISIBLE);
            }
            viewHolder.llyItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((StateQueryListActivity) mContext).setSourceTitleData(bean);
                    if (bean.getData() == null) {
                        ((StateQueryListActivity) mContext).finishBackData(bean, true);
                        return;
                    }
                    setData(bean.getData());
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
