package com.example.android.et020_mvp.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.android.et020_mvp.R;
import com.example.android.et020_mvp.data.FakeRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String TAG = MainActivity.class.getName() + "_TAG_";

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(new FakeRepository());
        mainPresenter.attachView(this);
        mainPresenter.loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        // TODO: 10/25/2017
    }

    @Override
    public void hideProgress() {
        // TODO: 10/25/2017
    }

    @Override
    public void showResults(List<String> results) {
        for (String result : results) {
            Log.d(TAG, "showResults: " + result);
        }
    }
}
