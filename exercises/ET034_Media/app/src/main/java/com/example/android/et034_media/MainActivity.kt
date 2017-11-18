package com.example.android.et034_media

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val TYPE_VIDEO = 1
    val TYPE_MEDIA = 2
    val TYPE_EXO = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        a_main_video.setOnClickListener({triggerActivity(TYPE_VIDEO)})
        a_main_media.setOnClickListener({triggerActivity(TYPE_MEDIA)})
        a_main_exo.setOnClickListener({triggerActivity(TYPE_EXO)})
    }

    private fun triggerActivity(typeActivity: Int){
        val intent = when (typeActivity){
            TYPE_VIDEO -> Intent(this, VideoViewActivity::class.java)
            TYPE_MEDIA -> Intent(this, MediaPlayerActivity::class.java)
            else -> Intent(this, ExoPlayerActivity::class.java)
        }
        startActivity(intent)
    }

    private fun <T>triggerActivity(className: Class<T>){
        val intent = Intent(this, className)
        startActivity(intent)
    }
}
