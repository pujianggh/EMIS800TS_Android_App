package com.android.ts.emis.utils;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.ts.emis.adapter.ImageViewAdapter;
import com.android.ts.emis.handle.RecycleViewDivider;

import java.util.List;

/**
 * UI渲染工具类
 *
 * @author pujiang
 * @date 2017-9-4 14:40
 * @mail 515210530@qq.com
 * @Description:
 */
public class UIViewToolsUtil {

    /**
     * 图片数据初始化
     *
     * @param context
     * @param datas
     * @param rlvPhotos
     */
    public static void initUIPhotosData(Context context, List<String> datas, RecyclerView rlvPhotos, int photoNum) {
        rlvPhotos.setVisibility(View.GONE);
        if (datas == null) return;
        if (datas.size() == 0) return;
        if (photoNum <= 0) return;
        rlvPhotos.setVisibility(View.VISIBLE);
        GridLayoutManager layoutManager = new GridLayoutManager(context, photoNum);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlvPhotos.setLayoutManager(layoutManager);
        rlvPhotos.addItemDecoration(new RecycleViewDivider(context));
        ImageViewAdapter adapter = new ImageViewAdapter(context, datas);
        rlvPhotos.setAdapter(adapter);
    }
}
