package com.example.android.et023_earthquakes.ui.main;

import com.example.android.et023_earthquakes.data.EarthquakeRepository;
import com.example.android.et023_earthquakes.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aptivist-U001 on 10/27/2017.
 */
@Module
public class MainModule {

    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter(EarthquakeRepository earthquakeRepository){
        return new MainPresenter(earthquakeRepository);
    }
}
