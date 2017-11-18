package com.example.android.et040_httpmethods

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android.et040_httpmethods.entities.Comment
import com.example.android.et040_httpmethods.entities.RetrofitFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val commentService : RetrofitFactory.CommentService = RetrofitFactory.createService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        a_main_all.setOnClickListener{retrieveAllComments()}
        a_main_create.setOnClickListener{createComment()}
        a_main_update.setOnClickListener{updateComment(2)}
        a_main_delete.setOnClickListener{deleteComment(2)}
        a_main_one.setOnClickListener{retrieveComment(1)}
    }

    fun retrieveAllComments(){
        commentService.retrieveAllComments()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { it.forEach { println(it) } })
    }

    private fun createComment() {
        val comment = Comment(2, "This is the body!", 1)
        commentService.createComment(comment)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {
                    val response = it.response()
                    println(response?.code())
                    when(response?.code()){
                        201 -> println(response.body())
                        else -> println(response?.message())
                    }
                })
    }

    private fun updateComment(id:Int) {
        val comment = Comment(id, "This is the body updated!", 1)
        commentService.updateComment(id, comment)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {println(it)})
    }

    private fun deleteComment(id: Int) {
        commentService.deleteComment(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ println("Comment $id deleted") })
    }

    private fun retrieveComment(id: Int) {
        commentService.retrieveCommentById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {println(it)})
    }
}
