package com.ihongqiqu.gaia.request;

import android.content.Context;

import java.util.HashMap;

/**
 * 添加中间层省去调用的时候填写请求格式
 * Created by liuxuegang1 on 2015/10/19.
 * 格式现有的XML，JSON，String三种
 */
public class HttpApi {

    public static void requestGetBeanByJson(Context context,HashMap<String,String> map,String url,String tag,Class<? extends Data> cls){
        RequestParam requestParam = new RequestParam();
        RequestManager manager=new RequestManager(context);
        if(map!=null){
            requestParam.addParams(map);
        }
        requestParam.setUrl(url);
        requestParam.setDataFormat(RequestParam.DataFormat.JSON);
        requestParam.setMethod(RequestParam.Method.GET);
        requestParam.setTag(tag);
        manager.doRequest(requestParam, cls);
    }
    public static void requestGetBeanByXml(Context context,String url,HashMap<String,String> map,String tag,Class<? extends Data> cls){
        RequestParam requestParam = new RequestParam();
        RequestManager manager=new RequestManager(context);
        if(map!=null){
            requestParam.addParams(map);
        }
        requestParam.setUrl(url);
        requestParam.setDataFormat(RequestParam.DataFormat.XML);
        requestParam.setMethod(RequestParam.Method.GET);
        requestParam.setTag(tag);
        manager.doRequest(requestParam, cls);
    }
    public static void requestGetBeanByString(Context context,HashMap<String,String> map,String url,String tag){
        RequestParam requestParam = new RequestParam();
        RequestManager manager=new RequestManager(context);
        if(map!=null){
            requestParam.addParams(map);
        }
        requestParam.setUrl(url);
        requestParam.setDataFormat(RequestParam.DataFormat.String);
        requestParam.setMethod(RequestParam.Method.GET);
        requestParam.setTag(tag);
        manager.doRequest(requestParam, null);
    }
}
