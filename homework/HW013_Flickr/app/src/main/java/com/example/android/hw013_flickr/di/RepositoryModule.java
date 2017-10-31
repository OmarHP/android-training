package com.example.android.hw013_flickr.di;

import com.example.android.hw013_flickr.data.FlickrRepository;
import com.example.android.hw013_flickr.data.remote.FlickrService;
import com.example.android.hw013_flickr.data.remote.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aptivist-U001 on 10/28/2017.
 */
@Module
public class RepositoryModule {



    @Provides
    @Singleton
    RemoteDataSource provideRemoteDataSource(FlickrService flickrService){
        return  new RemoteDataSource(flickrService);
    }

    @Provides
    @Singleton
    FlickrRepository provideFlickrRepository(RemoteDataSource remoteDataSource){
        return new FlickrRepository(remoteDataSource);
    }
}
