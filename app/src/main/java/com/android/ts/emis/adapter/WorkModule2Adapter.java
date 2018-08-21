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

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.activity.work.PollingQueryActivity;
import com.android.ts.emis.activity.work.PollingTaskActivity;
import com.android.ts.emis.activity.work.WorkOrderCreateActivity;
import com.android.ts.emis.activity.work.WorkOrderListActivity;
import com.android.ts.emis.activity.work.WorkOrderQueryListActivity;
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
public class WorkModule2Adapter extends RecyclerView.Adapter<WorkModule2Adapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<WorkModuleBean.BodyBean> mDatas;

    public WorkModule2Adapter(Context context, List<WorkModuleBean.BodyBean> datas) {
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
        return new ViewHolder(mInflater.inflate(R.layout.item_work_module2, parent, false));
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
                //工作-巡检
                case 20001:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_xjrw);
                    break;
                case 20002:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_gdcx);
                    break;
                //工作-工单
                case 30001:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_cjgd);
                    break;
                case 30002:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_dclgd);
                    break;
                case 30003:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_dpggd);
                    break;
                case 30004:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_dspgd);
                    break;
                case 30005:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_dcdgd);
                    break;
                case 30006:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_dspgd);
                    break;
                case 30008:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_gdcx);
                    break;
                //工作-库存
                case 50001:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_rk);
                    break;
                case 50002:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_ck);
                    break;
                case 50003:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_yk);
                    break;
                case 50004:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_pd);
                    break;
                case 50005:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_wzyd);
                    break;
                case 50008:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_wdyd);
                    break;
                case 50009:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_kcsh);
                    break;
                case 50010:
                    holder.igvIcon.setImageResource(R.drawable.icon_home_work_cx);
                    break;
            }
            holder.llyItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (mode.getWorkCode()) {
                        //工作-巡检
                        case 20001://巡检任务
                            mContext.startActivity(new Intent(mContext, PollingTaskActivity.class));
                            break;
                        case 20002://巡检查询
                            mContext.startActivity(new Intent(mContext, PollingQueryActivity.class));
                            break;
                        //工作-工单
                        case 30001://创建工单
                            mContext.startActivity(new Intent(mContext, WorkOrderCreateActivity.class));
                            break;
                        case 30002://待处理工单
                        case 30003://待派批工单
                        case 30004://待审批工单
                        case 30005://待存档工单
                        case 30006://待评价工单
                            mContext.startActivity(new Intent(mContext, WorkOrderListActivity.class).putExtra(StrRes.INSTANCE.getType(), mode.getWorkCode()));
                            break;
                        case 30008://工单查询
                            mContext.startActivity(new Intent(mContext, WorkOrderQueryListActivity.class));
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
