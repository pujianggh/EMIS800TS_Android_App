package com.android.ts.emis.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.ts.emis.R;

/**
 * PopupWindow管理
 *
 * @author pujiang
 * @date 2018-6-9 18:00
 * @mail 515210530@qq.com
 * @Description:
 */
public class PopupWindowUtil {
    private Context mContext;

    public PopupWindowUtil(Context context) {
        this.mContext = context;
    }

    //选择
    public interface OnPopuwindowClick {
        void onPopuwindowClick(int id);
    }

    //选择
    public interface OnPopuwindowClickInput {
        void onPopuwindowClick(int id, String message);
    }

    /**
     * 展示验证内容
     */
    public void showInputerifyWindow() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.window_set_connectset, null);
        final EditText edtURL = (EditText) view.findViewById(R.id.edt_URL);
        final Button btnCancel = (Button) view.findViewById(R.id.btn_cancel);
        final Button btnConfirm = (Button) view.findViewById(R.id.btn_confirm);
        final PopupWindow popupWindow = new PopupWindow(mContext);
        popupWindow.setContentView(view);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        backgroundAlpha(0.2f);
        popupWindow.setAnimationStyle(R.style.Animal_Popuwindow_EnterOrExit);
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
        popupWindow.showAsDropDown(view);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    /**
     * 计划性维护详情
     *
     * @param locationView
     * @param popuwindowClick
     */
    public void showPlanMaintainDetailsWindow(View locationView, final OnPopuwindowClick popuwindowClick) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.window_plan_maintain, null);
        final ImageView igvDx = (ImageView) view.findViewById(R.id.igv_dx);
        final ImageView igvWxgd = (ImageView) view.findViewById(R.id.igv_wxgd);
        final LinearLayout llyRoot = (LinearLayout) view.findViewById(R.id.lly_window_root);
        final PopupWindow popupWindow = new PopupWindow(mContext);
        popupWindow.setContentView(view);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        backgroundAlpha(0.2f);
        popupWindow.setAnimationStyle(R.style.Animal_Popuwindow_EnterOrExit);
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.showAtLocation(locationView, Gravity.BOTTOM, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
        igvDx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
        igvWxgd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
    }

    /**
     * 展示设置连接地址
     */
    public void showSetConnectURLWindow() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.window_set_connectset, null);
        final EditText edtURL = (EditText) view.findViewById(R.id.edt_URL);
        final Button btnCancel = (Button) view.findViewById(R.id.btn_cancel);
        final Button btnConfirm = (Button) view.findViewById(R.id.btn_confirm);
        final PopupWindow popupWindow = new PopupWindow(mContext);
        popupWindow.setContentView(view);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        backgroundAlpha(0.2f);
        popupWindow.setAnimationStyle(R.style.Animal_Popuwindow_EnterOrExit);
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
        popupWindow.showAsDropDown(view);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    /**
     * 工单详细菜单
     *
     * @param locationView
     * @param popuwindowClick
     */
    public void showWorkOrderAcceptWindow(View locationView, final OnPopuwindowClick popuwindowClick) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.window_workorder_accept, null);
        final LinearLayout lly_table1 = (LinearLayout) view.findViewById(R.id.lly_table1);
        final LinearLayout lly_table2 = (LinearLayout) view.findViewById(R.id.lly_table2);
        final LinearLayout lly_table3 = (LinearLayout) view.findViewById(R.id.lly_table3);
        final LinearLayout lly_table4 = (LinearLayout) view.findViewById(R.id.lly_table4);
        final LinearLayout lly_table5 = (LinearLayout) view.findViewById(R.id.lly_table5);
        final PopupWindow popupWindow = new PopupWindow(mContext);
        popupWindow.setContentView(view);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        backgroundAlpha(0.2f);
        popupWindow.setAnimationStyle(R.style.Animal_Popuwindow_EnterOrExit);
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.showAsDropDown(locationView);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
        lly_table1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
        lly_table2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
        lly_table3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
        lly_table4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
        lly_table5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    /**
     * 工单详细菜单
     *
     * @param locationView
     * @param popuwindowClick
     */
    public void showWorkOrderCLZWindow(View locationView, final OnPopuwindowClick popuwindowClick) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.window_workorder_clz, null);
        final LinearLayout lly_table1 = (LinearLayout) view.findViewById(R.id.lly_table1);
        final LinearLayout lly_table2 = (LinearLayout) view.findViewById(R.id.lly_table2);
        final LinearLayout lly_table3 = (LinearLayout) view.findViewById(R.id.lly_table3);
        final LinearLayout lly_table4 = (LinearLayout) view.findViewById(R.id.lly_table4);
        final LinearLayout lly_table5 = (LinearLayout) view.findViewById(R.id.lly_table5);
        final LinearLayout lly_table6 = (LinearLayout) view.findViewById(R.id.lly_table6);
        final PopupWindow popupWindow = new PopupWindow(mContext);
        popupWindow.setContentView(view);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        backgroundAlpha(0.2f);
        popupWindow.setAnimationStyle(R.style.Animal_Popuwindow_EnterOrExit);
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.showAsDropDown(locationView);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
        lly_table1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
        lly_table2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
        lly_table3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
        lly_table4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
        lly_table5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
        lly_table6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    /**
     * 创建工单对话框展示
     *
     * @param locationView
     * @param popuwindowClick
     */
    public void showWorkOrderCreateWindow(View locationView, final OnPopuwindowClick popuwindowClick) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.window_workorder_select, null);
        final ImageView igvAdd = (ImageView) view.findViewById(R.id.igv_add);
        final ImageView igvEwm = (ImageView) view.findViewById(R.id.igv_ewm);
        final LinearLayout llyRoot = (LinearLayout) view.findViewById(R.id.lly_window_root);
        final PopupWindow popupWindow = new PopupWindow(mContext);
        popupWindow.setContentView(view);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        backgroundAlpha(0.2f);
        popupWindow.setAnimationStyle(R.style.Animal_Popuwindow_EnterOrExit);
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.showAsDropDown(locationView);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
        igvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
        igvEwm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClick.onPopuwindowClick(v.getId());
            }
        });
    }

    /**
     * 退单工单
     *
     * @param locationView
     * @param popuwindowClickInput
     */
    public void showTDGDWorkOrderWindow(View locationView, String title, String inputText, String buttonText0, String buttonText, int count, final OnPopuwindowClickInput popuwindowClickInput) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.window_workorder_tdgd, null);
        final TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        final EditText edt_content = (EditText) view.findViewById(R.id.edt_content);
        final Button btn_next = (Button) view.findViewById(R.id.btn_next);
        final Button btn_next0 = (Button) view.findViewById(R.id.btn_next0);
        final PopupWindow popupWindow = new PopupWindow(mContext);
        popupWindow.setContentView(view);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        backgroundAlpha(0.2f);
        popupWindow.setAnimationStyle(R.style.Animal_Popuwindow_EnterOrExit);
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.showAsDropDown(locationView);

        btn_next0.setVisibility(View.GONE);
        if (count == 2) {
            btn_next0.setVisibility(View.VISIBLE);
            btn_next0.setText(buttonText0);
        }
        if (!TextUtils.isEmpty(title)) tv_title.setText(title);
        if (!TextUtils.isEmpty(inputText)) edt_content.setHint(inputText);
        if (!TextUtils.isEmpty(buttonText)) btn_next.setText(buttonText);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClickInput.onPopuwindowClick(v.getId(), edt_content.getText().toString());
            }
        });
        btn_next0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                popuwindowClickInput.onPopuwindowClick(v.getId(), edt_content.getText().toString());
            }
        });
    }


    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    private void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity) mContext).getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        ((Activity) mContext).getWindow().setAttributes(lp);
    }
}
