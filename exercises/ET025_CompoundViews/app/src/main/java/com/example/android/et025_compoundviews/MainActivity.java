package com.example.android.et025_compoundviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.a_main_linear);
    }

    public void doMagic(View view) {
        MyCompoundView myCompoundView = new MyCompoundView(this, null);
        linearLayout.addView(myCompoundView);
        myCompoundView.setImage("http://square.github.io/picasso/static/debug.png");
        myCompoundView.setText("Another name");
    }
}
