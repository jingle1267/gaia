package com.ihongqiqu.gaia.sample;

import android.net.Uri;
import android.os.Bundle;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.ihongqiqu.gaia.R;
import com.ihongqiqu.gaia.SuperBaseActivity;

public class MainActivity extends SuperBaseActivity {

    @Bind(R.id.sdv_sample)
    SimpleDraweeView sdvSample;

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
}
