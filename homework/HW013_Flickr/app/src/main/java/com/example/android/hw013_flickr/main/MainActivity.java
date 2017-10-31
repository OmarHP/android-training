package com.example.android.hw013_flickr.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.mock.MockApplication;
import android.util.Log;
import android.widget.Toast;

import com.example.android.hw013_flickr.App;
import com.example.android.hw013_flickr.R;
import com.example.android.hw013_flickr.data.entities.Item;
import com.example.android.hw013_flickr.di.AppComponent;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG_";

    @Inject
    MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        injectDependencies();
        mainPresenter.attachView(this);
        getSupportActionBar().hide();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.loadPhotos();
    }

    @Override
    public void injectDependencies() {
        AppComponent appComponent = ((App) getApplication()).getAppComponent();
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainModule(new MainModule())
                .build().inject(this);
    }

    @Override
    public void showResults(List<Item> results) {
        for (Item result : results) {
            Log.d(TAG, "showResults: " +result);
        }
    }

    @Override
    public void showProgress() {
        Toast.makeText(this, "Loading photos", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgress() {
        Toast.makeText(this, "Photos loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
