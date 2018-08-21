package com.android.ts.emis.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import com.android.kotlinapp.action.config.AppConfig
import com.android.ts.emis.R
import com.android.ts.emis.activity.common.LoginActivity
import com.android.ts.emis.app.APPApplication
import com.android.ts.emis.base.BaseActivity
import com.android.ts.emis.utils.SPUtil
import com.libcommon.action.utils.APPToolsUtil
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * 启动界面
 *
 * @author pujiang
 * @date 2018-1-18 10:52
 * @mail 515210530@qq.com
 * @Description:
 */
class SplashActivity : BaseActivity() {

    override fun isSupportSwipeBack(): Boolean {
        return false
    }

    override fun initView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_splash)
        tv_version.setText("v" + APPToolsUtil.getAppVersionName(APPApplication.getInstance()))
        mUserPasswrd = SPUtil.getAllModle(mAPPApplication, mUserPasswrd);
        Handler().postDelayed({
            if (TextUtils.isEmpty(mUserPasswrd.userCode)) {
                startActivity(Intent(this, LoginActivity::class.java))
            } else {
                startActivity(Intent(this, MainActivity::class.java))
            }
            finish()
        }, AppConfig.SPLASH_TIME)
    }
}
