package com.example.android.hw013_flickr.main;

import com.example.android.hw013_flickr.di.ActivityScope;
import com.example.android.hw013_flickr.di.AppComponent;

import dagger.Component;

/**
 * Created by Aptivist-U001 on 10/27/2017.
 */

@Component(dependencies = AppComponent.class, modules = {MainModule.class})
@ActivityScope
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
