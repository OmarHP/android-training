package com.example.android.et023_earthquakes.data.remote;

import com.example.android.et023_earthquakes.data.entities.ResultApi;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Aptivist-U001 on 10/27/2017.
 */

public class RemoteDataSource {
    private EarthquakeService earthquakeService;

    public RemoteDataSource(EarthquakeService earthquakeService) {
        this.earthquakeService = earthquakeService;
    }

    public void retrieveEarthquakes(String startDate, String endDate, Observer<ResultApi> observer) {
        earthquakeService.retrieveEarthquakes(startDate,endDate)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
