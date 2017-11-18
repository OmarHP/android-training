package com.example.android.redditlikeproject

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.Transformations
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_borrar.*
import java.util.*

class BorrarActivity : AppCompatActivity() {

    companion object {
        val TAG = "${BorrarActivity::class.java}_TAG_"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrar)

        val userId: MutableLiveData<String> = MutableLiveData<String>()
        userId.value = "Omar"
        val user = Transformations.switchMap<String, User>(userId) { id -> getUser(id) }

        user.observe(this, Observer { Log.d(TAG,it?.username) })

        a_borrar_new.setOnClickListener{v -> run{userId.value = "another"}}
        a_borrar_null.setOnClickListener { v -> run{userId.value = null}  }
    }

    private fun getUser(name: String?): LiveData<User> {
        val user = MutableLiveData<User>()
        user.value = User(name + "Rex")
        return user
    }

    private class User(var username: String?)
}
