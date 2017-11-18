package com.example.android.redditlikeproject;

import android.app.Application;

import com.example.android.redditlikeproject.di.AppComponent;
import com.example.android.redditlikeproject.di.AppModule;
import com.example.android.redditlikeproject.di.DaggerAppComponent;

/**
 * Created by Aptivist-U001 on 11/13/2017.
 */

public class RedditLikeApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
