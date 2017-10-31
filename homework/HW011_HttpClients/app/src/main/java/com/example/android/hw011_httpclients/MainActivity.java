package com.example.android.hw011_httpclients;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String API_URL = "https://randomuser.me/api";
    RetrofitManager retrofitManager;
    OkHttpManager okHttpManager;
    VolleyManager volleyManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofitManager = new RetrofitManager();
        okHttpManager = new OkHttpManager(getApplicationContext().getCacheDir());
        volleyManager = new VolleyManager(this);
    }

    public void doRetrofitAndJacksonMagic(View view) {
        retrofitManager.requestRandomUserList(10);
    }

    public void doOkHttpMagic(View view) {
        okHttpManager.initDownload("http://publicobject.com/helloworld.txt");
    }

    public void loadImageWithVolley(View view) {
        volleyManager.loadImage("https://dummyimage.com/600x400/000/00ffb7", new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                ((ImageView) findViewById(R.id.a_main_iv_image)).setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
    }
}
