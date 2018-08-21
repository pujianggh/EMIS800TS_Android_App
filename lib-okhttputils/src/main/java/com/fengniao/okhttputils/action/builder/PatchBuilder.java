package com.fengniao.okhttputils.action.builder;

import com.fengniao.okhttputils.action.callback.OKHttpCallback;
import com.fengniao.okhttputils.action.response.IResponseHandler;
import com.fengniao.okhttputils.action.util.LogOkHttpUtils;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * patch builder
 *
 * @author pujiang
 * @date 2017-9-3 16:00
 * @mail 515210530@qq.com
 * @Description:
 */
public class PatchBuilder extends com.fengniao.okhttputils.action.builder.OkHttpRequestBuilder<PatchBuilder> {

    public PatchBuilder(com.fengniao.okhttputils.action.OkHttpCall okHttpCall) {
        super(okHttpCall);
    }

    @Override
    public void enqueue(final IResponseHandler responseHandler) {
        try {
            if(mUrl == null || mUrl.length() == 0) {
                throw new IllegalArgumentException("url can not be null !");
            }

            Request.Builder builder = new Request.Builder().url(mUrl);
            appendHeaders(builder, mHeaders);

            if (mTag != null) {
                builder.tag(mTag);
            }

            builder.patch(RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), ""));
            Request request = builder.build();

            mMyOkHttp.getOkHttpClient()
                    .newCall(request)
                    .enqueue(new OKHttpCallback(responseHandler));
        } catch (Exception e) {
            LogOkHttpUtils.d("Patch enqueue error:" + e.getMessage());
            responseHandler.onFailure(0, e.getMessage());
        }
    }
}
