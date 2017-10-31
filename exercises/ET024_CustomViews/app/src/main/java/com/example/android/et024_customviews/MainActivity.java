package com.example.android.et024_customviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.a_main_linear);
        frameLayout = findViewById(R.id.a_main_frame);
    }

    public void doMagic(View view) {
        linearLayout.addView(new Button(this));
    }

    public void doCustomMagic(View view) {
        frameLayout.addView(new MyRectangle(this));
    }
}
