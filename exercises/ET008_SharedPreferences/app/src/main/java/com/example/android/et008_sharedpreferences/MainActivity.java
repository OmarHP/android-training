package com.example.android.et008_sharedpreferences;

import android.Manifest;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String MY_SHARED_KEY = "MY_KEY";
    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveMagic(View view) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MY_SHARED_KEY, new Date().toString());
        editor.commit(); //or .apply() to be done in a separated thread
    }

    public void loadMagic(View view) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String savedDate = sharedPreferences.getString(MY_SHARED_KEY, null);
        Log.d(TAG, "loadMagic: " + savedDate);
    }
}
