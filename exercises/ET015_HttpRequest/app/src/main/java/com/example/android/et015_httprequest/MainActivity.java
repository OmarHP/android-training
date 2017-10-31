package com.example.android.et015_httprequest;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.volley.toolbox.Volley;
import com.example.android.et015_httprequest.managers.OkHttpManager;
import com.example.android.et015_httprequest.managers.RetrofitManager;
import com.example.android.et015_httprequest.managers.VolleyManager;

public class MainActivity extends AppCompatActivity {

    private static final String API_URL = "https://randomuser.me/api";
    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
    }

    public void httpMagic(View view) {
        MyTask myTask = new MyTask();
        myTask.execute(API_URL);
    }

    public void okHttpMagic(View view) {
        OkHttpManager okHttpManager = new OkHttpManager();
        okHttpManager.initDownload(API_URL);
    }

    public void retrofitMagic(View view) {
        RetrofitManager retrofitManager = new RetrofitManager();
        retrofitManager.initDownload();
    }

    public void retrofitListMagic(View view) {
        RetrofitManager retrofitManager = new RetrofitManager();
        retrofitManager.initDownload(10);
    }

    public void openResultActivity(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

    public void volleyMagic(View view) {
        VolleyManager volleyManager = new VolleyManager(this);
        volleyManager.initDownload(API_URL);
    }
}
