package com.example.android.hw008_broadcastsender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startService(View view) {
        Intent intent = new Intent(this, SenderService.class);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this, SenderService.class);
        stopService(intent);
    }

    @Override
    protected void onDestroy() {
        Intent intent = new Intent(this, SenderService.class);
        stopService(intent);
        super.onDestroy();
    }
}
