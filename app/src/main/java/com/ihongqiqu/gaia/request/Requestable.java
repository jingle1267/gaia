package com.ihongqiqu.gaia.request;

/**
 * 请求接口
 * <p/>
 * Created by zhenguo on 10/14/15.
 */
public interface Requestable {

    /**
     * 发送网络请求
     *
     * @param tag          请求的tag 需要设置 除非不关心请求的结果
     * @param requestParam 请求的参数
     * @param cls          请求返回的实体对象
     */
    void doRequest(String tag, RequestParam requestParam, Class<? extends Data> cls);

}
