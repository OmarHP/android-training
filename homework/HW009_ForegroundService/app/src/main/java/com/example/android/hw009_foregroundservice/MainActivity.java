package com.example.android.hw009_foregroundservice;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void playMusic(View view) {
        Log.d(TAG, "playMusic: enter");
        Intent startIntent = new Intent(this, MusicService.class);
        startIntent.setAction(MusicService.START_FOREGROUND_ACTION);
        startService(startIntent);
    }


    public void stopMusic(View view) {
        Intent stopIntent = new Intent(this, MusicService.class);
        stopIntent.setAction(MusicService.STOP_FOREGROUND_ACTION);
        startService(stopIntent);
    }
}
