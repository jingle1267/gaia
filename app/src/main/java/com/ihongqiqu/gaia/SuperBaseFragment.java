package com.ihongqiqu.gaia;

import android.app.Fragment;
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

    ArrayList<String> tags = null;

    @Override
    public void get(String tag, Param param, Class<? extends Data> cls) {

    }

    @Override
    public void post(String tag, Param param, Class<? extends Data> cls) {

    }

    private void addTag(String tag) {
        if (tags == null) {
            tags = new ArrayList<String>();
        }

        if (!tags.contains(tag)) {
            tags.add(tag);
        }
    }
}
