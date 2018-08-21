package com.android.ts.emis.listeners;

import android.view.View;

/**
 * RecyclerView点击事件监听
 *
 * @author pujiang
 * @date 2018-5-25 15:38
 * @mail 515210530@qq.com
 * @Description:
 */
public interface OnRcyclerItemClickListener<T> {

    void onItemClick(View view, int position, T mode);

}
