package com.example.android.et015_httprequest.managers;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Aptivist-U001 on 10/23/2017.
 */

public class VolleyManager {

    private RequestQueue requestQueue;

    public VolleyManager(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public void initDownload(String url){
        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        };

        StringRequest stringRequest = new StringRequest(url, listener, errorListener);
        requestQueue.add(stringRequest);
    }





}
