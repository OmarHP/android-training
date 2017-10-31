package com.example.android.et027_rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG_";

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.a_main_et);
        button = findViewById(R.id.a_main_btn);
        button.setOnClickListener(this);
    }

    public boolean isPrime(int num){
        if(num == 0) return true;
        if(num % 2 == 0) return false;
        for(int i = 3; i<=Math.sqrt(num); i+=2){
            if(num % i == 0) return  false;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        int num = Integer.parseInt(editText.getText().toString());
        Observable<Integer> observable = Observable.just(num);

        observable.map(this::isPrime)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((x -> {
                    Toast.makeText(MainActivity.this, "Is num prime:" + x, Toast.LENGTH_SHORT).show();
                }));
    }
}
