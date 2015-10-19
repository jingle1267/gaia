package com.ihongqiqu.gaia.request;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import java.util.HashMap;

/**
 * 请求参数
 * <p/>
 * 必须设置请求url
 * 可以设置请求方式(GET,POST,UPLOAD)
 * 可以设置请求返回数据的格式(STRING,JSON,XML)
 * 可以添加需要的参数params
 * <p/>
 * Created by zhenguo on 10/14/15.
 */
public class RequestParam {

    /**
     * Supported request methods.
     */
    @IntDef({Method.GET, Method.POST, Method.UPLOAD})
    public @interface Method {
        int GET = 0;
        int POST = 1;
        int UPLOAD = 2;

    }

    @IntDef({DataFormat.String, DataFormat.JSON, DataFormat.XML})
    public @interface DataFormat {
        int String = 10;
        int JSON = 11;
        int XML = 12;
    }

    /**
     * 请求方式 get post upload 默认GET
     */
    private int method = Method.GET;
    /**
     * 返回数据格式 JSON XML String 默认JSON
     */
    private int dataFormat = DataFormat.JSON;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 请求标志 需要设置 除非不关心请求的结果
     */
    private String tag;

    private  static HashMap<String, String> params;
    /**
     * 网络请求公共参数
     */
    private static HashMap<String, String> Publicparams = new HashMap<String, String>();

    /**
     * 添加请求公共参数
     *
     * @param k 参数关键字
     * @param v 参数值
     */
    public void addParams(@NonNull String k, String v) {
        if (params == null) {
            params = new HashMap<>();
        }
        params.put(k, v);
    }

    /**
     * 对公共参数的key赋值
     *
     * @param key   键
     * @param value 值
     */
    public static void setParamsValueForKey(String key, String value) {
        if (RequestParam.Publicparams.containsKey(key))
            RequestParam.Publicparams.remove(key);
        RequestParam.Publicparams.put(key, value);
    }

    /**
     * 添加请求参数
     *
     * @param k 参数关键字
     * @param v 参数值
     */
    public void addParams(HashMap<String, String> param) {
        if (params != null) {
          params.clear();
        }
        params.putAll(param);
    }

    public HashMap<String, String> getParams() {
        return params;
    }
    public HashMap<String, String> getPublicParams() {
        return Publicparams;
    }

    @Method
    public int getMethod() {
        return method;
    }


    public void setMethod(@Method int method) {
        this.method = method;
    }

    @DataFormat
    public int getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(@DataFormat int dataFormat) {
        this.dataFormat = dataFormat;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
