package com.android.ts.emis.activity.my;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.kotlinapp.action.config.AppConfig;
import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.utils.SPUtil;
import com.android.ts.emis.utils.TimerUtils;
import com.android.ts.emis.utils.ValidationUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 设置-绑定手机
 *
 * @author pujiang
 * @date 2018-4-13 16:47
 * @mail 515210530@qq.com
 * @Description:
 */
public class BindPhoneActivity extends BaseActivity {
    @BindView(R.id.tv_oldPhoneNumber)
    TextView tvOldPhoneNumber;
    @BindView(R.id.edt_newPhoneNumber)
    EditText edtNewPhoneNumber;
    @BindView(R.id.edt_phoneCode)
    EditText edtPhoneCode;
    @BindView(R.id.tv_getPhoneCode)
    TextView tvGetPhoneCode;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_bind_phone);
        ButterKnife.bind(this);

        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_bind_phone_title), null, true);
        mUserPasswrd = SPUtil.INSTANCE.getAllModle(mAPPApplication, mUserPasswrd);
        if (!TextUtils.isEmpty(mUserPasswrd.getUserName())) {
            tvOldPhoneNumber.setText(mUserPasswrd.getUserName());
        }
    }

    @OnClick({R.id.btn_next, R.id.tv_getPhoneCode})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                if (edtNewPhoneNumber.getText().toString().length() != 11) {
                    showToast("请输入11位手机号");
                    return;
                }
                if (!ValidationUtil.isMobile(edtNewPhoneNumber.getText().toString())) {
                    showToast("手机号码格式错误");
                    return;
                }
                if (edtPhoneCode.getText().toString().length() >= 4) {
                    showToast("提交成功!");
                    finish();
                }
                break;
            case R.id.tv_getPhoneCode:
                if (edtNewPhoneNumber.getText().toString().length() != 11) {
                    showToast("请输入11位手机号");
                    return;
                }
                if (!ValidationUtil.isMobile(edtNewPhoneNumber.getText().toString())) {
                    showToast("手机号码格式错误");
                    return;
                }
                TimerUtils timerUtils = new TimerUtils(AppConfig.INSTANCE.getGET_PHONECODE_TIME(), 1000, tvGetPhoneCode);
                timerUtils.start();
                break;
        }
    }
}
