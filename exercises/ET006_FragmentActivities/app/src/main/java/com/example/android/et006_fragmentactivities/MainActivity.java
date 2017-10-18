package com.example.android.et006_fragmentactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  BlueFragment.OnCallbackClicked{

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.a_main_txt);
    }

    public void setTextDate(String date){
        textView.setText(date);
    }


    @Override
    public void onClick(String message) {
        setTextDate(message);
    }
}
