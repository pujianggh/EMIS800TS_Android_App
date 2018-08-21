package com.android.ts.emis.app;

import android.content.Context;
import android.content.Intent;

import com.android.kotlinapp.action.config.AppConfig;
import com.android.ts.emis.BuildConfig;
import com.android.ts.emis.activity.MainActivity;
import com.android.ts.emis.utils.ToastUtil;
import com.libcommon.action.base.CommonBaseApplication;
import com.libcommon.action.utils.APPToolsUtil;
import com.libcommon.action.utils.LogAPPUtil;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.entity.UMessage;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackManager;

/**
 * Application类
 *
 * @author pujiang
 * @date 2018-01-25 17:21
 * @mail 515210530@qq.com
 * @Description:
 */
public class APPApplication extends CommonBaseApplication {
    public static Class toIntentMainClass = "MainActivity".getClass();  //需要跳转主页的类
    private static APPApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initConfigData();
        initOkHttpConfig();//初始化网络请求参数
        initAndFix(APPToolsUtil.getAppVersionName(this));
    }

    /**
     * 初始化项目配置文件数据
     */
    private void initConfigData() {
        // 必须在Application的onCreate 方法中执行
        // BGASwipeBackManager.getInstance().init(this)来初始化滑动返回
        BGASwipeBackManager.getInstance().init(this);
        //友盟初始化
        //设置LOG开关，默认为false
        UMConfigure.setLogEnabled(BuildConfig.DEBUG);
        //初始化组件化基础库, 统计SDK/推送SDK/分享SDK都必须调用此初始化接口
        UMConfigure.init(this, AppConfig.INSTANCE.getUMENG_APP_KEY(), null, UMConfigure.DEVICE_TYPE_PHONE,
                AppConfig.INSTANCE.getUMENG_MESSAGE_SECRET());
        initUpush();//初始化友盟推送
    }

    public static synchronized APPApplication getInstance() {
        return mInstance;
    }


    /**
     * 注册友盟
     */
    public void initUpush() {
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        //sdk开启通知声音
        //mPushAgent.setNotificationPlaySound(MsgConstant.NOTIFICATION_PLAY_SDK_ENABLE);
        // sdk关闭通知声音
        // mPushAgent.setNotificationPlaySound(MsgConstant.NOTIFICATION_PLAY_SDK_DISABLE);
        // 通知声音由服务端控制
        mPushAgent.setNotificationPlaySound(MsgConstant.NOTIFICATION_PLAY_SERVER);
        // mPushAgent.setNotificationPlayLights(MsgConstant.NOTIFICATION_PLAY_SDK_DISABLE);
        // mPushAgent.setNotificationPlayVibrate(MsgConstant.NOTIFICATION_PLAY_SDK_DISABLE);
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device tokend
                LogAPPUtil.i("mPushAgent==>deviceToken:"+deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
            }
        });

        UmengNotificationClickHandler notificationClickHandler = new UmengNotificationClickHandler() {
            @Override
            public void dealWithCustomAction(Context context, UMessage msg) {
                ToastUtil.INSTANCE.show(msg.custom);
                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        };
        mPushAgent.setNotificationClickHandler(notificationClickHandler);
    }
}
