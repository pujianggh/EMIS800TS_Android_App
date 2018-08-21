package com.fengniao.okhttputils.action.builder;

import com.fengniao.okhttputils.action.callback.OKHttpCallback;
import com.fengniao.okhttputils.action.response.IResponseHandler;
import com.fengniao.okhttputils.action.util.LogOkHttpUtils;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * put builder
 *
 * @author pujiang
 * @date 2017-9-3 16:00
 * @mail 515210530@qq.com
 * @Description:
 */
public class PutBuilder extends com.fengniao.okhttputils.action.builder.OkHttpRequestBuilder<PutBuilder> {

    public PutBuilder(com.fengniao.okhttputils.action.OkHttpCall okHttpCall){
        super(okHttpCall);
    }

    @Override
    public void enqueue(IResponseHandler responseHandler) {
        try {
            if(mUrl == null || mUrl.length() == 0) {
                throw new IllegalArgumentException("url can not be null !");
            }

            Request.Builder builder = new Request.Builder().url(mUrl);
            appendHeaders(builder, mHeaders);

            if (mTag != null) {
                builder.tag(mTag);
            }

            builder.put(RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), ""));

            Request request = builder.build();

            mMyOkHttp.getOkHttpClient()
                    .newCall(request)
                    .enqueue(new OKHttpCallback(responseHandler));
        } catch (Exception e) {
            LogOkHttpUtils.d("Put enqueue error:" + e.getMessage());
            responseHandler.onFailure(0, e.getMessage());
        }
    }
}