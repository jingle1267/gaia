package com.ihongqiqu.gaia.request;

import com.ihongqiqu.gaia.request.Data;
import com.ihongqiqu.gaia.request.Param;

/**
 * 请求接口
 *
 * Created by zhenguo on 10/14/15.
 */
public interface Requestable {

    void get(String tag, Param param, Class<? extends Data> cls);

    void post(String tag, Param param, Class<? extends Data> cls);

}
