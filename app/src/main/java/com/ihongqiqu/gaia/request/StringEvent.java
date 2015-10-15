package com.ihongqiqu.gaia.request;

/**
 * 普通请求 返回String数据
 * <p/>
 * 主要包括 请求tag 和 请求数据字符串data
 *
 * Created by zhenguo on 10/15/15.
 */
public class StringEvent {

    /**
     * 请求tag
     */
    public String tag;
    /**
     * 正常请求返回数据
     */
    public String data;

    /**
     * 请求成功构造函数
     *
     * @param tag  请求tag
     * @param data 正常请求返回数据
     */
    public StringEvent(String tag, String data) {
        this.data = data;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "StringEvent{" +
                "data='" + data + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
