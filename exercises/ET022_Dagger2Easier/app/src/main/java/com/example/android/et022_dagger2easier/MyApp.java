package com.example.android.et022_dagger2easier;

import android.app.Application;

/**
 * Created by Aptivist-U001 on 10/26/2017.
 */

public class MyApp extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate(){
        super.onCreate();
        //Dagger%COMPONENT_NAME%
        mNetComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule("https://api.github.com"))
                .build();
    }

    public NetComponent getmNetComponent(){
        return mNetComponent;
    }

}
