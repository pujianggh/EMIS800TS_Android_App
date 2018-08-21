package com.android.ts.emis.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.ts.emis.R;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 图片展示
 *
 * @author pujiang
 * @date 2018-5-4 15:10
 * @mail 515210530@qq.com
 * @Description:
 */
public class ImageViewAdapter extends RecyclerView.Adapter<ImageViewAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<String> mDatas;

    public ImageViewAdapter(Context context, List<String> datas) {
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
        return new ViewHolder(mInflater.inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String url = mDatas.get(position);
        if (holder != null && !TextUtils.isEmpty(url)) {
            Glide.with(mContext).load(url).into(holder.igvIcon);
            holder.igvIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.igv_icon)
        ImageView igvIcon;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
