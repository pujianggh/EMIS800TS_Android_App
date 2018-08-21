package com.android.ts.emis.activity.common;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.kotlinapp.action.config.AppConfig;
import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.ResultCode;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.signature.tool.view.HandWriteView;

/**
 * 签名板
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class SignatureHandActivity extends BaseActivity {
    @BindView(R.id.hand_view)
    HandWriteView mHandView;
    @BindView(R.id.btn_save)
    Button mBtnSave;
    @BindView(R.id.btn_clear)
    Button mBtnClear;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_signature_hand);
        ButterKnife.bind(this);
        setTitleBarLayout(R.drawable.icon_back_white_bar, null, getResources().getString(R.string.text_signature_hand_title), true);
    }

    @OnClick({R.id.btn_clear, R.id.btn_save})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                if (mHandView.isSign()) {
                    try {
                        //mHandView.save(AppConfig.INSTANCE.getFILE_CACHE_PATH(), true, 10, true);
                        mHandView.save(AppConfig.INSTANCE.getFILE_CACHE_PATH());
                        setResult(ResultCode.INSTANCE.getResult_SignatureHand());
                        finish();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    showToast(getResources().getString(R.string.text_signature_hand_tip));
                }
                break;
            case R.id.btn_clear:
                mHandView.clear();
                break;
        }
    }
}
