package yimin.sun.imagepagersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;

import yimin.sun.imagepager.ImagePager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fresco.initialize(this);

        ImagePager imagePager = (ImagePager) findViewById(R.id.image_pager);
        imagePager.setScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        imagePager.setData(new String[]{
                "https://public.artdenshop.com/5861e3e5f7077a29ab48452c_model_1_big.png",
                "https://public.artdenshop.com/5861e3e5f7077a29ab48452c_model_2_big.png",
                "https://public.artdenshop.com/5864cd6cf7077a29ab484bbc_model_1_big.png",
                "https://public.artdenshop.com/5864cd6cf7077a29ab484bbc_model_2_big.png"
        });
    }
}
