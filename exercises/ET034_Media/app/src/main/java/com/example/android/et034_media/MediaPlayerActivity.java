package com.example.android.et034_media;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;

public class MediaPlayerActivity extends AppCompatActivity {

    private static final String VIDEO_URL = "http://techslides.com/demos/sample-videos/small.mp4";

    private SurfaceHolder surfaceHolder;
    private SurfaceView surfaceView;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        surfaceView = findViewById(R.id.a_media_surface);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                mediaPlayer = MediaPlayer.create(MediaPlayerActivity.this, Uri.parse(VIDEO_URL));
                mediaPlayer.setDisplay(surfaceHolder);
                mediaPlayer.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
    }
}
