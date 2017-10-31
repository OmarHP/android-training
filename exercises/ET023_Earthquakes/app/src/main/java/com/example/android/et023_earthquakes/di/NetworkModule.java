package com.example.android.et023_earthquakes.di;

import com.example.android.et023_earthquakes.data.EarthquakeRepository;
import com.example.android.et023_earthquakes.data.remote.EarthquakeService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aptivist-U001 on 10/27/2017.
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(EarthquakeService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    EarthquakeService provideEarthquakeService(Retrofit retrofit){
        return retrofit.create(EarthquakeService.class);
    }

}
