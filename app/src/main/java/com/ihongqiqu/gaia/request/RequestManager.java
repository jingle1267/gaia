package com.ihongqiqu.gaia.request;

import android.content.Context;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.ihongqiqu.gaia.BuildConfig;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.Map;

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

    /**
     * 取消某个请求
     * @param tag
     */
    public void cancelRequest(String tag) {
        if (tags != null && tags.contains(tag) && requestQueue != null) {
            requestQueue.cancelAll(tag);
            tags.remove(tag);
        }
    }

    /**
     * 取消所有的请求
     */
    public void cancelAllRequest() {
        if (requestQueue != null && tags != null) {
            for (String tag : tags) {
                requestQueue.cancelAll(tag);
            }
        }
    }

    @Override
    public void doRequest(String tag, RequestParam requestParam, Class<? extends Data> cls) {
        if (requestParam == null) {
            requestParam = new RequestParam();
        }

        addTag(tag);

        if (BuildConfig.DEBUG) Log.d("RequestManager", "send request");
        // 对请求不同的数据的接口做不同的处理
        if (requestParam.getDataFormat() == RequestParam.JSON) {
            requestJSON(tag, requestParam, cls);
        } else if (requestParam.getDataFormat() == RequestParam.XML) {
            requestXML(tag, requestParam, cls);
        } else {
            requestString(tag, requestParam, cls);
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

    private void requestJSON(final String tag, final RequestParam requestParam, final Class<? extends Data> cls) {
        // 设置参数
        setUrlParams(requestParam);

        StringRequest stringRequest = new StringRequest(requestParam.getMethod(), requestParam.getUrl(), new Response.Listener<String>() {
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
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (requestParam.getMethod() == RequestParam.POST) {
                    return requestParam.getParams();
                }
                return null;
            }
        };

        stringRequest.setTag(tag);

        getRequestQueue().add(stringRequest);
    }

    private void requestXML(String tag, RequestParam requestParam, Class<? extends Data> cls) {
        // TODO 请求XML数据

        // TODO 设置参数
    }

    private void requestString(final String tag, final RequestParam requestParam, Class<? extends Data> cls) {
        // 设置参数
        setUrlParams(requestParam);

        StringRequest stringRequest = new StringRequest(requestParam.getMethod(), requestParam.getUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                EventBus.getDefault().post(new StringEvent(tag, response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                EventBus.getDefault().post(new ErrorEvent(tag, error.networkResponse != null ? error.networkResponse.statusCode : 99, error.getMessage()));
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (requestParam.getMethod() == RequestParam.POST) {
                    return requestParam.getParams();
                }
                return null;
            }
        };

        getRequestQueue().add(stringRequest);

    }

    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    private Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    /**
     * 设置GET请求方式的参数
     *
     * @param requestParam
     */
    private void setUrlParams(RequestParam requestParam) {
        if (requestParam != null && requestParam.getParams() != null && requestParam.getMethod() == RequestParam.GET) {
            StringBuilder paramSB = new StringBuilder();

            if (!requestParam.getUrl().endsWith("?")) {
                paramSB.append("?");
            }
            for (String s : requestParam.getParams().keySet()) {
                paramSB.append(s).append("=").append(requestParam.getParams().get(s));
            }

            requestParam.setUrl(requestParam.getUrl() + paramSB.toString());
        }

    }

}
