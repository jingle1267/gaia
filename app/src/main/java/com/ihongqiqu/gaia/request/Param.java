package com.ihongqiqu.gaia.request;

import android.support.annotation.NonNull;
import java.util.HashMap;

/**
 * 参数
 *
 * Created by zhenguo on 10/14/15.
 */
public class Param {

    /**
     * Supported request methods.
     */
    public interface Method {
        int GET = 0;
        int POST = 1;
        int UPLOAD = 2;

    }

    public interface DataFormat {
        int String = 0;
        int JSON = 1;
        int XML = 2;
    }

    /**
     * 请求方式 get post upload 默认GET
     */
    public int method = Param.Method.GET;
    /**
     * 返回数据格式 JSON XML String 默认JSON
     */
    public int dataFormat = Param.DataFormat.JSON;

    /**
     * 请求地址
     */
    public String url;

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

}
