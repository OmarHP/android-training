package com.example.android.hw013_flickr.di;

import android.content.Context;

import com.example.android.hw013_flickr.data.FlickrRepository;
import com.example.android.hw013_flickr.main.MainActivity;
import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by Aptivist-U001 on 10/27/2017.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, RepositoryModule.class})
public interface AppComponent {

    Context context();
    FlickrRepository flickrRepository();

}
