package com.example.android.et009_sharedpreferences2;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String SELECTED_ITEM = "selected_item";
    private static final String TAG = MainActivity.class.getSimpleName()+"_TAG_";
    private ListView lvUsers;
    private ArrayList<String> users;
    private ArrayAdapter<String> adapter;
    private ImageView ivImage;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvUsers = (ListView) findViewById(R.id.a_main_lv_users);
        ivImage = (ImageView) findViewById(R.id.a_main_iv_image);
        users = new ArrayList<>();
        users.add("Omar");
        users.add("Pepe");
        users.add("Edwin");
        users.add("Alfredo");
        users.add("Isaias");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, users);
        lvUsers.setAdapter(adapter);

        lvUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                saveSelectedItem(position);
                selectItem(position);
                Log.d(TAG, "onItemClick: "+ position);
            }
        });

        loadSelectedItem();
    }

    private void saveSelectedItem(int selected){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SELECTED_ITEM, selected).commit();
    }

    private void loadSelectedItem(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int position =  sharedPreferences.getInt(SELECTED_ITEM, -1);
        if(position >= 0){
            selectItem(position);
        }
    }

    private void selectItem(int position){
        lvUsers.setItemChecked(position, true);
        lvUsers.setPressed(true);
    }

    public void doMagic(View view) {
        Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(ivImage);
    }
}
