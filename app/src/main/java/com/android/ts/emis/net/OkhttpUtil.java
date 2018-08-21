package com.android.ts.emis.net;

import android.content.Context;
import android.text.TextUtils;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.app.APPApplication;
import com.android.ts.emis.config.ConstantsUrls;
import com.android.ts.emis.utils.SPUtil;
import com.fengniao.okhttputils.action.response.JsonResponseHandler;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.libcommon.action.mode.BaseBean;
import com.libcommon.action.net.INetWorkCallBack;
import com.libcommon.action.utils.LogAPPUtil;
import com.libcommon.action.utils.NetWorkExceptionUtil;
import com.libcommon.action.utils.NetWorkUtil;
import com.libcommon.action.utils.TaskExecutorUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 网络请求操作类
 *
 * @author pujiang
 * @date 2017-9-19 16:35
 * @mail 515210530@qq.com
 * @Description:
 */
public class OkhttpUtil {
    public static String baseAppURL = ConstantsUrls.APPUrl[0];
    public static String baseWebURL = ConstantsUrls.APPUrl[0];

    public static String accessToken = "";
    public static String longtude = "";
    public static String latitude = "";
    public static String ipConfig = "";
    public static String drivice = "";
    public static String loginChannel = "QQ";
    public static String versionCode = "20180101";
    public static String versionName = "1.0";
    public static String appSign = "";

