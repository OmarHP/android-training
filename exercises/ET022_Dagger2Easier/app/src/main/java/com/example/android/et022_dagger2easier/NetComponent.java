package com.example.android.et022_dagger2easier;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aptivist-U001 on 10/26/2017.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);
    // void inject(MyFragment fragment);
    // void inject(MyService service);
}
