package com.fengniao.okhttputils.action.builder;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 不带param的base
 * request body
 *
 * @author pujiang
 * @date 2017-9-3 16:00
 * @mail 515210530@qq.com
 * @Description:
 */
public abstract class OkHttpRequestBuilderHasParam<T extends OkHttpRequestBuilderHasParam> extends com.fengniao.okhttputils.action.builder.OkHttpRequestBuilder<T> {

    protected Map<String, String> mParams;

    public OkHttpRequestBuilderHasParam(com.fengniao.okhttputils.action.OkHttpCall myOkHttp) {
        super(myOkHttp);
    }

    /**
     * set Map params
     * @param params
     * @return
     */
    public T params(Map<String, String> params) {
        this.mParams = params;
        return (T) this;
    }

    /**
     * add param
     * @param key param key
     * @param val param val
     * @return
     */
    public T addParam(String key, String val) {
        if (this.mParams == null)
        {
            mParams = new LinkedHashMap<>();
        }
        mParams.put(key, val);
        return (T) this;
    }
}
