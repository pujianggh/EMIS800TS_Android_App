package com.android.ts.emis.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.activity.work.PlanMaintainActivity;
import com.android.ts.emis.activity.work.PropertyManageActivity;
import com.android.ts.emis.activity.work.WorkOrderActivity;
import com.android.ts.emis.activity.work.WorkPollingActivity;
import com.android.ts.emis.activity.work.WorkRepertoryActivity;
import com.android.ts.emis.mode.WorkModuleBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 工作模块信息
 *
 * @author pujiang
 * @date 2018-5-4 15:10
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkModuleAdapter extends RecyclerView.Adapter<WorkModuleAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<WorkModuleBean.BodyBean> mDatas;

    public WorkModuleAdapter(Context context, List<WorkModuleBean.BodyBean> datas) {
        this.mContext = context;
        this.mDatas = datas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.item_work_module, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final WorkModuleBean.BodyBean mode = mDatas.get(position);
        if (holder != null && mode != null) {
            holder.tvName.setText(mode.getName());
            if (mode.getCount() > 0) {
                holder.tvCount.setVisibility(View.VISIBLE);
                holder.tvCount.setText(mode.getCount() + "");
            }

            switch (mode.getWorkCode()) {
                //工作-模块
                case 10001:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_gdrw);
                    break;
                case 10002:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_gdrw);
                    break;
                case 10003:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_xjrw);
                    break;
                case 10004:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_xcsl);
                    break;
                case 10005:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_jhxwh);
                    break;
                case 10006:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_ckwl);
                    break;
                case 10007:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_nygl);
                    break;
                case 10008:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_zcgl);
                    break;
                case 10009:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_ckbb);
                    break;
            }
            holder.llyItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (mode.getWorkCode()) {
                        //工作-模块
                        case 10002://工单任务
                            mContext.startActivity(new Intent(mContext, WorkOrderActivity.class));
                            break;
                        case 10003://巡检任务
                            mContext.startActivity(new Intent(mContext, WorkPollingActivity.class));
                            break;
                        case 10005://计划性维护
                            mContext.startActivity(new Intent(mContext, PlanMaintainActivity.class));
                            break;
                        case 10008://资产管理
                            mContext.startActivity(new Intent(mContext, PropertyManageActivity.class));
                            break;
                        case 10006://厂库材料
                            mContext.startActivity(new Intent(mContext, WorkRepertoryActivity.class));
                            break;
                    }
                }
            });
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_count)
        TextView tvCount;
        @BindView(R.id.igv_icon)
        ImageView igvIcon;
        @BindView(R.id.lly_item)
        LinearLayout llyItem;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
