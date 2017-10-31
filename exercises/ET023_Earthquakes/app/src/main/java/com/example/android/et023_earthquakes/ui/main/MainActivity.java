package com.example.android.et023_earthquakes.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.mock.MockApplication;
import android.util.Log;
import android.widget.Toast;

import com.example.android.et023_earthquakes.App;
import com.example.android.et023_earthquakes.R;
import com.example.android.et023_earthquakes.data.entities.Feature;

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
        injectDependencies();
        mainPresenter.attachView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.loadEarthquakes();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void injectDependencies() {
        DaggerMainComponent.builder()
                .applicationComponent(((App) getApplication()).getApplicationComponent())
                .mainModule(new MainModule())
                .build()
                .inject(this);
    }

    @Override
    public void showResults(List<Feature> results) {
        for (Feature result : results) {
            Log.d(TAG, "showResults: " + result);
        }
    }

    @Override
    public void showProgress() {
        // TODO: 10/27/2017
    }

    @Override
    public void hideProgress() {
        // TODO: 10/27/2017
    }
}
