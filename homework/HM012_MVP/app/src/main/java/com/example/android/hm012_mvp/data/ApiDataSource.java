package com.example.android.hm012_mvp.data;

import android.support.annotation.NonNull;

import java.util.List;

import retrofit2.Response;

/**
 * Created by Aptivist-U001 on 10/26/2017.
 */

public interface ApiDataSource {

    interface LoadRepositoriesCallback {
        void onResponse(Response response);
        void OnFailure(Throwable t);
    }

    void getRepositoriesFromUser(@NonNull String user, LoadRepositoriesCallback callback);
}
