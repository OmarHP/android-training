package com.example.android.et015_httprequest;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Aptivist-U001 on 10/23/2017.
 */

public class MyTask extends AsyncTask<String, Void, String> {

    private static final String TAG = MyTask.class.getSimpleName() + "_TAG_";

    @Override
    protected String doInBackground(String... strings) {
        String api_url = strings[0];
        StringBuilder body = new StringBuilder();
        try {
            URL url = new URL(api_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                String nextLine = scanner.nextLine();
                Log.d(TAG, "httpMagic: " + nextLine);
                body.append(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body.toString();
    }
}
