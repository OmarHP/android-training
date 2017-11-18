package com.foo.umbrella.data.repositories;

import com.foo.umbrella.data.model.WeatherData;

import retrofit2.adapter.rxjava.Result;
import rx.Observer;

/**
 * Created by Aptivist-U001 on 11/1/2017.
 */

public class WeatherRepository {
    private WeatherRemoteDatasource weatherRemoteDatasource;

    public WeatherRepository(WeatherRemoteDatasource weatherRemoteDatasource) {
        this.weatherRemoteDatasource = weatherRemoteDatasource;
    }

    public void retrieveWeatherForecast(String zipCode, Observer<Result<WeatherData>> observer){
        weatherRemoteDatasource.retriebeWeatherForecast(zipCode, observer);
    }
}
