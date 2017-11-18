package com.foo.umbrella.di;

import com.foo.umbrella.data.api.WeatherService;
import com.foo.umbrella.data.repositories.WeatherRemoteDatasource;
import com.foo.umbrella.data.repositories.WeatherRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aptivist-U001 on 11/1/2017.
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    WeatherRemoteDatasource provideWeatherRemoteDatasource(WeatherService weatherService){
        return new WeatherRemoteDatasource(weatherService);
    }

    @Provides
    @Singleton
    WeatherRepository provideWeatherRepository(WeatherRemoteDatasource weatherRemoteDatasource){
        return  new WeatherRepository(weatherRemoteDatasource);
    }

}
