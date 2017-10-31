package com.example.android.hw013_flickr.data.remote;

import com.example.android.hw013_flickr.data.entities.ResultApi;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Aptivist-U001 on 10/28/2017.
 */

public class RemoteDataSource {
    private FlickrService flickrService;

    public RemoteDataSource(FlickrService flickrService) {
        this.flickrService = flickrService;
    }

    public void retrievePhotos(String tags, Observer<ResultApi> observer){
        flickrService.retrievePhotos(tags)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
