package com.android.kotlinapp.action.config

import com.libcommon.action.config.AppConfig
import java.io.File

/**
 * 生产环境配置config
 *
 * @author pujiang
 * @date 2018-1-3 19:57
 * @mail 515210530@qq.com
 * @Description:
 */
object AppConfig {
    //SplashActivity默认启动时间
    val SPLASH_TIME = 2000L

    //保存签名图片地址
    val FILE_CACHE_PATH = AppConfig.FILE_CACHE_PATH + File.separator + "signature.png"

    //获取验证码倒计时
    val GET_PHONECODE_TIME = 60000

    //友盟APPKey
    val UMENG_APP_KEY= "5b7bce3ff43e485ae900017b"

    //友盟APPKey
    val UMENG_MESSAGE_SECRET= "39a90b675a47e53ec296232b6b4557e7"
}
