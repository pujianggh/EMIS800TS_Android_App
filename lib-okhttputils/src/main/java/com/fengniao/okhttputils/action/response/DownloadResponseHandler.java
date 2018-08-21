package com.fengniao.okhttputils.action.response;

import java.io.File;

/**
 * 下载回调
 *
 * @author pujiang
 * @date 2017-9-3 16:00
 * @mail 515210530@qq.com
 * @Description:
 */
public abstract class DownloadResponseHandler {

    public void onStart(long totalBytes) {}
    public void onCancel() {}
    public abstract void onFinish(File downloadFile);
    public abstract void onProgress(long currentBytes, long totalBytes);
    public abstract void onFailure(String error_msg);
}
