package com.example.android.androidoreo

import android.app.PendingIntent.getActivity
import android.app.PictureInPictureParams
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Rational
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pip.*

class PipActivity : AppCompatActivity() {

    val TAG = "${PipActivity::class.java.simpleName}_TAG_"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pip)

        a_pip_btn.setOnClickListener({v -> enterPIP()})
        Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(imageView);
    }

    fun enterPIP(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val pictureInPictureParams = PictureInPictureParams.Builder()
                    .setAspectRatio(Rational(imageView.width, imageView.height))
                    .build()
            this.enterPictureInPictureMode(pictureInPictureParams)
        };
    }

//    override fun onBackPressed() {
//        enterPIP()
//    }

    override fun onPictureInPictureModeChanged(isInPictureInPictureMode: Boolean, newConfig: Configuration?) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)
        if(isInPictureInPictureMode){
            supportActionBar?.hide()
            a_pip_btn.visibility = View.GONE
        }else{
            supportActionBar?.show()
            a_pip_btn.visibility = View.VISIBLE
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(TAG, "New intent: $intent" )
    }

}
