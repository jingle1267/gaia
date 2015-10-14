package com.ihongqiqu.gaia;

import android.app.Application;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 *
 *
 * Created by zhenguo on 10/14/15.
 */
public class SuperBaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
    }
}
