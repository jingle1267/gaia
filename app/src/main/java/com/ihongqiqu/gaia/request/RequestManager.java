package com.ihongqiqu.gaia.request;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import java.util.ArrayList;

/**
 * 请求管理类
 * <p/>
 * Created by zhenguo on 10/14/15.
 */
public class RequestManager implements Requestable {

    ArrayList<String> tags = null;
    RequestQueue mQueue;

    public RequestManager(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    public void onCancel() {

    }

    @Override
    public void doRequest(String tag, Param param, Class<? extends Data> cls) {
        if (param == null) {
            param = new Param();
        }

        addTag(tag);

        if (param.dataFormat == Param.JSON) {
            requestJSON(tag, param, cls);
        } else if (param.dataFormat == Param.XML) {
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

    private void requestJSON(String tag, Param param, Class<? extends Data> cls) {

    }

    private void requestXML(String tag, Param param, Class<? extends Data> cls) {

    }

    private void requestString(String tag, Param param, Class<? extends Data> cls) {

    }

}
