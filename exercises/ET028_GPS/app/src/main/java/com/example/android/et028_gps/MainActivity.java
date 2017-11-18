package com.example.android.et028_gps;

import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.Task;

import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG_";
    private Button btnGet;
    private Button btnStop;
    private Button btnStart;
    private Button btnFused;

    private LocationHelper locationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.a_main_btn_start);
        btnStop = findViewById(R.id.a_main_btn_stop);
        btnGet = findViewById(R.id.a_main_btn_get);
        btnFused = findViewById(R.id.a_main_btn_fuse);
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationHelper = new LocationHelper(locationManager);

        btnStart.setOnClickListener(v -> locationHelper.startUpdates());
        btnStop.setOnClickListener(v -> locationHelper.stopUpdates());
        btnGet.setOnClickListener(v -> locationHelper.getCurrentLocation());
        btnFused.setOnClickListener(v -> {
            FusedLocationProviderClient fusedLocationProviderClient = getFusedLocationProviderClient(MainActivity.this);
            Task<Location> lastLocation = fusedLocationProviderClient.getLastLocation();
            lastLocation.addOnSuccessListener(loc -> Log.d(TAG, "onCreate: " + loc));
        });
    }
}
