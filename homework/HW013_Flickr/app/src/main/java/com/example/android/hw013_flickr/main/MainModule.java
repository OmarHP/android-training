package com.example.android.hw013_flickr.main;

import android.content.Context;

import com.example.android.hw013_flickr.data.FlickrRepository;
import com.example.android.hw013_flickr.di.ActivityScope;

import java.util.Date;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aptivist-U001 on 10/27/2017.
 */
@Module
public class MainModule {

    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter(FlickrRepository flickrRepository){
        return new MainPresenter(flickrRepository);
    }

}
