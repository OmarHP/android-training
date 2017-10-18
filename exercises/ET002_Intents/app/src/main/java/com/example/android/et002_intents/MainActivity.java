package com.example.android.et002_intents;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG_";

    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.a_main_et);
    }

    public void doMagic(View view) {
        String value = mEditText.getText().toString();
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("MY_KEY", value);
        startActivity(intent);
        Log.d(TAG, "doMagic: " + intent);
    }

    public void doMagicForResult(View view) {
        String value = mEditText.getText().toString();
        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
        startActivityForResult(intent, 120);
        Log.d(TAG, "doMagicForResult: " + intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 120 && resultCode == RESULT_OK) {
            int color = data.getIntExtra("COLOR_KEY", -1);
            switch (color) {
                case 1:
                    findViewById(R.id.ly_my_layout).setBackgroundColor(Color.BLUE);
                    break;
                case 2:
                    findViewById(R.id.ly_my_layout).setBackgroundColor(Color.GREEN);
                    break;
                case 3:
                    findViewById(R.id.ly_my_layout).setBackgroundColor(Color.YELLOW);
                    break;
                default:
                    findViewById(R.id.ly_my_layout).setBackgroundColor(Color.GRAY);

            }
            Log.d(TAG, "onActivityResult: " + data.getIntExtra("COLOR_KEY", -1));
        }
    }
}
