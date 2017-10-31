package com.example.android.et023_earthquakes.di;

import com.example.android.et023_earthquakes.data.EarthquakeRepository;
import com.example.android.et023_earthquakes.data.local.LocalDataSource;
import com.example.android.et023_earthquakes.data.remote.EarthquakeService;
import com.example.android.et023_earthquakes.data.remote.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aptivist-U001 on 10/27/2017.
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    LocalDataSource provideLocalDatSource(){
        return new LocalDataSource();
    }

    @Provides
    @Singleton
    RemoteDataSource provideRemoteDataSource(EarthquakeService earthquakeService){
        return new RemoteDataSource(earthquakeService);
    }

    @Provides
    @Singleton
    EarthquakeRepository provideEarthquakeRepository(LocalDataSource localDataSource,
                                                     RemoteDataSource remoteDataSource){
        return new EarthquakeRepository(localDataSource, remoteDataSource);
    }
}
