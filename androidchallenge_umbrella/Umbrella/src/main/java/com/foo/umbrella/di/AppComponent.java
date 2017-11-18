package com.foo.umbrella.di;

import android.app.Application;
import android.content.SharedPreferences;

import com.foo.umbrella.data.repositories.WeatherRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aptivist-U001 on 11/1/2017.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, RepositoryModule.class})
public interface AppComponent {
    WeatherRepository weatherRepository();
    SharedPreferences sharedPreferences();

}
