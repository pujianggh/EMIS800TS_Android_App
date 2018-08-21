package com.libcommon.action.base;

import android.Manifest;
import android.support.multidex.MultiDexApplication;

import com.alipay.euler.andfix.patch.PatchManager;
import com.fengniao.okhttputils.action.OkHttpCall;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.libcommon.action.config.AppConfig;
import com.libcommon.action.net.DownloadMgr;
import com.libcommon.action.utils.FileUtil;
import com.libcommon.action.utils.PermissionUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Application基类
 *
 * @author pujiang
 * @date 2017-12-15 17:04
 * @mail 515210530@qq.com
 * @Description: 包含主要功能初始化，如：热修复、Application对象获取等
 */
public class CommonBaseApplication extends MultiDexApplication {
    protected OkHttpCall mOkHttpCall;
    protected DownloadMgr mDownloadMgr;
    private PatchManager mPatchManager;

    /**
     * 热修复补丁初始化
     */
    protected void initAndFix(String appVersion) {
        String[] permiss = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,//往SDCard写入数据权限
                Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS//在SDCard中创建与删除文件权限
        };
        //权限判断
        if (!PermissionUtil.checkPermissions(this, permiss)) {
            return;
        }
        mPatchManager = new PatchManager(this);
        mPatchManager.init(appVersion);
        mPatchManager.loadPatch();
        FileUtil.makeRootDirectory(AppConfig.FILE_PATCH_PATH);
        try {
            //文件存在判断
            if (FileUtil.isFileExist(AppConfig.FILE_PATCH_PATH + "/" + AppConfig.FILE_PATCH_NAME)) {
                File file = new File(AppConfig.FILE_PATCH_PATH, AppConfig.FILE_PATCH_NAME);
                mPatchManager.addPatch(file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化OkHttp参数
     */
    protected void initOkHttpConfig() {
        //持久化存储cookie
        ClearableCookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(getApplicationContext()));

        //log拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //自定义OkHttp
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20000L, TimeUnit.MILLISECONDS)
                .readTimeout(20000L, TimeUnit.MILLISECONDS)
                .cookieJar(cookieJar)       //设置开启cookie
                .addInterceptor(logging)            //设置开启log
                .build();
        mOkHttpCall = new OkHttpCall(okHttpClient);

        mDownloadMgr = (DownloadMgr) new DownloadMgr.Builder()
                .myOkHttp(mOkHttpCall)
                .maxDownloadIngNum(5)       //设置最大同时下载数量（不设置默认5）
                .saveProgressBytes(50 * 1204)   //设置每50kb触发一次saveProgress保存进度 （不能在onProgress每次都保存 过于频繁） 不设置默认50kb
                .build();
        //mDownloadMgr.resumeTasks();     //恢复本地所有未完成的任务
        //mDownloadManager.pauseAllTask();    //暂停所有任务
        //mDownloadManager.addTask();//添加任务
        //mDownloadManager.deleteTask();//删除任务
    }

    public PatchManager getmPatchManager() {
        return mPatchManager;
    }

    public OkHttpCall getOkHttpCall() {
        return mOkHttpCall;
    }

    public DownloadMgr getmDownloadMgr() {
        return mDownloadMgr;
    }
}
