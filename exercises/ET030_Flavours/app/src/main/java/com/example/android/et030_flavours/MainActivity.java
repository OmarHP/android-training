package com.example.android.et030_flavours;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.example.et030_flavours.User;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG_";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.a_main_txt);
        String flavor = BuildConfig.FLAVOR;
        textView.setText(flavor);


        User.sayHello();

        String apiUrl = BuildConfig.BASE_URL;
        String apiKey = getString(R.string.API_KEY);
        String packageName = getPackageName();


        Log.d(TAG, "onCreate: " + apiUrl +" "+ apiKey + " " +packageName);
    }
}
