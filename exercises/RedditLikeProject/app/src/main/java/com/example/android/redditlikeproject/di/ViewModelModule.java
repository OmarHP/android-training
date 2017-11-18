package com.example.android.redditlikeproject.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.android.redditlikeproject.ViewModel.RedditLikeViewModelFactory;
import com.example.android.redditlikeproject.posts.PostsViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Aptivist-U001 on 11/13/2017.
 */

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel.class)
    abstract ViewModel bindUserViewModel(PostsViewModel userViewModel);

//    @Binds
//    @IntoMap
//    @ViewModelKey(SearchViewModel.class)
//    abstract ViewModel bindSearchViewModel(SearchViewModel searchViewModel);
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(RepoViewModel.class)
//    abstract ViewModel bindRepoViewModel(RepoViewModel repoViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(RedditLikeViewModelFactory factory);
}