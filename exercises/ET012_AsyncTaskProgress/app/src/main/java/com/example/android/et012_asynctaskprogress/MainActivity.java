package com.example.android.et012_asynctaskprogress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyTask.OnPogressUpdate {

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.a_main_progress);
    }

    public void showMagic(View view) {
        Toast.makeText(this, "Hello World!", Toast.LENGTH_SHORT).show();
    }

    public void startMagic(View view) {
        MyTask myTask = new MyTask(this);
        myTask.execute();
    }

    @Override
    public void onPogressUpdateCallback(Integer value) {
        progressBar.setProgress(value);
    }
}
