package com.ihongqiqu.gaia.sample;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.ihongqiqu.gaia.BuildConfig;
import com.ihongqiqu.gaia.R;
import com.ihongqiqu.gaia.SuperBaseActivity;
import com.ihongqiqu.gaia.request.ErrorEvent;
import com.ihongqiqu.gaia.request.RequestParam;
import com.ihongqiqu.gaia.request.StringEvent;

public class MainActivity extends SuperBaseActivity {

    @Bind(R.id.sdv_sample)
    SimpleDraweeView sdvSample;
    @Bind(R.id.tv_data)
    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .build();
        Fresco.initialize(this, config);

        sdvSample.setImageURI(Uri.parse("https://raw.githubusercontent.com/jingle1267/TestResource/master/imgs/Jellyfish.jpg"));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_request_string:
                requestStringData();
                break;
            case R.id.btn_request_json:
                requestJsonData();
                break;
        }
    }

    private void requestStringData() {
        RequestParam requestParam = new RequestParam();
        requestParam.setUrl("http://wap.baidu.com");
        requestParam.setDataFormat(RequestParam.String);
        doRequest("string", requestParam, null);
    }

    private void requestJsonData() {
        RequestParam requestParam = new RequestParam();
        requestParam.setUrl("https://raw.githubusercontent.com/jingle1267/TestResource/master/data/address.json");
        requestParam.setDataFormat(RequestParam.JSON);
        doRequest("json", requestParam, AddressRequest.class);
    }

    public void onEvent(AddressRequest addressRequest) {
        if (BuildConfig.DEBUG) Log.d("MainActivity", addressRequest.toString());
        tvData.setText(addressRequest.toString());
    }

    public void onEvent(StringEvent stringEvent) {
        if (BuildConfig.DEBUG) Log.d("MainActivity", stringEvent.toString());
        tvData.setText(stringEvent.toString());
    }

    public void onEvent(ErrorEvent errorEvent) {
        if (BuildConfig.DEBUG) Log.d("MainActivity", errorEvent.toString());
        tvData.setText(errorEvent.toString());
    }

}
