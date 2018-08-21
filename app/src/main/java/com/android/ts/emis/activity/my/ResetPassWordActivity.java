package com.android.ts.emis.activity.my;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.utils.SPUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 设置-重置密码
 *
 * @author pujiang
 * @date 2018-4-13 16:47
 * @mail 515210530@qq.com
 * @Description:
 */
public class ResetPassWordActivity extends BaseActivity {
    @BindView(R.id.edt_oldPassWord)
    EditText edtOldPassWord;
    @BindView(R.id.edt_newPassWord)
    EditText edtNewPassWord;
    @BindView(R.id.edt_newPassWord2)
    EditText edtNewPassWord2;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_reset_password);
        ButterKnife.bind(this);

        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_reset_password_title), null, true);
        mUserPasswrd = SPUtil.INSTANCE.getAllModle(mAPPApplication, mUserPasswrd);
    }

    @OnClick({R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                if (TextUtils.isEmpty(edtOldPassWord.getText().toString())) {
                    showToast("请输入旧密码");
                    return;
                }
                if (TextUtils.isEmpty(edtNewPassWord.getText().toString())) {
                    showToast("请输入有效的新密码");
                    return;
                }
                if (TextUtils.isEmpty(edtNewPassWord2.getText().toString())) {
                    showToast("请输入有效确定新密码");
                    return;
                }
                if (!edtNewPassWord.getText().toString().equals(edtNewPassWord2.getText().toString())) {
                    showToast("确认新密码不匹配!");
                    return;
                }

                SPUtil.INSTANCE.putAllModle(mAPPApplication, mUserPasswrd);
                showToast("修改成功！");
                onBackPressed();
                break;
        }
    }
}
