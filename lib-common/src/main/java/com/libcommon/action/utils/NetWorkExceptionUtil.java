package com.libcommon.action.utils;

import android.content.Context;

import com.libcommon.action.R;
import com.libcommon.action.net.ICallBack;
import org.json.JSONException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * 异常处理解析
 * Created by Administrator on 2016/6/22.
 */
public class NetWorkExceptionUtil {
    /**
     * 访问网络经常出现的异常及处理.
     * @param context 访问网络页面
     * @param netCallBack 网络回调接口
     * @param e 出现的异常
     */
    public static void netWork(final Context context, final Class cla, final ICallBack netCallBack, final Exception e){
        TaskExecutorUtil.runTaskOnUiThread (new Runnable() {
            @Override
            public void run() {
                if(e instanceof SocketTimeoutException){
                    netCallBack.onError (10005, context.getResources ().getString (R.string.nw_error_10005), cla,"");
                }else if(e instanceof UnknownHostException){
                    netCallBack.onError (10001, context.getResources ().getString (R.string.nw_error_10001), cla,"");
                }else if(e instanceof JSONException){
                    netCallBack.onError (10003, context.getResources ().getString (R.string.nw_error_10003), cla,"");
                }
            }
        });
        e.printStackTrace ();
    }

}
