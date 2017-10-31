package com.example.android.hw013_flickr.data.remote;

import com.example.android.hw013_flickr.data.entities.ResultApi;

import javax.xml.transform.Result;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Aptivist-U001 on 10/28/2017.
 */

public interface FlickrService {
    static final String BASE_URL = "http://api.flickr.com";

    @GET("/services/feeds/photos_public.gne?nojsoncallback=1&tagmode=any&format=json")
    Observable<ResultApi> retrievePhotos(@Query("tags") String tags);
}
