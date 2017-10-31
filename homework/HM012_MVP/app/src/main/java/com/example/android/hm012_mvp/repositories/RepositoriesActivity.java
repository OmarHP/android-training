package com.example.android.hm012_mvp.repositories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.hm012_mvp.R;
import com.example.android.hm012_mvp.data.ApiRepository;
import com.example.android.hm012_mvp.util.ActivityUtils;

public class RepositoriesActivity extends AppCompatActivity {

    private RepositoriesPresenter repositoriesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories);

        RepositoriesFragment repositoriesFragment = (RepositoriesFragment) getSupportFragmentManager().findFragmentById(R.id.a_repos_contentFrame);
        if(repositoriesFragment == null){
            repositoriesFragment = RepositoriesFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), repositoriesFragment, R.id.a_repos_contentFrame);
        }

        repositoriesPresenter = new RepositoriesPresenter(repositoriesFragment, new ApiRepository());

    }
}
