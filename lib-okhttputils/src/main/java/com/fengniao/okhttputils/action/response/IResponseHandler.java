package com.fengniao.okhttputils.action.response;

import okhttp3.Response;

/**
 * IResponseHandler类型的回调接口
 *
 * @author pujiang
 * @date 2017-9-3 16:00
 * @mail 515210530@qq.com
 * @Description:
 */
public interface IResponseHandler {

    void onSuccess(Response response);

    void onFailure(int statusCode, String error_msg);

    void onProgress(long currentBytes, long totalBytes);
}
