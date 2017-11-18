package com.example.android.redditlikeproject.data.remote

import com.example.android.redditlikeproject.data.entities.Post


import io.reactivex.Observable
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Aptivist-U001 on 11/13/2017.
 */

interface RedditLikeService {

    @GET("/POSTS/")
    fun retrievePosts(@Query("q") q:String?): Observable<Result<List<Post>>>

    companion object {
        val BASE_URL = "http://10.0.2.2:3000/"
    }
}
