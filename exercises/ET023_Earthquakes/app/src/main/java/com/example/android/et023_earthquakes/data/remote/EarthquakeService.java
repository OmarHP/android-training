package com.example.android.et023_earthquakes.data.remote;



import com.example.android.et023_earthquakes.data.entities.ResultApi;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Aptivist-U001 on 10/27/2017.
 */

public interface EarthquakeService {

    static final String BASE_URL = "https://earthquake.usgs.gov";

    @GET("/fdsnws/event/1/query?format=geojson")
    Observable<ResultApi> retrieveEarthquakes(@Query("starttime")String startTime, @Query("endtime") String endtime);

}
