package com.example.android.hm012_mvp.repositories;

import android.support.annotation.NonNull;

import com.example.android.hm012_mvp.data.ApiDataSource;
import com.example.android.hm012_mvp.data.entities.GitHubRepo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

/**
 * Created by Aptivist-U001 on 10/26/2017.
 */

public class RepositoriesPresenter implements RepositoriesContract.Presenter {

    private RepositoriesContract.View mReposView;
    private ApiDataSource mApiDataSource;
    private String username;

    public RepositoriesPresenter(@NonNull RepositoriesContract.View reposView, ApiDataSource apiDataSource){
        mReposView = reposView;
        mReposView.setPresenter(this);
        mApiDataSource = apiDataSource;
    }

    @Override
    public void start() {
        if(username!=null){
            loadRepositories("");
        }
    }


    @Override
    public void loadRepositories(String username) {
        mApiDataSource.getRepositoriesFromUser(username, new ApiDataSource.LoadRepositoriesCallback() {
            @Override
            public void onResponse(Response response) {
                if(response.isSuccessful()){
                    List<GitHubRepo> repos = (List<GitHubRepo>) response.body();
                    if(repos != null){
                        mReposView.showRepositories(repos);
                    }
                }else{
                    mReposView.showRepositories(new ArrayList<GitHubRepo>(0));
                }
            }

            @Override
            public void OnFailure(Throwable t) {
                mReposView.showRepositories(new ArrayList<GitHubRepo>(0));
            }
        });
    }
}
