package com.example.android.et003_listeners;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG_" ;

    private Button button2;
    private Button button3;
    private Button button4;

    private EditText editText1;

    private CheckBox  cbName;
    private CheckBox  cbBackground;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button2 = (Button) findViewById(R.id.a_main_btn2);
        button3 = (Button) findViewById(R.id.a_main_btn3);
        button4 = (Button) findViewById(R.id.a_main_btn4);
        editText1 = (EditText) findViewById(R.id.a_main_et1);
        tvName = (TextView) findViewById(R.id.a_main_tv_name);

        cbName = (CheckBox)findViewById(R.id.a_main_cb_name);
        cbBackground = (CheckBox)findViewById(R.id.a_main_cb_background);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomething(2);
            }
        });
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged: " + s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: " + s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged: " + s);
            }
        });

        cbName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tvName.setText("Omar Ham Pantoja");
                }else{
                    tvName.setText("");
                }
            }
        });

        cbBackground.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ((View) findViewById(R.id.a_main_layout)).setBackgroundColor(Color.BLUE);
                }else{
                    ((View) findViewById(R.id.a_main_layout)).setBackgroundColor(Color.WHITE);;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.a_main_btn3:
                doSomething(3);
                break;
            case R.id.a_main_btn4:
                doSomething(4);
                break;
        }

    }

    public void doMagic(View view) {
        doSomething(1);
    }

    private void doSomething(int i) {
        Toast.makeText(this, i + "", Toast.LENGTH_SHORT).show();
    }


}