    /**
     * 网络请求
     *
     * @param context
     * @param headUrl
     * @param params
     * @param clas
     * @param mode
     * @param callBack
     * @param constantUrl
     * @param <T>
     */
    public static <T> void postParamClass(final Context context, final String headUrl, final Map<String, String> params,
                                          final Class<T> clas, final GetUrlMode mode, final INetWorkCallBack callBack, final String constantUrl) {
        TaskExecutorUtil.executeNetTask(new Runnable() {
            @Override
            public void run() {
                if (NetWorkUtil.isNetworkEnabled(context) == NetWorkUtil.NET_CONNECT_TYPE_UNNET) {
                    TaskExecutorUtil.runTaskOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            callBack.noNetWork();
                        }
                    });
                } else {
                    try {
                        APPApplication.getInstance().getOkHttpCall()
                                .post()
                                .params(params)
                                .tag(context)
                                .url(baseAppURL + headUrl)
                                .addHeader("loginTerm", "Android")
                                .addHeader("appVersion", versionName)
                                .addHeader("versionCode", versionCode)
                                .addHeader("accessToken", accessToken)
                                .addHeader("long", longtude)
                                .addHeader("lati", latitude)
                                .addHeader("ip", ipConfig)
                                .addHeader("equipNum", drivice)
                                .addHeader("loginChannel", loginChannel)
                                .addHeader("sign", appSign)
                                .enqueue(new JsonResponseHandler() {

                                    @Override
                                    public void onSuccess(int statusCode, String boy, final Headers headers) {
                                        HttpPrintLog(1, statusCode, boy.toString(), headers, params, headUrl);
                                    }

                                    @Override
                                    public void onSuccess(int statusCode, JSONArray response, final Headers headers) {
                                        HttpPrintLog(2, statusCode, response.toString(), headers, params, headUrl);
                                    }

                                    @Override
                                    public void onSuccess(int statusCode, final JSONObject response, final Headers headers) {
                                        HttpPrintLog(3, statusCode, response.toString(), headers, params, headUrl);
                                        if ("login".equals(constantUrl)) {
                                            SPUtil.INSTANCE.putString(StrRes.INSTANCE.getLoginJson(), response.toString());
                                        }
                                        try {
                                            Gson gson = new Gson();
                                            final T t = gson.fromJson(response.toString(), clas);
                                            TaskExecutorUtil.runTaskOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    switch (mode) {
                                                        case PULL_UP:
                                                            callBack.onPullUpSuccess(t, clas, constantUrl);
                                                            break;
                                                        case PULL_DOWN:
                                                            callBack.onPullDownSuccess(t, headers, clas, constantUrl);
                                                            break;
                                                        case NORMAL:
                                                            callBack.onSuccess(t, headers, clas, constantUrl);
                                                            break;
                                                        default:
                                                            callBack.onSuccess(t, headers, clas, constantUrl);
                                                            break;
                                                    }
                                                }
                                            });
                                        } catch (JsonParseException je) {
                                            TaskExecutorUtil.runTaskOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    getErrorStatus(context, BaseBean.class, callBack, response.toString(), constantUrl);
                                                }
                                            });
                                        } catch (Exception e) {
                                            NetWorkExceptionUtil.netWork(context, clas, callBack, e);
                                            e.getStackTrace();
                                        }
                                    }

                                    @Override
                                    public void onProgress(long currentBytes, long totalBytes) {
                                        super.onProgress(currentBytes, totalBytes);
                                    }

                                    @Override
                                    public void onFailure(int statusCode, String error_msg) {
                                        HttpPrintLog(500, statusCode, error_msg.toString(), null, params, headUrl);
                                    }

                                });
                    } catch (Exception e) {
                        NetWorkExceptionUtil.netWork(context, clas, callBack, e);
                        e.getStackTrace();
                    }
                }
            }
        });
    }


    /**
     * 网络请求
     *
     * @param context
     * @param headUrl
     * @param paramJson
     * @param clas
     * @param mode
     * @param callBack
     * @param <T>
     */
    public static <T> void postJsonClass(final Context context, final String headUrl, final String paramJson,
                                         final Class<T> clas, final GetUrlMode mode, final INetWorkCallBack callBack) {
        TaskExecutorUtil.executeNetTask(new Runnable() {
            @Override
            public void run() {
                if (NetWorkUtil.isNetworkEnabled(context) == NetWorkUtil.NET_CONNECT_TYPE_UNNET) {
                    TaskExecutorUtil.runTaskOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            callBack.noNetWork();
                        }
                    });
                } else {
                    try {
                        APPApplication.getInstance().getOkHttpCall()
                                .post()
                                .jsonParams(paramJson)
                                .tag(context)
                                .url(baseAppURL + headUrl)
                                .addHeader("loginTerm", "Android")
                                .addHeader("appVersion", versionName)
                                .addHeader("versionCode", versionCode)
                                .addHeader("accessToken", accessToken)
                                .addHeader("long", longtude)
                                .addHeader("lati", latitude)
                                .addHeader("ip", ipConfig)
                                .addHeader("equipNum", drivice)
                                .addHeader("loginChannel", loginChannel)
                                .addHeader("sign", appSign)
                                .enqueue(new JsonResponseHandler() {

                                    @Override
                                    public void onSuccess(int statusCode, String boy, final Headers headers) {
                                        HttpPrintLog(1, statusCode, boy.toString(), headers, null, headUrl);
                                    }

                                    @Override
                                    public void onSuccess(int statusCode, JSONArray response, final Headers headers) {
                                        HttpPrintLog(2, statusCode, response.toString(), headers, null, headUrl);
                                    }

                                    @Override
                                    public void onSuccess(int statusCode, final JSONObject response, final Headers headers) {
                                        HttpPrintLog(3, statusCode, response.toString(), headers, null, headUrl);
                                        try {
                                            Gson gson = new Gson();
                                            final T t = gson.fromJson(response.toString(), clas);
                                            TaskExecutorUtil.runTaskOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    switch (mode) {
                                                        case PULL_UP:
                                                            callBack.onPullUpSuccess(t, clas, "");
                                                            break;
                                                        case PULL_DOWN:
                                                            callBack.onPullDownSuccess(t, headers, clas, "");
                                                            break;
                                                        case NORMAL:
                                                            callBack.onSuccess(t, headers, clas, "");
                                                            break;
                                                        default:
                                                            callBack.onSuccess(t, headers, clas, "");
                                                            break;
                                                    }
                                                }
                                            });
                                        } catch (JsonParseException je) {
                                            TaskExecutorUtil.runTaskOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    getErrorStatus(context, BaseBean.class, callBack, response.toString(), "");
                                                }
                                            });
                                        } catch (Exception e) {
                                            NetWorkExceptionUtil.netWork(context, clas, callBack, e);
                                            e.getStackTrace();
                                        }
                                    }

                                    @Override
                                    public void onProgress(long currentBytes, long totalBytes) {
                                        super.onProgress(currentBytes, totalBytes);
                                    }

                                    @Override
                                    public void onFailure(int statusCode, String error_msg) {
                                        HttpPrintLog(500, statusCode, error_msg.toString(), null, null, headUrl);
                                    }

                                });
                    } catch (Exception e) {
                        NetWorkExceptionUtil.netWork(context, clas, callBack, e);
                        e.getStackTrace();
                    }
                }
            }
        });
    }


    public static <T> void getParamClass(final Context context, final String headUrl, final Map<String, String> params,
                                         final Class<T> clas, final GetUrlMode mode, final INetWorkCallBack callBack, final String constantUrl) {
        TaskExecutorUtil.executeNetTask(new Runnable() {
            @Override
            public void run() {
                if (NetWorkUtil.isNetworkEnabled(context) == NetWorkUtil.NET_CONNECT_TYPE_UNNET) {
                    TaskExecutorUtil.runTaskOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            callBack.noNetWork();
                        }
                    });
                } else {
                    try {
                        APPApplication.getInstance().getOkHttpCall()
                                .get()
                                .params(params)
                                .tag(context)
                                .url(baseAppURL + headUrl)
                                .addHeader("loginTerm", "Android")
                                .addHeader("appVersion", versionName)
                                .addHeader("versionCode", versionCode)
                                .addHeader("accessToken", accessToken)
                                .addHeader("long", longtude)
                                .addHeader("lati", latitude)
                                .addHeader("ip", ipConfig)
                                .addHeader("equipNum", drivice)
                                .addHeader("loginChannel", loginChannel)
                                .addHeader("sign", appSign)
                                .enqueue(new JsonResponseHandler() {

                                    @Override
                                    public void onSuccess(int statusCode, String boy, final Headers headers) {
                                        HttpPrintLog(1, statusCode, boy.toString(), headers, params, headUrl);
                                    }

                                    @Override
                                    public void onSuccess(int statusCode, JSONArray response, final Headers headers) {
                                        HttpPrintLog(2, statusCode, response.toString(), headers, params, headUrl);
                                    }

                                    @Override
                                    public void onSuccess(int statusCode, final JSONObject response, final Headers headers) {
                                        HttpPrintLog(3, statusCode, response.toString(), headers, params, headUrl);
                                        if ("login".equals(constantUrl)) {
                                            SPUtil.INSTANCE.putString(StrRes.INSTANCE.getLoginJson(), response.toString());
                                        }
                                        try {
                                            Gson gson = new Gson();
                                            final T t = gson.fromJson(response.toString(), clas);
                                            TaskExecutorUtil.runTaskOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    switch (mode) {
                                                        case PULL_UP:
                                                            callBack.onPullUpSuccess(t, clas, constantUrl);
                                                            break;
                                                        case PULL_DOWN:
                                                            callBack.onPullDownSuccess(t, headers, clas, constantUrl);
                                                            break;
                                                        case NORMAL:
                                                            callBack.onSuccess(t, headers, clas, constantUrl);
                                                            break;
                                                        default:
                                                            callBack.onSuccess(t, headers, clas, constantUrl);
                                                            break;
                                                    }
                                                }
                                            });
                                        } catch (JsonParseException je) {
                                            TaskExecutorUtil.runTaskOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    getErrorStatus(context, BaseBean.class, callBack, response.toString(), constantUrl);
                                                }
                                            });
                                        } catch (Exception e) {
                                            NetWorkExceptionUtil.netWork(context, clas, callBack, e);
                                            e.getStackTrace();
                                        }
                                    }

                                    @Override
                                    public void onProgress(long currentBytes, long totalBytes) {
                                        super.onProgress(currentBytes, totalBytes);
                                    }

                                    @Override
                                    public void onFailure(int statusCode, String error_msg) {
                                        HttpPrintLog(500, statusCode, error_msg.toString(), null, params, headUrl);
                                    }

                                });
                    } catch (Exception e) {
                        NetWorkExceptionUtil.netWork(context, clas, callBack, e);
                        e.getStackTrace();
                    }
                }
            }
        });
    }

    /**
     * 日志打印
     *
     * @param statusCode
     * @param response
     * @param headers
     * @param params
     * @param headUrl
     */
    public static void HttpPrintLog(int type, int statusCode, String response, Headers headers, Map<String, String> params, String headUrl) {
        String param = "";
        if (params != null) {
            for (String key : params.keySet()) {
                param += key + ": " + params.get(key) + "\n";
            }
        }
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        LogAPPUtil.i("================================" + timeStamp + "===================================");
        LogAPPUtil.i("发起请求 \nURL:" + baseAppURL + "\nheadUrl:" + headUrl + "\n头部\naccessToken:" + accessToken + "\nlongtude:" + longtude + "\nlatitude:" + latitude
                + "\nipConfig:" + ipConfig + "\ndrivice:" + drivice + "\nloginChannel:" + loginChannel + "\nversionCode:" + versionCode
                + "\n参数：\n" + param);
        String head = "";
        if (headers != null) {
            head = headers.toString();
        }
        LogAPPUtil.i("获取数据: 接收type:【" + type + "】\nstatusCode:" + statusCode + "\nresponse: " + response + "\n头部数据:\n" + head);

    }

    /**
     * 上传多张图片及参数
     *
     * @param reqUrl URL地址
     * @param params 参数
     * @param
     * @param
     */
    public static <T> void sendMultipart(final Class<T> clas, final Context context, final INetWorkCallBack callBack, final String reqUrl, final Map<String, String> params, final List<File> files
            , final String smContent, final String smCreateId, final String smTitle, final String smTroubleType, final String constantTag) {
        TaskExecutorUtil.executeNetTask(new Runnable() {
            @Override
            public void run() {
                MediaType type1 = MediaType.parse("application/x-www-form-urlencoded");
                RequestBody fileBody1 = RequestBody.create(type1, smContent);
                RequestBody fileBody2 = RequestBody.create(type1, smCreateId);
                RequestBody fileBody3 = RequestBody.create(type1, smTitle);
                RequestBody fileBody4 = RequestBody.create(type1, smTroubleType);
                MultipartBody.Builder multipartBody = new MultipartBody.Builder();
                multipartBody.addPart(Headers.of(
                        "Content-Disposition",
                        "form-data; name=\"smContent\"")
                        , fileBody1);
                multipartBody.addPart(Headers.of(
                        "Content-Disposition",
                        "form-data; name=\"smTitle\"")
                        , fileBody3);
                multipartBody.addPart(Headers.of(
                        "Content-Disposition",
                        "form-data; name=\"smCreateId\"")
                        , fileBody2);
                multipartBody.addPart(Headers.of(
                        "Content-Disposition",
                        "form-data; name=\"smTroubleType\"")
                        , fileBody4);
                for (File file :
                        files) {
                    multipartBody.addFormDataPart("files", file.getName(), RequestBody.create(MediaType.parse("image/png"), file));
                }

                Request request = new Request.Builder().url(baseAppURL + reqUrl)
                        .addHeader("User-Agent", "android")
                        .header("Content-Type", "text/html; charset=utf-8;")
                        .addHeader("loginTerm", "android")
                        .addHeader("jhVer", versionCode)
                        .addHeader("accessToken", accessToken)
                        .post(multipartBody.build())
                        .build();
                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String json = response.body().string();
                        getErrorStatus(context, clas, callBack, json, constantTag);
                    }
                });
            }
        });
    }

    /**
     * 上传文件
     *
     * @param clas
     * @param context
     * @param callBack
     * @param reqUrl
     * @param constantTag
     * @param mindiaType
     * @param <T>
     */
    public static <T> void upLoadFile(final Class<T> clas, final Context context, final INetWorkCallBack callBack, final String reqUrl, final String result, final File file, final String constantTag, final String mindiaType) {
        TaskExecutorUtil.executeNetTask(new Runnable() {
            @Override
            public void run() {
                MediaType type1 = MediaType.parse("application/x-www-form-urlencoded");
                RequestBody fileBody1 = RequestBody.create(type1, result);
                MultipartBody.Builder multipartBody = new MultipartBody.Builder();
                multipartBody.addPart(Headers.of(
                        "Content-Disposition",
                        "form-data; name=\"result\"")
                        , fileBody1);

                multipartBody.addFormDataPart("files", file.getName(), RequestBody.create(MediaType.parse(mindiaType), file));

                Request request = new Request.Builder().url(baseAppURL + reqUrl)
                        .addHeader("User-Agent", "android")
                        .header("Content-Type", "text/html; charset=utf-8;")
                        .addHeader("loginTerm", "android")
                        .addHeader("jhVer", versionCode)
                        .addHeader("accessToken", accessToken)
                        .post(multipartBody.build())
                        .build();
                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    public void onFailure(Call call, IOException e) {
                    }

                    public void onResponse(Call call, Response response) throws IOException {
                        String json = response.body().string();
                        getErrorStatus(context, clas, callBack, json, constantTag);
                    }
                });
            }
        });
    }

    /**
     * 获取错误码
     *
     * @param context  访问url接口的页面
     * @param callBack 回调方法
     * @param json     返回json数据
     */
    public static void getErrorStatus(final Context context, Class cla, final INetWorkCallBack callBack,
                                      String json, String constantUrl) {
        HttpPrintLog(500, 500, json.toString(), null, null, "");
        try {
            Gson gson = new Gson();
            BaseBean bean = gson.fromJson(json, BaseBean.class);
            String msg = "";
            msg = bean.getMessage();
            if (!TextUtils.isEmpty(msg)) {
                msg = bean.getMessage();
            }
            callBack.onError(bean.getCode(), msg, cla, constantUrl);
        } catch (Exception e) {
        }
    }

    /**
     * 访问接口类型
     */
    public enum GetUrlMode {

        /**
         * 通过上拉获取网络数据(翻页)
         */
        PULL_UP(0x0),
        /**
         * 通过下拉获取网络数据(刷新)
         */
        PULL_DOWN(0x1),
        /**
         * 正常的网络加载数据
         */
        NORMAL(0x2);

        private int mIntValue;

        GetUrlMode(int modeInt) {
            mIntValue = modeInt;
        }

        static GetUrlMode getDefault() {
            return NORMAL;
        }
    }

    /**
     * 设置基础AppURL地址
     *
     * @param baseAppURL
     */
    public static void setBaseAppURL(String baseAppURL) {
        OkhttpUtil.baseAppURL = baseAppURL;
    }

    /**
     * 设置基础WebURL地址
     *
     * @param baseWebURL
     */
    public static void setBaseWebURL(String baseWebURL) {
        OkhttpUtil.baseWebURL = baseWebURL;
    }

}
