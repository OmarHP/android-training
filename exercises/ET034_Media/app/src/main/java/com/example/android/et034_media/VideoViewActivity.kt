package com.example.android.et034_media

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_video_view.*

class VideoViewActivity : AppCompatActivity() {


    private val VIDEO_URL: String? = "http://techslides.com/demos/sample-videos/small.mp4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)

        a_video_view.setVideoURI(Uri.parse(VIDEO_URL))
        a_video_view.start();
    }
}
