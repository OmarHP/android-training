package com.example.android.redditlikeproject.di;

import com.example.android.redditlikeproject.posts.PostsActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aptivist-U001 on 11/13/2017.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, ViewModelModule.class})
public interface AppComponent {
    void inject(PostsActivity postsActivity);
}
