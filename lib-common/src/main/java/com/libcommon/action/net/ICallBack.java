package com.libcommon.action.net;

import okhttp3.Headers;

/**
 * 网络监听接口
 */
public interface ICallBack {

    /**
     * 无网络
     */
    void noNetWork();

    /**
     * 加载网络数据成功
     *
     * @param t   返回数据集
     * @param cla 返回数据的类，如果是ArrayList<T> 返回t的类（t.getclass()）;
     */
    <T> void onSuccess(T t, Headers headers, Class cla, String constantUrl);

    /**
     * 数据加载异常
     *
     * @param status 错误码
     * @param str    加载异常提示
     */
    void onError(int status, String str, Class cla, String constantUrl);

    /**
     * 下拉刷新
     *
     * @param t
     * @param cla
     * @param <T>
     */
    <T> void onPullDownSuccess(T t, Headers headers, Class cla, String constantUrl);


    /**
     * 上拉加载获取的数据(上拉翻页加载)
     *
     * @param t   返回接口获取的数据
     * @param cla 返回数据的类，如果是ArrayList<T> 返回t的类（t.getclass()）;
     */
    <T> void onPullUpSuccess(T t, Class cla, String constantUrl);

}
