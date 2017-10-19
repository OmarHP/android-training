package com.example.android.et010_asynctask;


import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Aptivist-U001 on 10/18/2017.
 */

public class MyAsyncTask extends AsyncTask<Void, Void, Void> {

    private static final String TAG = MyAsyncTask.class.getSimpleName()+"_TAG_";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: " + Thread.currentThread());
    }

    @Override
    protected Void doInBackground(Void... params) {
        Log.d(TAG, "doInBackground: " + Thread.currentThread());
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: " + Thread.currentThread());
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d(TAG, "onPostExecute: " + Thread.currentThread());
    }
}
