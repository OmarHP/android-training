package com.example.android.et012_asynctaskprogress;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Aptivist-U001 on 10/19/2017.
 */

public class App extends Application {
    @Override public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
    }
}
