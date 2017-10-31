package com.example.android.hw013_flickr.data;

import com.example.android.hw013_flickr.data.entities.ResultApi;
import com.example.android.hw013_flickr.data.remote.RemoteDataSource;

import io.reactivex.Observer;

/**
 * Created by Aptivist-U001 on 10/28/2017.
 */

public class FlickrRepository {
    private RemoteDataSource remoteDataSource;

    public FlickrRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public void retrievePhotos(String tags, Observer<ResultApi> observer){
        //TODO: 10/28/2017 Get earthquakes from the database first
        remoteDataSource.retrievePhotos(tags, observer);
    }

}
