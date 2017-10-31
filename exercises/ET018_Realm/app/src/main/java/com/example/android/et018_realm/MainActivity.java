package com.example.android.et018_realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Date;
import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG_";
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();

    }

    public void saveMagic(View view) {
        realm.beginTransaction();
        realm.copyToRealm(new User(1, new Date().toString(), 25));
        realm.commitTransaction();
    }

    public void loadMagic(View view) {
        List<User> userList = realm.where(User.class).findAll();
        for (User user : userList) {
            Log.d(TAG, "loadMagic: " + user.toString());
        }
    }
}
