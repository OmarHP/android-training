package com.example.android.et022_dagger2easier;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    //@Inject MyTwitterApiClient mTwitterApiClient;
    @Inject SharedPreferences sharedPreferences;
    @Inject Another another;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApp)getApplication()).getmNetComponent().inject(this);
        another.saySomething();
    }
}
