package com.libcommon.action.net;

import okhttp3.Headers;

/**
 * 网络数据回调
 */
public abstract class INetWorkCallBack implements ICallBack {

    /**
     * 数据加载异常
     *
     * @param status 错误码
     * @param str    加载异常提示
     * @param cla
     */
    public void onError(int status, String str, Class cla) {

    }

    /**
     * 数据成功返回
     *
     * @param t           返回数据集
     * @param headers
     * @param cla         返回数据的类，如果是ArrayList<T> 返回t的类（t.getclass()）;
     * @param constantUrl
     * @param <T>
     */
    @Override
    public <T> void onSuccess(T t, Headers headers, Class cla, String constantUrl) {

    }

    /**
     *
     * @param t   返回接口获取的数据
     * @param cla 返回数据的类，如果是ArrayList<T> 返回t的类（t.getclass()）;
     * @param constantUrl
     * @param <T>
     */
    public <T> void onPullUpSuccess(T t, Class cla, String constantUrl){}

    /**
     * 下拉刷新重新获取接口数据(下拉刷新加载)
     *
     * @param t
     * @param headers
     * @param cla
     * @param constantUrl
     * @param <T>
     */

    public <T> void onPullDownSuccess(T t, Headers headers, Class cla, String constantUrl) {

    }
}
