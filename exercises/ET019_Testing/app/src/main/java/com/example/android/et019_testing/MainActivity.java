package com.example.android.et019_testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName() + "_TAG_";
    @BindView(R.id.a_main_et)
    EditText editText;

    @BindView(R.id.a_main_tv)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.a_main_btn)
    public void doMagic(View view){
        int sum = CalculatorHelper.generateSum(editText.getText().toString());
        textView.setText(""+sum);
    }


}
