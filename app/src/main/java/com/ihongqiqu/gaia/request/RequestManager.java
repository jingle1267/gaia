package com.ihongqiqu.gaia.request;

import android.content.Context;
import android.text.TextUtils;
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
 * 请求管理，可以添加和取消请求
 * 还可以扩展数据的格式
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
     *
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
    public void doRequest(RequestParam requestParam, Class<? extends Data> cls) {
        if (requestParam == null) {
            requestParam = new RequestParam();
        }

        if (!TextUtils.isEmpty(requestParam.getTag())) {
            addTag(requestParam.getTag());
        }

        if (BuildConfig.DEBUG) Log.d("RequestManager", "send request");
        // 对请求不同的数据的接口做不同的处理
        if (requestParam.getDataFormat() == RequestParam.DataFormat.JSON) {
            requestJSON(requestParam, cls);
        } else if (requestParam.getDataFormat() == RequestParam.DataFormat.XML) {
            requestXML(requestParam, cls);
        } else {
            requestString(requestParam, cls);
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

    private void requestJSON(final RequestParam requestParam, final Class<? extends Data> cls) {
        // 设置参数
        setUrlParams(requestParam);

        StringRequest stringRequest = new StringRequest(requestParam.getMethod(), requestParam.getUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Data data = getGson().fromJson(response, cls);
                if (!TextUtils.isEmpty(requestParam.getTag())) {
                    data.tag = requestParam.getTag();
                }
                EventBus.getDefault().post(data);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // 不设置tag的请求不处理错误
                if (!TextUtils.isEmpty(requestParam.getTag())) {
                    EventBus.getDefault().post(new ErrorEvent(requestParam.getTag(), error.networkResponse != null ? error.networkResponse.statusCode : 99, error.getMessage()));
                }
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (requestParam.getMethod() == RequestParam.Method.POST) {
                    return requestParam.getParams();
                }
                return null;
            }
        };

        if (!TextUtils.isEmpty(requestParam.getTag())) {
            stringRequest.setTag(requestParam.getTag());
        }

        getRequestQueue().add(stringRequest);
    }

    private void requestXML(RequestParam requestParam, Class<? extends Data> cls) {
        // TODO 请求XML数据

        // TODO 设置参数
    }

    private void requestString(final RequestParam requestParam, Class<? extends Data> cls) {
        // 设置参数
        setUrlParams(requestParam);

        StringRequest stringRequest = new StringRequest(requestParam.getMethod(), requestParam.getUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!TextUtils.isEmpty(requestParam.getTag())) {
                    EventBus.getDefault().post(new StringEvent(requestParam.getTag(), response));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (!TextUtils.isEmpty(requestParam.getTag())) {
                    EventBus.getDefault().post(new ErrorEvent(requestParam.getTag(), error.networkResponse != null ? error.networkResponse.statusCode : 99, error.getMessage()));
                }
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (requestParam.getMethod() == RequestParam.Method.POST) {
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
        if (requestParam != null && requestParam.getParams() != null && requestParam.getMethod() == RequestParam.Method.GET) {
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
