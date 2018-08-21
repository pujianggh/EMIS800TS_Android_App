package com.android.ts.emis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.mode.HouseListBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目信息选择
 *
 * @author pujiang
 * @date 2018-5-13 22:48
 * @mail 515210530@qq.com
 * @Description:
 */
public class ProjectMessageAdapter extends CommonBaseAdapter<HouseListBean> {

    public ProjectMessageAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_project_message, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        HouseListBean bean = data.get(position);
        if (viewHolder != null && bean != null) {
            viewHolder.tvName.setText(bean.getHouseName());

            // 这里不知道当前图片的尺寸，加载成功后会乱跳
//            if (!TextUtils.isEmpty(bean.getImgeURL()) && bean.getImgeURL().startsWith("http")) {
//                Glide.with(mContext).load(bean.getImgeURL())
//                        .placeholder(R.drawable.ic_project_message_default)
//                        .error(R.drawable.ic_project_message_default)
//                        .dontAnimate()
//                        .into(viewHolder.igvIcon);
//            }
            viewHolder.tvSate.setText("混合");
            viewHolder.tvSign.setVisibility(View.GONE);
//            if (position == 0) {
//                viewHolder.tvSign.setText("J");
//                viewHolder.tvSign.setVisibility(View.VISIBLE);
//            } else if (position == 1) {
//                viewHolder.tvSign.setText("S");
//                viewHolder.tvSign.setVisibility(View.VISIBLE);
//            } else if (position == 2) {
//                viewHolder.tvSign.setText("Q");
//                viewHolder.tvSign.setVisibility(View.VISIBLE);
//            } else if (position == 4) {
//                viewHolder.tvSign.setText("x");
//                viewHolder.tvSign.setVisibility(View.VISIBLE);
//            }

            viewHolder.tvMessageCount.setVisibility(View.INVISIBLE);
            if (bean.getUnreadCount() > 0) {
                viewHolder.tvMessageCount.setText(" " + bean.getUnreadCount() + " ");
                if (bean.getUnreadCount() > 99) {
                    viewHolder.tvMessageCount.setText(" 99+ ");
                }
                viewHolder.tvMessageCount.setVisibility(View.VISIBLE);
            } else {
                viewHolder.tvMessageCount.setVisibility(View.INVISIBLE);
            }
        }
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_state)
        TextView tvSate;
        @BindView(R.id.tv_message_count)
        TextView tvMessageCount;
        @BindView(R.id.tv_sign)
        TextView tvSign;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
