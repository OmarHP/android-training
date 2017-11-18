package com.example.android.et035_analytics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.a_main_btn);
        button.setOnClickListener( v -> throwException());
    }

    private void throwException() {
        // TODO: Move this method and use your own event name to track your key metrics
        // TODO: Use your own string attributes to track common values over time
        // TODO: Use your own number attributes to track median value over time
        Answers.getInstance().logCustom(new CustomEvent("Exception thrown")
                .putCustomAttribute("Category", "Comedy")
                .putCustomAttribute("Length", 350));

        throw new RuntimeException("A fake exception!");


    }
}
