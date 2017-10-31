package com.example.android.et012_asynctaskprogress;

import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * Created by Aptivist-U001 on 10/19/2017.
 */

public class MyTask extends AsyncTask<Void, Integer, Void> {

    private static final String TAG = MyTask.class.getSimpleName() + "_TAG_";

    private WeakReference<OnPogressUpdate> onPogressUpdateWeakReference;

    public MyTask(OnPogressUpdate onPogressUpdate) {
        this.onPogressUpdateWeakReference = new WeakReference<OnPogressUpdate>(onPogressUpdate);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i < 100; i++) {
            Log.d(TAG, "doInBackground: " + i);
            publishProgress(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        OnPogressUpdate onPogressUpdate = onPogressUpdateWeakReference.get();
        if(onPogressUpdate !=null) {
            onPogressUpdate.onPogressUpdateCallback(values[0]);
        }
    }

    interface OnPogressUpdate{
        void onPogressUpdateCallback(Integer value);
    }
}
