package com.example.android.et021_dagger2.di;

import com.example.android.et021_dagger2.MainActivity;

import dagger.Component;

/**
 * Created by Aptivist-U001 on 10/26/2017.
 */

@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);

    Another getAnother();
}
