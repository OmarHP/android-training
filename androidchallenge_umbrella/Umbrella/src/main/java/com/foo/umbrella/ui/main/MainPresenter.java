package com.foo.umbrella.ui.main;

import android.util.Log;

import com.foo.umbrella.data.model.CurrentObservation;
import com.foo.umbrella.data.model.DisplayLocation;
import com.foo.umbrella.data.model.ForecastCondition;
import com.foo.umbrella.data.model.WeatherData;
import com.foo.umbrella.data.repositories.WeatherRepository;

import org.threeten.bp.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import retrofit2.Response;
import retrofit2.adapter.rxjava.Result;
import rx.Observer;

/**
 * Created by Aptivist-U001 on 11/1/2017.
 */

public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = MainPresenter.class.getSimpleName() + "_TAG_";

    private MainContract.View view;
    private WeatherRepository weatherRepository;

    public MainPresenter(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void loadWeatherForecast(String zip) {
        view.showProgres();
        weatherRepository.retrieveWeatherForecast(zip, new Observer<Result<WeatherData>>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
                view.hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onNext(Result<WeatherData> weatherDataResult) {
                TreeMap<LocalDate, List<ForecastCondition>> days = new TreeMap<>();
                Response<WeatherData> response = weatherDataResult.response();
                WeatherData weatherData = response.body();
                for (ForecastCondition forecastCondition : weatherData.getForecast()) {
                    //Log.d(TAG, "onNext: " +forecastCondition.getDateTime());
                    LocalDate localDate= forecastCondition.getDateTime().toLocalDate();
                    if(days.containsKey(localDate)){
                        days.get(localDate).add(forecastCondition);
                    }else{
                        List<ForecastCondition> hours = new ArrayList<>();
                        hours.add(forecastCondition);
                        days.put(localDate, hours);
                    }
                }

                for (LocalDate day : days.keySet()) {
                    setMaxAndMin(days.get(day));
                }


                CurrentObservation currentObservation = weatherData.getCurrentObservation();

                view.showWeatherForecast(currentObservation, days);



            }
        });
    }


    public void setMaxAndMin(List<ForecastCondition> hours){
        ForecastCondition max = getMax(hours);
        ForecastCondition min = getMin(hours);
        if(max != min){
            max.setIsMax(true);
            min.setIsMin(true);
        }
    }

    public ForecastCondition getMax(List<ForecastCondition> hours){
        ForecastCondition max = hours.get(0);
        double maxTemp = Double.parseDouble(max.getTempFahrenheit());
        for(int i = 1; i < hours.size(); i++){
            ForecastCondition current = hours.get(i);
            double currentTemp = Double.parseDouble(current.getTempFahrenheit());
            if(currentTemp > maxTemp){
                maxTemp = currentTemp;
                max = current;
            }
        }
        return max;
    }

    public ForecastCondition getMin(List<ForecastCondition> hours){
        ForecastCondition min = hours.get(0);
        double minTemp = Double.parseDouble(min.getTempFahrenheit());
        for(int i = 1; i < hours.size(); i++){
            ForecastCondition current = hours.get(i);
            double currentTemp = Double.parseDouble(current.getTempFahrenheit());
            if(currentTemp < minTemp){
                minTemp = currentTemp;
                min = current;
            }
        }
        return min;
    }
}
