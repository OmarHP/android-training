package com.example.android.et023_earthquakes.ui.main;

import com.example.android.et023_earthquakes.di.ApplicationComponent;
import com.example.android.et023_earthquakes.di.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by Aptivist-U001 on 10/27/2017.
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
