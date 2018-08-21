package com.android.ts.emis.activity.common;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.activity.MainActivity;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.ConstantsResults;
import com.android.ts.emis.mode.UserInfoBean;
import com.android.ts.emis.mvp.iface.IUserLogin;
import com.android.ts.emis.mvp.impl.UserLoginImpl;
import com.android.ts.emis.utils.PopupWindowUtil;
import com.android.ts.emis.utils.SPUtil;
import com.libcommon.action.net.INetWorkCallBack;
import com.libcommon.action.utils.LanguageUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Headers;

/**
 * 系统登录
 *
 * @author pujiang
 * @date 2018-4-13 16:48
 * @mail 515210530@qq.com
 * @Description:
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.edt_account)
    EditText edtAccount;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.tv_company)
    TextView tvCompany;

    private PopupWindowUtil mPopupWindowUtil = null;
    private IUserLogin iUserLogin = null;
    private boolean isShow = false;

    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mUserPasswrd = SPUtil.INSTANCE.getAllModle(mAPPApplication, mUserPasswrd);
        if (!TextUtils.isEmpty(mUserPasswrd.getUserName())) {
            edtAccount.setText(mUserPasswrd.getUserName());
        }
        initEnvet();
    }

    @OnClick({R.id.btn_next, R.id.tv_company, R.id.tv_languageEN, R.id.tv_languageCN, R.id.tv_languageJA})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_languageJA:
                LanguageUtil.setAPPLanguage(mContext, LanguageUtil.JAPANESE);
                Intent intent1 = new Intent(mContext, LoginActivity.class);
                startActivity(intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
                break;
            case R.id.tv_languageEN:
                LanguageUtil.setAPPLanguage(mContext, LanguageUtil.ENGLISH);
                Intent intent2 = new Intent(mContext, LoginActivity.class);
                startActivity(intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
                break;
            case R.id.tv_languageCN:
                LanguageUtil.setAPPLanguage(mContext, LanguageUtil.CHINESE);
                Intent intent3 = new Intent(mContext, LoginActivity.class);
                startActivity(intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
                break;
            case R.id.tv_company:
                isShow = true;
                break;
            case R.id.btn_next:
                if (TextUtils.isEmpty(edtAccount.getText().toString())) {
                    showToast(getResources().getString(R.string.text_login_hint_account));
                    return;
                }
                if (TextUtils.isEmpty(edtPassword.getText().toString())) {
                    showToast(getResources().getString(R.string.text_login_hint_password));
                    return;
                }

                if (iUserLogin == null)
                    iUserLogin = new UserLoginImpl();
                showLoadingDialog();
                iUserLogin.login(getApplicationContext(), new INetWorkCallBack() {
                    @Override
                    public void noNetWork() {
                        dismissLoadingDialog();
                    }

                    @Override
                    public <T> void onSuccess(T t, Headers headers, Class cla, String constantUrl) {
                        dismissLoadingDialog();
                        if (UserInfoBean.class == cla) {
                            UserInfoBean bean = (UserInfoBean) t;
                            if (bean == null) return;
                            if (ConstantsResults.SUCCESS.equals(bean.getStatus())) {
                                LoginSuccessful(bean.getData());
                            } else {
                                showToast(bean.getMessage());
                            }
                        }
                    }

                    @Override
                    public void onError(int status, String str, Class cla, String constantUrl) {
                        dismissLoadingDialog();
                        showToast(str);
                    }
                }, edtAccount.getText().toString(), edtPassword.getText().toString(), "login");
                break;
        }
    }


    public void LoginSuccessful(UserInfoBean.DataBean dataBean) {
        mUserPasswrd = SPUtil.INSTANCE.getAllModle(mAPPApplication, mUserPasswrd);
        mUserPasswrd.setUserName(dataBean.getUserName());
        mUserPasswrd.setUserMobile(dataBean.getUserMobile());
        mUserPasswrd.setUserCode(dataBean.getUserCode());
        mUserPasswrd.setUserLevel(dataBean.getUserLevel());
        mUserPasswrd.setUserType(dataBean.getUserType());
        mUserPasswrd.setIsAdmin(dataBean.getIsAdmin());
        mUserPasswrd.setUserTypeName(dataBean.getUserTypeName());

        if (!TextUtils.isEmpty(SPUtil.INSTANCE.getString(StrRes.INSTANCE.getHouseCode()))) {
            mUserPasswrd.setHouseName(SPUtil.INSTANCE.getString(StrRes.INSTANCE.getHouseName()));
            mUserPasswrd.setHouseCode(SPUtil.INSTANCE.getString(StrRes.INSTANCE.getHouseCode()));
            mUserPasswrd.setRuleCode(SPUtil.INSTANCE.getString(StrRes.INSTANCE.getRuleCode()));
            mUserPasswrd.setHousePhaseCode(SPUtil.INSTANCE.getString(StrRes.INSTANCE.getHousePhaseCode()));
        } else {
            if (dataBean.getHouseList() != null && dataBean.getHouseList().size() > 0) {
                mUserPasswrd.setHouseName(dataBean.getHouseList().get(0).getHouseName());
                mUserPasswrd.setHouseCode(dataBean.getHouseList().get(0).getHouseCode());
                mUserPasswrd.setRuleCode(dataBean.getHouseList().get(0).getHouseCode());
                mUserPasswrd.setHousePhaseCode(dataBean.getHouseList().get(0).getHousePhaseCode());
            }
        }
        SPUtil.INSTANCE.putAllModle(mAPPApplication, mUserPasswrd);

        startActivity(new Intent(this, MainActivity.class));
        onBackPressed();
        finish();
    }

    private void initEnvet() {
        edtAccount.addTextChangedListener(new TextChangeListeners());
        edtPassword.addTextChangedListener(new TextChangeListeners());
        tvCompany.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (isShow) {
                    if (mPopupWindowUtil == null)
                        mPopupWindowUtil = new PopupWindowUtil(mContext);
                    mPopupWindowUtil.showSetConnectURLWindow();
                }
                return false;
            }
        });
    }

    private class TextChangeListeners implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!TextUtils.isEmpty(edtAccount.getText().toString()) && !TextUtils.isEmpty(edtPassword.getText().toString())) {
                btnNext.setEnabled(true);
            } else {
                btnNext.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
