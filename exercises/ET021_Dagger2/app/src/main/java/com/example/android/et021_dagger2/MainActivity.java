package com.example.android.et021_dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.android.et021_dagger2.di.DaggerMainComponent;
import com.example.android.et021_dagger2.di.MainModule;

import javax.inject.Inject;

import dagger.Binds;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName() + "_TAG_";

    @Inject
    DateHelper dateHelper;

    @Inject
    PreferencesManager preferencesManager;

    @Inject
    public MainActivity(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    public void doMagic(View view) {
        Log.d(TAG, "doMagic: " + dateHelper.generateDate());
        preferencesManager.saveString("my_key", "Hello world");
        Log.d(TAG, "doMagic: " +preferencesManager.loadString("my_key"));
    }
}
