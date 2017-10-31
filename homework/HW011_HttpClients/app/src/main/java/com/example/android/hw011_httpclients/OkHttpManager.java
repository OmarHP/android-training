package com.example.android.hw011_httpclients;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Aptivist-U001 on 10/24/2017.
 */

public class OkHttpManager {

    private OkHttpClient okHttpClient;

    public OkHttpManager(File cacheLoc){
        System.out.println("Cache dir: " + cacheLoc);
        int cacheSize = 10 * 1024 * 1024; //10MiB
        Cache cache = new Cache(cacheLoc, cacheSize);
        okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }

    public void initDownload(String url){
        final Request request = new Request.Builder()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
                System.out.println("Response 1 response:          " + response);
                System.out.println("Response 1 cache response:    " + response.cacheResponse());
                System.out.println("Response 1 network response:  " + response.networkResponse());
            }
        });
    }
}
