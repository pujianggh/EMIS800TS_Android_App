package com.fengniao.okhttputils.action.response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * json类型的回调接口
 *
 * @author pujiang
 * @date 2017-9-3 16:00
 * @mail 515210530@qq.com
 * @Description:
 */
public abstract class JsonResponseHandler implements IResponseHandler {

    @Override
    public final void onSuccess(final Response response) {
        ResponseBody responseBody = response.body();
        String responseBodyStr = "";

        try {
            responseBodyStr = responseBody.string();
        } catch (IOException e) {
            e.printStackTrace();

            com.fengniao.okhttputils.action.OkHttpCall.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    onFailure(response.code(), response.body().toString());
                }
            });
            return;
        } finally {
            responseBody.close();
        }

        final String finalResponseBodyStr = responseBodyStr;

        try {
            final Object result = new JSONTokener(finalResponseBodyStr).nextValue();
            if (result instanceof JSONObject) {
                com.fengniao.okhttputils.action.OkHttpCall.mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        onSuccess(response.code(), (JSONObject) result, response.headers());
                    }
                });
            } else if (result instanceof JSONArray) {
                com.fengniao.okhttputils.action.OkHttpCall.mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        onSuccess(response.code(), (JSONArray) result, response.headers());
                    }
                });
            } else {
                com.fengniao.okhttputils.action.OkHttpCall.mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        onSuccess(response.code(), response.body().toString(), response.headers());
                    }
                });
            }
        } catch (JSONException e) {
            e.printStackTrace();
            com.fengniao.okhttputils.action.OkHttpCall.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    onFailure(response.code(), "fail parse jsonobject, body=" + finalResponseBodyStr);
                }
            });
        }
    }

    public void onSuccess(int statusCode, JSONObject response, Headers Header) {
    }

    public void onSuccess(int statusCode, JSONArray response, Headers Header) {
    }

    public void onSuccess(int statusCode, String boy, Headers Header) {
    }

    @Override
    public void onProgress(long currentBytes, long totalBytes) {
    }
}