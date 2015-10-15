package com.ihongqiqu.gaia.request;

/**
 * 出错事件
 * <p/>
 * Created by zhenguo on 10/15/15.
 */
public class ErrorEvent {

    /**
     * 请求tag
     */
    public String tag;
    /**
     * 请求错误码 0表示请求正确
     */
    public int errCode = 0;
    /**
     * 请求出错信息
     */
    public String errMsg;

    /**
     * 请求出错构造函数
     *
     * @param tag     请求tag
     * @param errCode 请求错误码 0表示请求正确
     * @param errMsg  请求出错信息
     */
    public ErrorEvent(String tag, int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "ErrorEvent{" +
                "errCode=" + errCode +
                ", tag='" + tag + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
