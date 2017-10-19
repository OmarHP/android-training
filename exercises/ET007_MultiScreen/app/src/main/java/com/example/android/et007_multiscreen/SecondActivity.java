package com.example.android.et007_multiscreen;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String user = intent.getStringExtra(Intent.EXTRA_TEXT);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(user);
    }
}
