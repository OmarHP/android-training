package com.example.android.et023_earthquakes.data;

import com.example.android.et023_earthquakes.data.entities.ResultApi;
import com.example.android.et023_earthquakes.data.local.LocalDataSource;
import com.example.android.et023_earthquakes.data.remote.RemoteDataSource;

import io.reactivex.Observer;

/**
 * Created by Aptivist-U001 on 10/27/2017.
 */

public class EarthquakeRepository {
    private LocalDataSource localDataSource;
    private RemoteDataSource remoteDataSource;

    public EarthquakeRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public void retrieveEarthquakes(String startDate, String endDate, Observer<ResultApi> observer){
        // TODO: 10/27/2017 Get earthquakes from the database first
        remoteDataSource.retrieveEarthquakes(startDate, endDate, observer);
    }
}
