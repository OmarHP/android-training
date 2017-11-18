package com.foo.umbrella.di;

import android.app.Application;

import com.foo.umbrella.BuildConfig;
import com.foo.umbrella.data.ForecastConditionAdapter;
import com.foo.umbrella.data.MoshiAdapterFactory;
import com.foo.umbrella.data.api.WeatherService;
import com.squareup.moshi.Moshi;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

import static com.jakewharton.byteunits.DecimalByteUnit.MEGABYTES;

/**
 * Created by Aptivist-U001 on 11/1/2017.
 */
@Module
public class NetworkModule {

    private static final int DISK_CACHE_SIZE = (int) MEGABYTES.toBytes(50);

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Application application){
        // Install an HTTP cache in the application cache directory.
        File cacheDir = new File(application.getCacheDir(), "http");
        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        return new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }

    @Provides
    @Singleton
    Moshi provideMoshi(){
        return new Moshi.Builder()
                .add(new ForecastConditionAdapter())
                .add(MoshiAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client, Moshi moshi){
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    WeatherService provideWeatherService(Retrofit retrofit){
        return retrofit.create(WeatherService.class);
    }
}
