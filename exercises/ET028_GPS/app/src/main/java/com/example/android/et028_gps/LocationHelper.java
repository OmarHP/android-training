package com.example.android.et028_gps;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Aptivist-U001 on 10/31/2017.
 */

public class LocationHelper implements LocationListener {

    private static final String TAG = LocationHelper.class.getSimpleName() + "_TAG_";

    private LocationManager locationManager;

    public LocationHelper(LocationManager locationManager) {
        this.locationManager = locationManager;
    }

    public void startUpdates(){
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
    }

    public void stopUpdates(){
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "onLocationChanged: " + location);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        Log.d(TAG, "onStatusChanged: " +s + " " + i + " " + bundle);
    }

    @Override
    public void onProviderEnabled(String s) {
        Log.d(TAG, "onProviderEnabled: " + s);
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.d(TAG, "onProviderDisabled: " + s);
    }

    public void getCurrentLocation() {
        Criteria criteria = new Criteria();
        //criteria.setAccuracy(Criteria.ACCURACY_HIGH);
        //criteria.setPowerRequirement(Criteria.POWER_LOW);
        String bestProvider = locationManager.getBestProvider(criteria, false);
        Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
        double latitude = lastKnownLocation.getLatitude();
        double longitude = lastKnownLocation.getLongitude();
        String provider = lastKnownLocation.getProvider();

        Log.d(TAG, "getCurrentLocation: " + provider + " " + latitude + " " + longitude);

    }
}
