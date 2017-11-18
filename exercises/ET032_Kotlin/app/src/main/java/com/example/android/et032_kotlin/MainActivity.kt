package com.example.android.et032_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import okhttp3.OkHttpClient
import java.util.*
import android.os.AsyncTask.execute
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Request
import java.io.IOException
import android.os.StrictMode




class MainActivity : AppCompatActivity() {

    val client = OkHttpClient();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        a_main_btn.setOnClickListener{println(run("https://google.com"))}
    }

    fun sayDate() : Date{
        return Date()
    }

    @Throws(IOException::class)
    fun run(url: String): String? {
        val request = Request.Builder()
                .url(url)
                .build()

        val response = client.newCall(request).execute()
        return response.body()?.string()
    }
}
