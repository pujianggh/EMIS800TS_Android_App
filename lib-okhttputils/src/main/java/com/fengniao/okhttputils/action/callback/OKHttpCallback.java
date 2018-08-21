package com.fengniao.okhttputils.action.callback;

import com.fengniao.okhttputils.action.response.IResponseHandler;
import com.fengniao.okhttputils.action.util.LogOkHttpUtils;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author pujiang
 * @date 2017-9-3 16:00
 * @mail 515210530@qq.com
 * @Description:
 */
public class OKHttpCallback implements Callback {

    private IResponseHandler mResponseHandler;

    public OKHttpCallback(IResponseHandler responseHandler) {
        mResponseHandler = responseHandler;
    }

    @Override
    public void onFailure(Call call, final IOException e) {
        LogOkHttpUtils.d("onFailure", e);

        com.fengniao.okhttputils.action.OkHttpCall.mHandler.post(new Runnable() {
            @Override
            public void run() {
                mResponseHandler.onFailure(0, e.toString());
            }
        });
    }

    @Override
    public void onResponse(Call call, final Response response) {
        if (response.isSuccessful()) {
            mResponseHandler.onSuccess(response);
        } else {
            LogOkHttpUtils.d("onResponse fail status=" + response.code());

            com.fengniao.okhttputils.action.OkHttpCall.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mResponseHandler.onFailure(response.code(), "fail status=" + response.code());
                }
            });
        }
    }
}
