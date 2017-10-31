package com.example.android.et023_earthquakes;

import android.app.Application;

import com.example.android.et023_earthquakes.di.ApplicationComponent;
import com.example.android.et023_earthquakes.di.DaggerApplicationComponent;
import com.example.android.et023_earthquakes.di.NetworkModule;
import com.example.android.et023_earthquakes.di.RepositoryModule;

/**
 * Created by Aptivist-U001 on 10/27/2017.
 */

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
        .repositoryModule(new RepositoryModule())
        .networkModule(new NetworkModule())
        .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
