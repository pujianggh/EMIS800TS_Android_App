package com.android.ts.emis.activity.my;

import android.os.Bundle;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.app.APPApplication;
import com.android.ts.emis.base.BaseActivity;
import com.libcommon.action.utils.APPToolsUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 关于我们
 *
 * @author pujiang
 * @date 2018-4-13 16:47
 * @mail 515210530@qq.com
 * @Description:
 */
public class AboutUsActivity extends BaseActivity {
    @BindView(R.id.tv_version)
    TextView tvVersion;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_about_us);
        ButterKnife.bind(this);

        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_about_us_title), null, true);
        tvVersion.setText("V" + APPToolsUtil.getAppVersionName(APPApplication.getInstance()));
    }
}
