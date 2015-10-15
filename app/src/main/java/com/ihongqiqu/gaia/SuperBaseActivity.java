package com.ihongqiqu.gaia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.ihongqiqu.gaia.request.Data;
import com.ihongqiqu.gaia.request.Param;
import com.ihongqiqu.gaia.request.RequestManager;
import com.ihongqiqu.gaia.request.Requestable;
import de.greenrobot.event.EventBus;

/**
 * Activity的超级基类
 * <p/>
 * Created by zhenguo on 10/14/15.
 */
public class SuperBaseActivity extends AppCompatActivity implements Requestable {

    private RequestManager requestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void doRequest(String tag, Param param, Class<? extends Data> cls) {
        if (requestManager == null) {
            requestManager = new RequestManager(this);
        }
        requestManager.doRequest(tag, param, cls);
    }
}
