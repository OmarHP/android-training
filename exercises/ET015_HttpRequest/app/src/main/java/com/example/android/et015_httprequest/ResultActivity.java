package com.example.android.et015_httprequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.et015_httprequest.entities.Result;
import com.example.android.et015_httprequest.entities.ResultAdapater;
import com.example.android.et015_httprequest.entities.ResultApi;
import com.example.android.et015_httprequest.managers.RetrofitManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class ResultActivity extends AppCompatActivity {

    private List<Result> results;
    RecyclerView recyclerView;
    ResultAdapater resultAdapater;
    RetrofitManager retrofitManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        results = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.a_result_rv_result);
        resultAdapater = new ResultAdapater(results);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));
        recyclerView.setAdapter(resultAdapater);
        loadData();

    }

    private void loadData() {

        retrofitManager = new RetrofitManager();
        retrofitManager.initDownload(25, new Callback<ResultApi>(){
            @Override
            public void onResponse(Call<ResultApi> call, Response<ResultApi> response) {
                if (response.isSuccessful()) {
                    results.clear();
                    ResultApi body = response.body();
                    for (Result result : body.getResults()) {
                        results.add(result);
                    }
                    resultAdapater.setData(results);
                    resultAdapater.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ResultApi> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
