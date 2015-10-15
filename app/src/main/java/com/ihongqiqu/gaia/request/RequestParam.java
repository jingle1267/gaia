package com.ihongqiqu.gaia.request;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import java.lang.annotation.Retention;
import java.util.HashMap;

/**
 * 参数
 *
 * Created by zhenguo on 10/14/15.
 */
public class RequestParam {

    /**
     * Supported request methods.
     */
    @IntDef({RequestParam.GET, RequestParam.POST, RequestParam.UPLOAD})
    public @interface Method {
    }

    public final static int GET = 0;
    public final static int POST = 1;
    public final static int UPLOAD = 2;

    @IntDef({RequestParam.String, RequestParam.JSON, RequestParam.XML})
    public @interface DataFormat {
    }
    public final static int String = 10;
    public final static int JSON = 11;
    public final static int XML = 12;

    /**
     * 请求方式 get post upload 默认GET
     */
    private int method = RequestParam.GET;
    /**
     * 返回数据格式 JSON XML String 默认JSON
     */
    private int dataFormat = RequestParam.JSON;

    /**
     * 请求地址
     */
    private String url;

    private HashMap<String, String> params;

    /**
     * 添加请求参数
     * @param k 参数关键字
     * @param v 参数值
     */
    public void addParams(@NonNull String k, String v) {
        if (params == null) {
            params = new HashMap<>();
        }
        params.put(k, v);
    }

    public HashMap<String, String> getParams() {
        return params;
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
}
