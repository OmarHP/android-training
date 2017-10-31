package com.example.android.et023_earthquakes.di;

import com.example.android.et023_earthquakes.data.EarthquakeRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aptivist-U001 on 10/27/2017.
 */
@Singleton
@Component(modules = {NetworkModule.class, RepositoryModule.class})
public interface ApplicationComponent {
    EarthquakeRepository earthquakeRepository();
}
