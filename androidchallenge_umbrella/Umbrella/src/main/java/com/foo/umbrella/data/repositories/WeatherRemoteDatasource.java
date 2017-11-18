package com.foo.umbrella.data.repositories;

import com.foo.umbrella.data.api.WeatherService;
import com.foo.umbrella.data.model.WeatherData;

import retrofit2.adapter.rxjava.Result;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Aptivist-U001 on 11/1/2017.
 */

public class WeatherRemoteDatasource {
    private WeatherService weatherService;

    public WeatherRemoteDatasource(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public void retriebeWeatherForecast(String zipCode, Observer<Result<WeatherData>> observer){
        this.weatherService.forecastForZipObservable(zipCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
