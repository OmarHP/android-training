package com.example.android.et002_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void oneMagic(View view) {
        sendResultBack(1);
    }

    public void secondMagic(View view) {
        sendResultBack(2);
    }

    public void thirdMagic(View view) {
        sendResultBack(3);
    }

    private void sendResultBack(int color){
        Intent intent = new Intent();
        intent.putExtra("COLOR_KEY", color);
        setResult(RESULT_OK, intent);
        finish();
    }
}
