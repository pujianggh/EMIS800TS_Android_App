package com.android.ts.emis.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.activity.common.QRCodeActivity;
import com.android.ts.emis.activity.work.PollingTaskDetailsActivity;
import com.android.ts.emis.config.RequestCode;
import com.android.ts.emis.mode.PollingInfoListBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 巡检任务列表
 *
 * @author pujiang
 * @date 2018-5-13 22:48
 * @mail 515210530@qq.com
 * @Description:
 */
public class PollTaskDetailsAdapter extends CommonBaseAdapter<PollingInfoListBean.Data> {

    public PollTaskDetailsAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_polltask_details, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final PollingInfoListBean.Data bean = data.get(position);
        if (viewHolder != null && bean != null) {
            viewHolder.tvPollName.setText(bean.getPollName());
            viewHolder.tvPolLocation.setText("1");
            viewHolder.tvPollPersonnel.setText(bean.getPollocation());
            viewHolder.tvPollDevice.setText(bean.getPollDevice());
            viewHolder.tvLocation.setText(bean.getLocation());
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
                    ((PollingTaskDetailsActivity) mContext).startActivityForResult(new Intent(mContext, QRCodeActivity.class), RequestCode.INSTANCE.getResult_QRCode());
                }
            });
        }
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.tv_location)
        TextView tvLocation;
        @BindView(R.id.tv_pollPersonnel)
        TextView tvPollPersonnel;
        @BindView(R.id.tv_pollDevice)
        TextView tvPollDevice;
        @BindView(R.id.tv_pollLocation)
        TextView tvPolLocation;
        @BindView(R.id.tv_state)
        TextView tvState;
        @BindView(R.id.tv_pollName)
        TextView tvPollName;
        @BindView(R.id.lly_item)
        LinearLayout llyItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
