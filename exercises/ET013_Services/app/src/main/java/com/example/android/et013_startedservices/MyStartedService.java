package com.example.android.et013_startedservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MyStartedService extends Service {
    private static final String TAG = MyStartedService.class.getSimpleName() + "_TAG_";

    public MyStartedService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        String name = intent.getStringExtra(Intent.EXTRA_TEXT);
        if(name.toLowerCase().equals("Edwin".toLowerCase())){
            stopSelf();
        }else {
            Log.d(TAG, "onStartCommand: " + name + " " + Thread.currentThread());
        }
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d(TAG, "onBind: ");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
