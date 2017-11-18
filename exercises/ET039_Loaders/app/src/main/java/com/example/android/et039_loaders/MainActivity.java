package com.example.android.et039_loaders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.a_main_btn);
        button.setOnClickListener(v -> {
            startActivity(new Intent(this, LoaderActivity.class));
        });
    }
}
