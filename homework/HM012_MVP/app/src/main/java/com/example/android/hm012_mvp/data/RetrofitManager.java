package com.example.android.hm012_mvp.data;

import com.example.android.hm012_mvp.data.entities.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Aptivist-U001 on 10/26/2017.
 */

public class RetrofitManager {

    private static RetrofitManager retrofitManager;
    private Retrofit retrofitClient;
    private GitHubService gitHubService;

    private RetrofitManager() {
        retrofitClient = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static RetrofitManager getRetrofitManagerInstance() {
        if (retrofitManager == null) {
            retrofitManager = new RetrofitManager();
        }
        return retrofitManager;
    }


    public GitHubService getGitHubService() {
        if (gitHubService == null) {
            gitHubService = retrofitClient.create(GitHubService.class);
        }
        return gitHubService;
    }

    public interface GitHubService {
        @GET("users/{user}/repos")
        Call<List<GitHubRepo>> listReposFromUser(@Path("user") String user);
    }


}



