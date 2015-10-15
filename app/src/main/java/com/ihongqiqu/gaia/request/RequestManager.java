package com.ihongqiqu.gaia.request;

import android.content.Context;
import android.util.Log;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.ihongqiqu.gaia.BuildConfig;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;

/**
 * 请求管理类
 * <p/>
 * Created by zhenguo on 10/14/15.
 */
public class RequestManager implements Requestable {

    ArrayList<String> tags = null;
    RequestQueue requestQueue;
    Gson gson;
    Context context;

    public RequestManager(Context context) {
        this.context = context;
    }

    public void onCancel() {

    }

    @Override
    public void doRequest(String tag, Param param, Class<? extends Data> cls) {
        if (param == null) {
            param = new Param();
        }

        addTag(tag);

        if (BuildConfig.DEBUG) Log.d("RequestManager", "send request");
        if (param.dataFormat == Param.DataFormat.JSON) {
            requestJSON(tag, param, cls);
        } else if (param.dataFormat == Param.DataFormat.XML) {
            requestXML(tag, param, cls);
        } else {
            requestString(tag, param, cls);
        }
    }

    private void addTag(String tag) {
        if (tags == null) {
            tags = new ArrayList<>();
        }

        if (!tags.contains(tag)) {
            tags.add(tag);
        }
    }

    private void requestJSON(final String tag, Param param, final Class<? extends Data> cls) {
        // TODO 设置参数

        StringRequest stringRequest = new StringRequest(param.method, param.url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Data data = getGson().fromJson(response, cls);
                data.tag = tag;
                EventBus.getDefault().post(data);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                EventBus.getDefault().post(new ErrorEvent(tag, error.networkResponse != null ? error.networkResponse.statusCode : 99, error.getMessage()));
            }
        });

        getRequestQueue().add(stringRequest);
    }

    private void requestXML(String tag, Param param, Class<? extends Data> cls) {
        // TODO 请求XML数据

        // TODO 设置参数
    }

    private void requestString(final String tag, Param param, Class<? extends Data> cls) {
        // TODO 设置参数

        StringRequest stringRequest = new StringRequest(param.method, param.url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                EventBus.getDefault().post(new StringEvent(tag, response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                EventBus.getDefault().post(new ErrorEvent(tag, error.networkResponse != null ? error.networkResponse.statusCode : 99, error.getMessage()));
            }
        });

        getRequestQueue().add(stringRequest);

    }

    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        return  requestQueue;
    }

    private Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

}
