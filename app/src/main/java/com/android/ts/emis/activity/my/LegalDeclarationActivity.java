package com.android.ts.emis.activity.my;

import android.os.Bundle;

import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * 法律声明
 *
 * @author pujiang
 * @date 2018-4-13 16:47
 * @mail 515210530@qq.com
 * @Description:
 */
public class LegalDeclarationActivity extends BaseActivity {

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_legal_declaration);
        ButterKnife.bind(this);

        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_legal_declaration_title), null, true);
    }
}
