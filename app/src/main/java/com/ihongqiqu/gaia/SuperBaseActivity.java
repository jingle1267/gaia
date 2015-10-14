package com.ihongqiqu.gaia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.ihongqiqu.gaia.request.Data;
import com.ihongqiqu.gaia.request.Param;
import com.ihongqiqu.gaia.request.Requestable;
import java.util.ArrayList;

/**
 * Activity的超级基类
 * <p/>
 * Created by zhenguo on 10/14/15.
 */
public class SuperBaseActivity extends AppCompatActivity implements Requestable {

    ArrayList<String> tags = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void addTag(String tag) {
        if (tags == null) {
            tags = new ArrayList<String>();
        }

        if (!tags.contains(tag)) {
            tags.add(tag);
        }
    }

    @Override
    public void get(String tag, Param param, Class<? extends Data> cls) {
        addTag(tag);
    }

    @Override
    public void post(String tag, Param param, Class<? extends Data> cls) {
        addTag(tag);
    }
}
