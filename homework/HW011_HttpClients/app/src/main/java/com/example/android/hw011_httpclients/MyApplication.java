package com.example.android.hw011_httpclients;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Aptivist-U001 on 10/24/2017.
 */

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
