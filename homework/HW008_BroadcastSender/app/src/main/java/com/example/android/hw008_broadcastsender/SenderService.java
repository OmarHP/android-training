package com.example.android.hw008_broadcastsender;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class SenderService extends Service {

    private static final String TAG = SenderService.class.getSimpleName() + "_TAG_";
    private boolean running;
    public SenderService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        running = true;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i=1;
                while(running){
                    Intent intent1 = new Intent("com.example.android.hw008.message");
                    Log.d(TAG, "run: message " + i +" sent");
                    intent1.putExtra(Intent.EXTRA_TEXT, "Message " + (i++));
                    sendBroadcast(intent1, "com.example.android.hw008.permission");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        running = false;
    }
}
