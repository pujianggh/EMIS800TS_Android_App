package com.fengniao.okhttputils.action.download_mgr;

/**
 * 状态参数
 *
 * @author pujiang
 * @date 2017-9-3 16:00
 * @mail 515210530@qq.com
 * @Description:
 */
public class DownloadStatus {
    public static final int STATUS_DEFAULT = -1;        //初始状态
    public static final int STATUS_WAIT = 0;            //队列等待中
    public static final int STATUS_PAUSE = 1;           //暂停
    public static final int STATUS_DOWNLOADING = 2;     //下载中
    public static final int STATUS_FINISH = 3;          //下载完成
    public static final int STATUS_FAIL = 4;            //下载失败
}
