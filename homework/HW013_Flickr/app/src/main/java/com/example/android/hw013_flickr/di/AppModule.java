package com.example.android.hw013_flickr.di;

import android.content.Context;

import java.util.Date;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aptivist-U001 on 10/27/2017.
 */

@Module
public class AppModule {

    private Context appContext;

    public AppModule(Context context){
        appContext = context;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return appContext;
    }

}
