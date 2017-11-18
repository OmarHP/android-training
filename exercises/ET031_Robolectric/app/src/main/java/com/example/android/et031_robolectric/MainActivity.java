package com.example.android.et031_robolectric;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.et031_robolectric.data.MathModel;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private Button btn;
    private TextView tvCounter;
    private ProgressBar progressBar;

    private MainPresenter mainPresenter;
    private MathModel mathModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.a_main_btn);
        tvCounter = findViewById(R.id.a_main_counter);
        progressBar = findViewById(R.id.a_main_progress);
        btn.setOnClickListener(v -> tvCounter.setText("123"));

        mathModel = new MathModel();
        mainPresenter = new MainPresenter(mathModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.init(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.destroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn.setOnClickListener(v -> mainPresenter.doCalculation());
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void incrementCounter(int counter) {
        tvCounter.setText(counter + "");
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
