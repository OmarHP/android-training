package com.example.android.hw013_flickr;

import android.app.Application;

import com.example.android.hw013_flickr.di.AppComponent;
import com.example.android.hw013_flickr.di.AppModule;
import com.example.android.hw013_flickr.di.DaggerAppComponent;
import com.example.android.hw013_flickr.main.MainComponent;
import com.example.android.hw013_flickr.main.MainModule;

/**
 * Created by Aptivist-U001 on 10/27/2017.
 */

public class App extends Application {

    private AppComponent appComponent;
    public AppComponent getAppComponent(){
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

}
