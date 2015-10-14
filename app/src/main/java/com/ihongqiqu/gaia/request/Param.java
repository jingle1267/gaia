package com.ihongqiqu.gaia.request;

/**
 * 参数
 *
 * Created by zhenguo on 10/14/15.
 */
public interface Param {

    int GET = 0;
    int POST = 1;
    int UPLOAD = 2;

    int String = 0;
    int JSON = 1;
    int XML = 2;

    /**
     * 请求方式 get post upload 默认GET
     */
    int method = Param.GET;
    /**
     * 返回数据格式 JSON XML String 默认JSON
     */
    int dataFormat = Param.JSON;

}
