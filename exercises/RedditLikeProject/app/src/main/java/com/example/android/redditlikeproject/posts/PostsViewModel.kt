package com.example.android.redditlikeproject.posts

import android.app.Application
import android.arch.lifecycle.*
import android.text.TextUtils
import android.util.Log
import com.example.android.redditlikeproject.data.RedditLikeRepository
import com.example.android.redditlikeproject.data.entities.Post
import com.example.android.redditlikeproject.vo.Resource
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.*
import javax.inject.Inject

/**
 * Created by Aptivist-U001 on 11/13/2017.
 */
class PostsViewModel @Inject constructor(val redditLikeRepository: RedditLikeRepository) : ViewModel() {
    /**
     * Static members
     */
    companion object {
        private val TAG: String = "${PostsViewModel.javaClass.simpleName}_TAG_"
    }

    val query: MutableLiveData<String?> = MutableLiveData()
    val result: LiveData<Resource<List<Post>>> = Transformations.switchMap(query){ redditLikeRepository.retrievePosts(it) }

    init {
        query.value = null
    }

    fun doSearch(query: String?){
        if(TextUtils.equals(query, this.query.value)){
            return
        }
        this.query.value = query
    }

}