package com.ihongqiqu.gaia.request;

/**
 * 参数
 *
 * Created by zhenguo on 10/14/15.
 */
public class Param {

    public static int GET = 0;
    public static int POST = 1;
    public static int UPLOAD = 2;

    public static int String = 0;
    public static int JSON = 1;
    public static int XML = 2;

    /**
     * 请求方式 get post upload 默认GET
     */
    int method = Param.GET;
    /**
     * 返回数据格式 JSON XML String 默认JSON
     */
    int dataFormat = Param.JSON;

}
