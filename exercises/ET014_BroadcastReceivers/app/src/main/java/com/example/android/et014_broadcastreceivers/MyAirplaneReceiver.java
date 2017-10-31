package com.example.android.et014_broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import static android.R.attr.data;

/**
 * Created by Aptivist-U001 on 10/22/2017.
 */

public class MyAirplaneReceiver extends BroadcastReceiver {

    private static final String TAG = MyAirplaneReceiver.class.getSimpleName() + "_TAG_";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            for (String key : bundle.keySet()) {
                Object value = bundle.get(key);
                Log.d(TAG, String.format("extra %s %s (%s)", key,
                        value.toString(), value.getClass().getName()));
            }
        }
        switch (intent.getAction()){
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Log.d(TAG, "onReceive: action_airplane_mode_changed");
                boolean state;
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    state = Settings.System.getInt(context.getContentResolver(),
                            Settings.System.AIRPLANE_MODE_ON, 0) != 0;
                } else {
                    state = Settings.Global.getInt(context.getContentResolver(),
                            Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
                }
                if(state)
                    context.startActivity(new Intent(context, DetailActivity.class));
                else
                    context.startActivity(new Intent(context, MainActivity.class));
                break;
            case "android.net.conn.CONNECTIVITY_CHANGE":
                Log.d(TAG, "onReceive: conectivity_change");
        }
    }
}
