package com.foo.umbrella.ui.main;

import com.foo.umbrella.data.repositories.WeatherRepository;
import com.foo.umbrella.di.ActivityScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aptivist-U001 on 11/1/2017.
 */
@Module
public class MainModule {

    @Provides
    @ActivityScope
    MainPresenter providePresenter(WeatherRepository weatherRepository){
        return new MainPresenter(weatherRepository);
    }
}
