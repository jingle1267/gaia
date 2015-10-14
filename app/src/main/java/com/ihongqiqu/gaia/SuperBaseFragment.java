package com.ihongqiqu.gaia;

import android.app.Fragment;
import android.os.Bundle;
import com.ihongqiqu.gaia.request.Data;
import com.ihongqiqu.gaia.request.Param;
import com.ihongqiqu.gaia.request.Requestable;
import java.util.ArrayList;

/**
 * Fragment框架基类
 * <p/>
 * Created by zhenguo on 10/14/15.
 */
public class SuperBaseFragment extends Fragment implements Requestable {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void doRequest(String tag, Param param, Class<? extends Data> cls) {

    }
}
