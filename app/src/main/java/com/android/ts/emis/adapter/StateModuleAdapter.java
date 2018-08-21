package com.android.ts.emis.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.listeners.OnRcyclerItemClickListener;
import com.android.ts.emis.mode.StateInfoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 状态选择模块
 *
 * @author pujiang
 * @date 2018-5-4 15:10
 * @mail 515210530@qq.com
 * @Description:
 */
public class StateModuleAdapter extends RecyclerView.Adapter<StateModuleAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<StateInfoBean.Data> mDatas = new ArrayList<>();
    private OnRcyclerItemClickListener<StateInfoBean.Data> onRcyclerItemClickListener;

    public StateModuleAdapter(Context context, List<StateInfoBean.Data> datas) {
        this.mContext = context;
        this.mDatas = datas;
        mInflater = LayoutInflater.from(context);
    }

    public void setItemClick(int position) {
        if (mDatas.get(position).isChecked()) {
            mDatas.get(position).setChecked(false);
        } else {
            mDatas.get(position).setChecked(true);
        }
        notifyDataSetChanged();
    }

    public void setItemCheckedOne() {
        if (getItemCount() > 0)
            mDatas.get(0).setChecked(false);
        notifyDataSetChanged();
    }

    public void setItemAllNoChecked() {
        for (int i = 0; i < mDatas.size(); i++) {
            mDatas.get(i).setChecked(false);
            if (i == 0) {
                mDatas.get(i).setChecked(true);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.item_state_module, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final StateInfoBean.Data mode = mDatas.get(position);
        if (holder != null && mode != null) {
            holder.tvName.setText(mode.getName());
            holder.llyItem.setSelected(mode.isChecked());
            holder.tvName.setSelected(mode.isChecked());
            holder.igvIcon.setVisibility(View.GONE);
            if (mode.isChecked()) {
                holder.igvIcon.setVisibility(View.VISIBLE);
            }
            holder.llyItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position == 0) {
                        setItemAllNoChecked();
                        return;
                    }
                    setItemCheckedOne();
                    onRcyclerItemClickListener.onItemClick(holder.llyItem, position, mode);
                }
            });
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.igv_icon)
        ImageView igvIcon;
        @BindView(R.id.lly_item)
        LinearLayout llyItem;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setOnItemClickListener(OnRcyclerItemClickListener onItemClickListener) {
        onRcyclerItemClickListener = onItemClickListener;
    }
}
