package com.android.ts.emis.activity.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.activity.common.LoginActivity;
import com.android.ts.emis.app.APPApplication;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.utils.SPUtil;
import com.libcommon.action.utils.APPToolsUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 系统设置
 *
 * @author pujiang
 * @date 2018-4-13 16:45
 * @mail 515210530@qq.com
 * @Description:
 */
public class SettingActivity extends BaseActivity {
    @BindView(R.id.rly_clear_cache)
    RelativeLayout rlyClearCache;
    @BindView(R.id.rly_push_switch)
    RelativeLayout rlyPushSwitch;
    @BindView(R.id.rly_opinion_feedback)
    RelativeLayout rlyOpinionFeedback;
    @BindView(R.id.rly_share)
    RelativeLayout rlyShare;
    @BindView(R.id.rly_about)
    RelativeLayout rlyAbout;
    @BindView(R.id.rly_legal_declaration)
    RelativeLayout rlyLegalDeclaration;
    @BindView(R.id.rly_check_update)
    RelativeLayout rlyCheckUpdate;
    @BindView(R.id.rly_exit_login)
    RelativeLayout rlyExitLogin;
    @BindView(R.id.tv_version)
    TextView tvVersion;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_setting_title), null, true);
        tvVersion.setText(APPToolsUtil.getAppVersionName(APPApplication.getInstance()));
    }

    @OnClick({R.id.rly_clear_cache, R.id.rly_push_switch, R.id.rly_opinion_feedback, R.id.rly_share, R.id.rly_about
            , R.id.rly_legal_declaration, R.id.rly_check_update, R.id.rly_exit_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rly_clear_cache:
                showToast("清除完成");
                break;
            case R.id.rly_push_switch:

                break;
            case R.id.rly_opinion_feedback:
                startActivity(new Intent(mAPPApplication, FeedbackActivity.class));
                break;
            case R.id.rly_share:
                startActivity(new Intent(mAPPApplication, SharedActivity.class));
                break;
            case R.id.rly_about:
                startActivity(new Intent(mAPPApplication, AboutUsActivity.class));
                break;
            case R.id.rly_legal_declaration:
                startActivity(new Intent(mAPPApplication, LegalDeclarationActivity.class));
                break;
            case R.id.rly_check_update:
                showLoadingDialog();
                break;
            case R.id.rly_exit_login:
                mUserPasswrd.setUserCode("");
                mUserPasswrd.setUserName("");

                mUserPasswrd.setHouseCode(null);
                mUserPasswrd.setHouseName("");
                mUserPasswrd.setRuleCode("");
                SPUtil.INSTANCE.putAllModle(mAPPApplication, mUserPasswrd);
                startActivity(new Intent(this, LoginActivity.class));
                onBackPressed();
                break;
        }
    }

}
