package com.ihongqiqu.gaia.request;

/**
 * 请求接口
 *
 * Created by zhenguo on 10/14/15.
 */
public interface Requestable {

    void doRequest(String tag, Param param, Class<? extends Data> cls);

}
