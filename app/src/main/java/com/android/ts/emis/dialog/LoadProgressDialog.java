package com.android.ts.emis.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ts.emis.R;

/**
 * @author pujiang
 * @date 2018/8/16 14:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class LoadProgressDialog {

    /**
     * 展示加载数据
     *
     * @param context
     * @return
     */
    public static Dialog showProgressDialog(Context context) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_loading);
        LinearInterpolator lin = new LinearInterpolator();//设置动画匀速运动
        animation.setInterpolator(lin);
        Dialog dialog = new Dialog(context, R.style.Dialog_Loading);
        View view = View.inflate(context, R.layout.layout_loading, null);
        ImageView img = (ImageView) view.findViewById(R.id.iv_loading_img);
        img.startAnimation(animation);
        img.setImageResource(R.drawable.loading);
        dialog.setContentView(view);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }


    /**
     * 进度展示对话框
     *
     * @param context
     * @param message
     * @return
     */
    public static Dialog showProgressDialog(Context context, String message) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_loading);
        LinearInterpolator lin = new LinearInterpolator();//设置动画匀速运动
        animation.setInterpolator(lin);
        Dialog dialog = new Dialog(context, R.style.Dialog_Progress);
        View view = View.inflate(context, R.layout.layout_progress, null);
        ImageView img = (ImageView) view.findViewById(R.id.iv_loading_img);
        TextView text = (TextView) view.findViewById(R.id.tv_loading_text);
        text.setText(message);
        img.startAnimation(animation);
        dialog.setContentView(view);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }
}
