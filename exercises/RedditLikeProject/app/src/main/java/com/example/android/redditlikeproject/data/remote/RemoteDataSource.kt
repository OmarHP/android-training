package com.example.android.redditlikeproject.data.remote

import com.example.android.redditlikeproject.data.entities.Post
import com.example.android.redditlikeproject.posts.PostsViewModel
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.adapter.rxjava2.Result
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Aptivist-U001 on 11/13/2017.
 */
@Singleton
class RemoteDataSource @Inject constructor(var redditLikeService: RedditLikeService){

    fun retrievePosts(query: String?): Observable<Result<List<Post>>>{
        return redditLikeService.retrievePosts(query)
    }


}