package com.ihongqiqu.gaia;

import android.app.Fragment;
import android.os.Bundle;
import com.ihongqiqu.gaia.request.Data;
import com.ihongqiqu.gaia.request.RequestParam;
import com.ihongqiqu.gaia.request.RequestManager;
import com.ihongqiqu.gaia.request.Requestable;
import de.greenrobot.event.EventBus;

/**
 * Fragment框架基类
 * <p/>
 * Created by zhenguo on 10/14/15.
 */
public class SuperBaseFragment extends Fragment implements Requestable {

    private RequestManager requestManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (requestManager != null) {
            requestManager.cancelAllRequest();
        }
    }

    @Override
    public void doRequest(RequestParam requestParam, Class<? extends Data> cls) {
        if (requestManager == null) {
            requestManager = new RequestManager(getActivity());
        }
        requestManager.doRequest(requestParam, cls);
    }

}
