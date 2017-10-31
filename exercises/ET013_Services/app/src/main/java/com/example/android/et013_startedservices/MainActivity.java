package com.example.android.et013_startedservices;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG_";
    private EditText etText;
    private boolean isBound;
    private  MyBoundService myBoundService;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(TAG, "onServiceConnected: ");
            myBoundService =(MyBoundService)((MyBoundService.MyBinder) iBinder).getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(TAG, "onServiceDisconnected: ");
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etText = (EditText) findViewById(R.id.a_main_et_text);
    }

    public void startService(View view) {
        Intent intent = new Intent(this, MyStartedService.class);
        intent.putExtra(Intent.EXTRA_TEXT, etText.getText().toString());
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this, MyStartedService.class);
        stopService(intent);
    }

    public void callIntentService(View view) {
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }

    public void bindService(View view) {
        Intent intent = new Intent(this, MyBoundService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    public void unbindService(View view) {
        if(isBound) {
            unbindService(serviceConnection);
            isBound = false;
        }
    }

    public void doBoundMagic(View view) {
        if(isBound){
            myBoundService.doMagic();
        }
    }
}
