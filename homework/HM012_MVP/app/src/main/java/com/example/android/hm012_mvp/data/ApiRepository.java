package com.example.android.hm012_mvp.data;

import android.support.annotation.NonNull;

import com.example.android.hm012_mvp.data.entities.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Aptivist-U001 on 10/26/2017.
 */

public class ApiRepository implements ApiDataSource {

    @Override
    public void getRepositoriesFromUser(@NonNull String user, final LoadRepositoriesCallback callback) {
        RetrofitManager retrofitManager = RetrofitManager.getRetrofitManagerInstance();
        retrofitManager.getGitHubService()
                .listReposFromUser(user)
                .enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                callback.onResponse(response);
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                callback.OnFailure(t);
            }
        });
    }
}
