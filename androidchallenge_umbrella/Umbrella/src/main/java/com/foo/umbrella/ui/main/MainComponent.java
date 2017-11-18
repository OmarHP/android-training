package com.foo.umbrella.ui.main;

import com.foo.umbrella.di.ActivityScope;
import com.foo.umbrella.di.AppComponent;

import dagger.Component;

/**
 * Created by Aptivist-U001 on 11/1/2017.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
