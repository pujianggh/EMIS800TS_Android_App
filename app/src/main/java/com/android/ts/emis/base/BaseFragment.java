package com.android.ts.emis.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ts.emis.R;
import com.android.ts.emis.app.APPApplication;
import com.android.ts.emis.dialog.LoadProgressDialog;
import com.android.ts.emis.mode.UserPasswordBean;
import com.android.ts.emis.mvp.view.IParentView;
import com.android.ts.emis.utils.SPUtil;
import com.libcommon.action.base.CommonBaseFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Fragment基类：
 *
 * @author pujiang
 * @date 2018-1-18 10:02
 * @mail 515210530@qq.com
 * @Description:
 */
public abstract class BaseFragment extends CommonBaseFragment implements IParentView {
    protected String mTag;//用于日志打印或者类名查看
    protected APPApplication mAPPApplication;
    protected View mContentView;
    protected BaseActivity mActivity;
    protected Unbinder unBinder;
    protected UserPasswordBean mUserPasswrd = new UserPasswordBean();

    protected Dialog mLoadingDialog;
    protected Dialog mProgressDialog;

    protected int mPage = 1, mSize = 10, mTotalPage = 1;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mTag = this.getClass().getSimpleName();
        mAPPApplication = APPApplication.getInstance();
        mActivity = (BaseActivity) getActivity();
        mUserPasswrd = SPUtil.INSTANCE.getAllModle(mAPPApplication, mUserPasswrd);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 避免多次从xml中加载布局文件
        if (mContentView == null) {
            initView(savedInstanceState);
        } else {
            ViewGroup parent = (ViewGroup) mContentView.getParent();
            if (parent != null) {
                parent.removeView(mContentView);
            }
        }
        unBinder = ButterKnife.bind(this, mContentView);
        return mContentView;
    }

    protected void setContentView(@LayoutRes int layoutResID) {
        mContentView = LayoutInflater.from(mActivity).inflate(layoutResID, null);
    }

    /**
     * 初始化View控件
     */
    protected abstract void initView(Bundle savedInstanceState);

    private static Toast mToastCenter = null;

    @Override
    public void showToast(final String text) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 创建
                mToastCenter = new Toast(getActivity());
                // 找到toast布局的位置
                View layout = View.inflate(getActivity(), R.layout.layout_toast_tip, null);
                TextView tv_tip = (TextView) layout.findViewById(R.id.tv_tip);
                LinearLayout lly_tipRoot = (LinearLayout) layout.findViewById(R.id.lly_tipRoot);
                lly_tipRoot.setAlpha(0.6f);
                tv_tip.setText(text);
                // 设置toast文本，把设置好的布局传进来
                mToastCenter.setView(layout);
                // 设置土司显示在屏幕的位置
                Display display = ((Activity) getActivity()).getWindowManager().getDefaultDisplay();
                // 获取屏幕高度
                int height = display.getHeight();
                //mToastCenter.setGravity(Gravity.CENTER, 0, 0);
                mToastCenter.setGravity(Gravity.TOP, 0, height / 4);
                mToastCenter.setDuration(Toast.LENGTH_SHORT);
                // 显示土司
                mToastCenter.show();
            }
        });
    }

    @Override
    public void showLoading() {
        if (mLoadingDialog != null && !mLoadingDialog.isShowing()) {
            mLoadingDialog = LoadProgressDialog.showProgressDialog(mAPPApplication.getApplicationContext());
            mLoadingDialog.show();
        }
    }

    @Override
    public void showLoading(String message) {
        mProgressDialog = LoadProgressDialog.showProgressDialog(mAPPApplication.getApplicationContext(), message);
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing())
            mLoadingDialog.dismiss();
        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.cancel();
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public void noNetWork() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing())
            mLoadingDialog.cancel();
        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.cancel();
        showError(-1, getResources().getString(R.string.nw_error_10005));
    }

    @Override
    public void showError(int status, String str) {
        showToast(str + "(" + status + ")");
    }

    /**
     * 显示-进度对话框
     */
    protected void showLoadingDialog() {
        mActivity.showLoadingDialog();
    }

    /**
     * 隐藏对话框
     */
    protected void dismissLoadingDialog() {
        if (isVisible()) {
            mActivity.dismissLoadingDialog();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unBinder != null)
            unBinder.unbind();
    }
}
