package com.libcommon.action.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

import java.util.List;

/**
 * 应用市场评分工具类
 *
 * @author pujiang
 * @date 2017-9-29 21:57
 * @mail 515210530@qq.com
 * @Description: 跳转应用市场评分
 */
public class MarketScoreUtil {

    /**
     * 跳转到app详情界面
     * <p>
     * 应用商店包名 ,如果为""则由系统弹出应用商店列表供用户选择,否则调转到目标市场的应用详情界面，某些应用商店可能会失败
     */
    public static void toMarketAppLaunchDetail(Context context) {
        String APP_PackageName = APPToolsUtil.getAppPackageName(context);//APP包名
        if (TextUtils.isEmpty(APP_PackageName))//自己应用的包名
            return;
        try {
            String marketAppPackageName = getMarketAppPackageName(context);
            if (TextUtils.isEmpty(marketAppPackageName))//判断获取到的应用市场包名，是否为空
                return;
            if (isInstalledAPP(context, marketAppPackageName)) {//已经安装了该应用宝
                Uri uri = Uri.parse("market://details?id=" + APP_PackageName);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage(marketAppPackageName);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            } else {//未安装
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(getMarketAppURL(context)));
                context.startActivity(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断用户是否安装相关应用宝
     *
     * @param context
     * @return
     */
    public static boolean isInstalledAPP(Context context, String installedPackageName) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals(installedPackageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取不同渠道URL
     * @param context
     * @return
     */
    public static String getMarketAppURL(Context context) {
        String channelName = ChannelNameUitl.getChannelNameApplication(context, "UMENG_CHANNEL");
        String URL = "";
        switch (channelName) {
            case "QQ"://腾讯应用宝
            case "QQ_mj":
                URL = "http://android.myapp.com/myapp/detail.htm?apkName=com.flyfnd.sijimoney.action";
                break;
            case "xiaomi"://小米应用商店
                URL = "http://app.mi.com/subject/167924";
                break;
            case "oppo"://OPPO应用商店
            case "oppo_mj":
                URL = "http://storedl1.nearme.com.cn/apk/201707/28/cd4b93724d6e2c34471d9dc844fa0f05.apk";
                break;
            case "huawei"://华为
                URL = "http://a.vmall.com/app/C100056091?shareTo=weixin&shareFrom=appmarket";
                break;
            case "wandoujia":
            case "alibaba"://阿里巴巴 和豌豆荚同一个
                URL = "http://www.wandoujia.com/apps/com.flyfnd.sijimoney.action";
                break;
            case "meizu"://魅族
                URL = "http://app.meizu.com/apps/public/detail?package_name=com.flyfnd.sijimoney.action";
                break;
            case "lenovo"://联想应用商店
                URL = "https://apps.lenovo.com.cn";
                break;
            case "anzhi"://安智应用商店
                URL = "com.hiapk.marketpho";
                break;
            case "chuizi"://锤子市场
                URL = "http://www.anzhi.com/pkg/8328_com.flyfnd.sijimoney.action.html#";
                break;
            case "samsung"://三星市场
                URL = "http://shouji.360tpcdn.com/170603/b7ec2f34971ded83fc3c79d55191c427/com.sec.android.app.samsungapps_421027110.apk";
                break;
            case "APPChina"://应用汇
                URL = "http://m.appchina.com/app/com.yingyonghui.market?channel=qr-code";
                break;
            case "mumayi"://木蚂蚁市场
                URL = "http://www.mumayi.com/android-1193694.html";
                break;
            case "youyi"://优亿市场
                URL = "http://www.eoemarket.com";
                break;
            case "jifeng"://机锋应用市场
                URL = "http://apk.gfan.com";
                break;
            case "kuan"://cool市场
                URL = "http://www.coolmart.net.cn";
                break;
            case "zhuoyi":
                URL = "http://android.myapp.com/myapp/detail.htm?apkName=com.flyfnd.sijimoney.action";
                break;
            case "baidu"://百度手机助手
                URL = "https://mobile.baidu.com/item?docid=11029749&source=pc";
                break;
            case "qr360"://360手机助手
                URL = "http://openbox.mobilem.360.cn/url/r/k/std_1507544018";
                break;
            case "vivo":
                URL = "http://appstore.vivo.com.cn/appinfo/downloadApkFile?id=51699&cfrom=165";
                break;
            case "sougou":
                URL = "http://appcdn.123.sogou.com/wap/SogouMallAPPsearch.apk";
                break;
            case "leshi":
                URL = "http://mobile.leplay.cn/?from=leplay.cn";
                break;
        }
        return URL;
    }

    /**
     * 获取不同渠道包名
     *
     * @param context
     */
    public static String getMarketAppPackageName(Context context) {
        String channelName = ChannelNameUitl.getChannelNameApplication(context, "UMENG_CHANNEL");
        String marketPackageName = "";
        switch (channelName) {
            case "QQ"://腾讯应用宝
            case "QQ_mj"://腾讯应用宝
                marketPackageName = "com.tencent.android.qqdownloader";
                break;
            case "xiaomi"://小米应用商店
                marketPackageName = "com.xiaomi.market";
                break;
            case "oppo"://OPPO应用商店
            case "oppo_mj":
                marketPackageName = "com.oppo.market";
                break;
            case "huawei"://华为
                marketPackageName = "com.huawei.appmarket";
                break;
            case "wandoujia"://豌豆荚
            case "alibaba"://阿里巴巴 和豌豆荚同一个
                marketPackageName = "com.wandoujia.phoenix2";
                break;
            case "meizu"://魅族市场
                marketPackageName = "";
                break;
            case "lenovo"://联想应用商店
                marketPackageName = "com.lenovo.leos.appstore";
                break;
            case "anzhi"://安智应用商店
                marketPackageName = "com.hiapk.marketpho";
                break;
            case "chuizi"://锤子市场（暂无市场）
                marketPackageName = "com.yingyonghui.market";//默认
                break;
            case "samsung"://三星市场
                marketPackageName = "com.sec.android.app.samsungapps";
                break;
            case "APPChina"://应用汇
                marketPackageName = "com.yingyonghui.market";
                break;
            case "mumayi"://木蚂蚁市场
                marketPackageName = "com.mumayi.market.ui";
                break;
            case "youyi"://
                marketPackageName = "com.eoemobile.netmarket";
                break;
            case "jifeng"://机锋应用市场
                marketPackageName = "com.mappn.gfan";
                break;
            case "kuan"://cool市场
                marketPackageName = "com.coolapk.market";
                break;
            case "zhuoyi"://桌易市场
                marketPackageName = "com.zhuoyi.market";
                break;
            case "baidu"://百度手机助手
                marketPackageName = "com.baidu.appsearch";
                break;
            case "qr360"://360手机助手
                marketPackageName = "com.qihoo.appstore";
                break;
            case "vivo"://vivo市场
                marketPackageName = "com.bbk.appstore";
                break;
            case "sougou"://sougou市场
                marketPackageName = "com.sogou.appmall";
                break;
            case "leshi"://lenovo市场
                marketPackageName = "com.lenovo.leos.appstore";
                break;
            case "zte"://中兴市场
                marketPackageName = "zte.com.market";
                break;
        }
        return marketPackageName;
    }
}
