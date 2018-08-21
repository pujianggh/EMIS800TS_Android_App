package com.android.ts.emis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.mode.PollingInfoListBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 巡检信息查询列表
 *
 * @author pujiang
 * @date 2018-5-13 22:48
 * @mail 515210530@qq.com
 * @Description:
 */
public class PollInfoQueryListAdapter extends CommonBaseAdapter<PollingInfoListBean.Data> {

    public PollInfoQueryListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_pollinfo_query_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PollingInfoListBean.Data bean = data.get(position);
        if (viewHolder != null && bean != null) {
            viewHolder.tvPollName.setText(bean.getPollName());
            viewHolder.tvPollStartTime.setText(bean.getPollStartTime());
            viewHolder.tvPollEndTime.setText(bean.getPollEndTime());
            viewHolder.tvPolLocation.setText(bean.getPollocation());
            viewHolder.tvPollPersonnel.setText(bean.getPollocation());
            if ("0".equals(bean.getPollStatus())) {
                viewHolder.tvState.setText("处理中");
            } else if ("1".equals(bean.getPollStatus())) {
                viewHolder.tvState.setText("暂停");
            } else if ("2".equals(bean.getPollStatus())) {
                viewHolder.tvState.setText("待处理");
            } else {
                viewHolder.tvState.setText("完成");
            }
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
        @BindView(R.id.rly_goLook)
        RelativeLayout rlyGoLook;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
