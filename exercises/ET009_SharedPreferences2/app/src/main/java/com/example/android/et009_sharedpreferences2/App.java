package com.example.android.et009_sharedpreferences2;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Aptivist-U001 on 10/18/2017.
 */

public class App extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
