package com.android.ts.emis.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ts.emis.R;
import com.android.ts.emis.app.APPApplication;
import com.android.ts.emis.dialog.LoadProgressDialog;
import com.android.ts.emis.mode.UserPasswordBean;
import com.android.ts.emis.mvp.view.IParentView;
import com.android.ts.emis.utils.NavigationBarUtil;
import com.android.ts.emis.utils.SPUtil;
import com.libcommon.action.base.CommonBaseSwipeBackActivity;
import com.libcommon.action.utils.LanguageUtil;

import cn.bingoogolapple.sweetaction.SweetAlertDialog;
import cn.bingoogolapple.titlebar.BGATitleBar;

/**
 * Activity基类：
 *
 * @author pujiang
 * @date 2018-1-18 10:02
 * @mail 515210530@qq.com
 * @Description:
 */
public abstract class BaseActivity extends CommonBaseSwipeBackActivity implements IParentView {
    protected BaseActivity mContext;
    protected APPApplication mAPPApplication;
    private SweetAlertDialog mLoadingDialog;
    protected BGATitleBar mTitleBar;
    private LinearLayout mTitleBarLayer;
    protected UserPasswordBean mUserPasswrd = new UserPasswordBean();

    protected Dialog mLoading;
    protected Dialog mProgressDialog;

    protected int mPage = 1, mSize = 10, mTotalPage = 1;

    @Override
    public boolean isSupportSwipeBack() {
        if (NavigationBarUtil.checkDeviceHasNavigationBar(this)) {
            return false;
        }
        return true;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LanguageUtil.setAPPLanguage(base));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAPPApplication = APPApplication.getInstance();
        mContext = this;
        mUserPasswrd = SPUtil.INSTANCE.getAllModle(mAPPApplication, mUserPasswrd);

        initView(savedInstanceState);
    }

    /**
     * 设置Title
     *
     * @param title
     * @param isUse
     */
    protected void setTitleBarLayout(CharSequence title, boolean isUse) {
        initTitleBarLayout(title, null, null, isUse);
    }

    /**
     * 设置Title样式
     *
     * @param leftDrawable
     * @param title
     * @param leftText
     * @param isUse
     */
    protected void setTitleBarLayout(int leftDrawable, String title, String leftText, boolean isUse) {
        setTitleBarLayout(title, isUse);
        mTitleBar.setLeftDrawable(leftDrawable);
        mTitleBar.getLeftCtv().setTextSize(18);
        if (!TextUtils.isEmpty(leftText))
            mTitleBar.setLeftText(leftText);
    }

    /**
     * 设置Title样式
     *
     * @param leftDrawable
     * @param title
     * @param leftText
     * @param isUse
     */
    protected void setTitleBarLayout(int leftDrawable, String title, String leftText, String rightText, boolean isUse) {
        setTitleBarLayout(leftDrawable, title, leftText, isUse);
        if (!TextUtils.isEmpty(rightText)) {
            mTitleBar.getRightCtv().setText(rightText);
            mTitleBar.getRightCtv().setTextSize(14);
            mTitleBar.getRightCtv().setVisibility(View.VISIBLE);
        }
    }

    /**
     * 初始化布局以及View控件
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化-设置Title
     *
     * @param title
     * @param left
     * @param right
     * @param isUse
     */
    private void initTitleBarLayout(CharSequence title, CharSequence left, CharSequence right, boolean isUse) {
        mTitleBarLayer = (LinearLayout) findViewById(R.id.layout_titleBar);
        mTitleBar = (BGATitleBar) findViewById(R.id.titleBar);
        if (null == mTitleBarLayer || null == mTitleBar) return;
        if (!isUse) mTitleBarLayer.setVisibility(View.GONE);
        if (!TextUtils.isEmpty(title)) {
            mTitleBar.setTitleText(title);
        }
        if (!TextUtils.isEmpty(left)) {
            mTitleBar.setLeftText(left);
        }
        if (!TextUtils.isEmpty(right)) {
            mTitleBar.setRightText(right);
        }
        mTitleBar.setDelegate(new BGATitleBar.Delegate() {
            @Override
            public void onClickLeftCtv() {
                onBackPressed();//finish();
            }

            @Override
            public void onClickTitleCtv() {

            }

            @Override
            public void onClickRightCtv() {

            }

            @Override
            public void onClickRightSecondaryCtv() {

            }
        });
    }

    private static Toast mToastCenter = null;
    @Override
    public void showToast(final String text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 创建
                mToastCenter = new Toast(getApplicationContext());
                // 找到toast布局的位置
                View layout = View.inflate(getApplicationContext(), R.layout.layout_toast_tip, null);
                TextView tv_tip = (TextView) layout.findViewById(R.id.tv_tip);
                LinearLayout lly_tipRoot = (LinearLayout) layout.findViewById(R.id.lly_tipRoot);
                lly_tipRoot.setAlpha(0.6f);
                tv_tip.setText(text);
                // 设置toast文本，把设置好的布局传进来
                mToastCenter.setView(layout);
                // 设置土司显示在屏幕的位置
                Display display = ((Activity) mContext).getWindowManager().getDefaultDisplay();
                // 获取屏幕高度
                int height = display.getHeight();
                mToastCenter.setGravity(Gravity.TOP, 0, height / 2);
                mToastCenter.setDuration(Toast.LENGTH_SHORT);
                // 显示土司
                mToastCenter.show();
            }
        });
    }

    @Override
    public void showLoading() {
        if (mLoading != null && !mLoading.isShowing()) {
            mLoading = LoadProgressDialog.showProgressDialog(mAPPApplication.getApplicationContext());
            mLoading.show();
        }
    }

    @Override
    public void showLoading(String message) {
        mProgressDialog = LoadProgressDialog.showProgressDialog(mAPPApplication.getApplicationContext(), message);
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mLoading != null && mLoading.isShowing())
            mLoading.dismiss();
        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.cancel();
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public void noNetWork() {
        if (mLoading != null && mLoading.isShowing())
            mLoading.cancel();
        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.cancel();
        showError(-1, getResources().getString(R.string.nw_error_10005));
    }

    @Override
    public void showError(int status, String str) {
        showToast(str+"("+status+")");
    }

    /**
     * 进度加载对话框-显示
     */
    public void showLoadingDialog() {
        if (mLoadingDialog == null) {
            mLoadingDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
            mLoadingDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.colorPrimary));
            mLoadingDialog.setCancelable(true);
            mLoadingDialog.setTitleText("数据加载中...");
        }
        mLoadingDialog.show();
    }

    /**
     * 隐藏加载
     */
    public void dismissLoadingDialog() {
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }
    }
}
