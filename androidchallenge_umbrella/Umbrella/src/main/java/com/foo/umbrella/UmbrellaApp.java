package com.foo.umbrella;

import android.app.Application;

import com.foo.umbrella.di.AppComponent;
import com.foo.umbrella.di.AppModule;
import com.foo.umbrella.di.DaggerAppComponent;
import com.foo.umbrella.di.NetworkModule;
import com.jakewharton.threetenabp.AndroidThreeTen;

public class UmbrellaApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
