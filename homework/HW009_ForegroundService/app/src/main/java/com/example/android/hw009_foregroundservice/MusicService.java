package com.example.android.hw009_foregroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MusicService extends Service {


    private static final String TAG = MusicService.class.getSimpleName() + "_TAG_";
    public static final String START_FOREGROUND_ACTION = "com.example.android.hw009.action.start_foreground";
    public static final String STOP_FOREGROUND_ACTION = "com.example.android.hw009.action.stop_foreground";
    public static final String MAIN_ACTION = "com.example.android.hw009.action.main";
    private static final int NOTIFICACTION_ID = 124;

    private MediaPlayer mediaPlayer;

    public MusicService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(START_FOREGROUND_ACTION.equals(intent.getAction())){
            Toast.makeText(this, "Starting service", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onStartCommand: Received Start Foreground Intent");

            Intent notificationIntent = new Intent(this, MainActivity.class);
            intent.setAction(MAIN_ACTION);
            //notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            RemoteViews notificationView = new RemoteViews(this.getPackageName(), R.layout.notification);

            //Building and attaching the play button
            Intent buttonPlayIntent = new Intent(this, NotificationPlayButtonHandler.class);
            buttonPlayIntent.putExtra("action", "togglePause");

            PendingIntent buttonPlayPendingIntent = pendingIntent.getBroadcast(this, 0, buttonPlayIntent, 0);
            notificationView.setOnClickPendingIntent(R.id.notification_button_play, buttonPlayPendingIntent);

            Bitmap icon = BitmapFactory.decodeResource(getResources(),
                    R.mipmap.ic_launcher);

            Notification notification = new NotificationCompat.Builder(this)
                    .setContentTitle("Music Player Example")
                    .setTicker("Music Player")
                    .setContentText("nkDroid Music")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(
                            Bitmap.createScaledBitmap(icon, 128, 128, false))
                    .setContent(notificationView)
                    .setContentIntent(pendingIntent)
                    .setOngoing(true).build();



            startForeground(NOTIFICACTION_ID,
                    notification);

            if( mediaPlayer== null )
                mediaPlayer = MediaPlayer.create(this, R.raw.song1);
            if(!mediaPlayer.isPlaying())
                mediaPlayer.start(); // no need to call prepare(); create() does that for you

        }else if (STOP_FOREGROUND_ACTION.equals(intent.getAction())) {
            Toast.makeText(this, "Stopping service", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onStartCommand: Received Stop Foreground Intent");
            Toast.makeText(this,"Stop Service",Toast.LENGTH_SHORT).show();
            stopForeground(true);
            if(mediaPlayer!= null && mediaPlayer.isPlaying()){
                mediaPlayer.stop();
            }
            stopSelf();
        }
        return START_STICKY;
        //return super.onStartCommand(intent, flags, startId);
    }

    /**
     * Called when user clicks the "play/pause" button on the on-going system Notification.
     */
    public static class NotificationPlayButtonHandler extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"Play Clicked",Toast.LENGTH_SHORT).show();

        }
    }
}
