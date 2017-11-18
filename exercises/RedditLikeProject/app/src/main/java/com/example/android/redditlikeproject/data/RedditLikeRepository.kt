package com.example.android.redditlikeproject.data

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.android.redditlikeproject.data.entities.Post
import com.example.android.redditlikeproject.data.remote.RemoteDataSource
import com.example.android.redditlikeproject.vo.Resource
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton
import javax.xml.transform.Result

/**
 * Created by Aptivist-U001 on 11/13/2017.
 */
@Singleton
class RedditLikeRepository @Inject constructor(val remoteDataSource: RemoteDataSource){


    fun retrievePosts(query: String?): LiveData<Resource<List<Post>>>{
        val result = MutableLiveData<Resource<List<Post>>>()
        remoteDataSource.retrievePosts(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe{result.value = Resource.loading(null)}
                //.delay (6, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe{res -> run{
                    if(res.isError){
                        result.value = Resource.error(res.error()?.message, null)
                    }else{
                        val response = res.response()
                        when(response?.code()){
                            200 -> result.value = Resource.success(response.body())
                            else -> result.value = Resource.error(response?.code().toString(), null)
                        }
                    }
                }}
        return result;
    }

}