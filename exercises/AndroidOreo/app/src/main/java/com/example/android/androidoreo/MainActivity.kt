package com.example.android.androidoreo

import android.app.PictureInPictureParams
import android.content.Intent
import android.content.res.Configuration
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName + "_TAG_"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Activity created")

        a_main_btn_pip.setOnClickListener{startActivity(Intent(this, PipActivity::class.java))}
        a_main_btn_notifications.setOnClickListener({v -> startActivity(Intent(this, NotificationsActivity::class.java))})
        a_main_btn_jobservice.setOnClickListener({v -> MyJobService.schedule(this)})
    }


}
