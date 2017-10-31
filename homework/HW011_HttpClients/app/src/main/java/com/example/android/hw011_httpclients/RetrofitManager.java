package com.example.android.hw011_httpclients;

import com.example.android.hw011_httpclients.entities.Result;
import com.example.android.hw011_httpclients.entities.ResultApi;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Aptivist-U001 on 10/24/2017.
 */

public class RetrofitManager {

    public Retrofit retrofit;
    private RandomUserService randomUserService;

    public interface RandomUserService{
        @GET("/api")
        Call<ResultApi> getRandomUserListCallable(@Query("results") int n);
    }

    public RetrofitManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        randomUserService = retrofit.create(RandomUserService.class);
    }

    public void requestRandomUserList(int n){
        randomUserService.getRandomUserListCallable(n).enqueue(new Callback<ResultApi>() {
            @Override
            public void onResponse(Call<ResultApi> call, Response<ResultApi> response) {
                ResultApi resultApi = response.body();
                if (resultApi!=null) {
                    for(Result result: resultApi.getResults()){
                        System.out.println(result);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResultApi> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
