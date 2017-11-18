package com.example.android.et040_httpmethods.entities

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.Result
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor



/**
 * Created by Aptivist-U001 on 11/9/2017.
 */
object RetrofitFactory {
    private val BASE_URL = "http://10.0.2.2:3000/"

    fun createService(): CommentService {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
                //.client(client)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CommentService::class.java)
    }

    interface CommentService {
        @GET("/comments")
        fun retrieveAllComments(): Single<List<Comment>>

        @GET("/comments/{id}")
        fun retrieveCommentById(@Path("id") id: Int): Single<Comment>

        @POST("/comments/")
        fun createComment(@Body() comment: Comment): Single<Result<Comment>>

        @PUT("/comments/{id}")
        fun updateComment(@Path("id") id: Int, @Body() comment: Comment): Single<Comment>

        @DELETE("/comments/{id}")
        fun deleteComment(@Path("id") id: Int): Completable


    }
}