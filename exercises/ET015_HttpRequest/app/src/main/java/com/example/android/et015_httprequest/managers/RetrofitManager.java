package com.example.android.et015_httprequest.managers;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.et015_httprequest.entities.Result;
import com.example.android.et015_httprequest.entities.ResultApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Aptivist-U001 on 10/23/2017.
 */

public class RetrofitManager {

    private Retrofit retrofit;
    private RandomUserService randomUserService;

    public interface RandomUserService{
        @GET("/api")
        Call<ResultApi> getRandomUserCallable();

        @GET("/api")
        Call<ResultApi> getRandomListCallable(@Query("results") int results);

        @GET("/{results}/api")
        Call<ResultApi> getRandomPathCallable(@Path("results") String results);

    }

    public RetrofitManager() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                        .addInterceptor(interceptor)
                        .build())
                .build();
        randomUserService = retrofit.create(RandomUserService.class);
    }

    public void initDownload(){
        randomUserService.getRandomUserCallable().enqueue(getCallback());
    }

    public void initDownload(int n){
        randomUserService.getRandomListCallable(n).enqueue(getCallback());
    }

    private void printResults(Response<ResultApi> response) {
        if (response.isSuccessful()) {
            ResultApi body = response.body();
            System.out.println(body);
            for (Result result : body.getResults()) {
                System.out.println(result);
            }
        }
    }

    @NonNull
    private Callback<ResultApi> getCallback() {
        return new Callback<ResultApi>() {
            @Override
            public void onResponse(Call<ResultApi> call, Response<ResultApi> response) {
                printResults(response);
            }
            @Override
            public void onFailure(Call<ResultApi> call, Throwable t) {
                t.printStackTrace();
            }
        };
    }


    public void initDownload(int n, Callback<ResultApi> callback){
        randomUserService.getRandomListCallable(n).enqueue(callback);
    }


}


