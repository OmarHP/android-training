package com.example.android.et002_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName() + "_TAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String value = intent.getStringExtra("MY_KEY");
        Log.d(TAG, "onCreate: " + value);
        ((TextView)(findViewById(R.id.a_second_tv_date))).setText(value);
    }
}
