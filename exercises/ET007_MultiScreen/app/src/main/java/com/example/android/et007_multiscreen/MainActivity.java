package com.example.android.et007_multiscreen;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvText;
    private EditText etUser;
    private ListView lvList;
    private ArrayList<String> users;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users = new ArrayList<>();
        users.add("Edwin");
        users.add("Omar");
        users.add("Pepe");
        users.add("Isaias");
        users.add("Alfredo");
        lvList = (ListView) findViewById(R.id.a_main_lv_list);
        etUser = (EditText) findViewById(R.id.a_main_et_user);
        tvText = (TextView) findViewById(R.id.a_main_tv_text);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);
        lvList.setAdapter(adapter);

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String user = users.get(position);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, user);
                startActivity(intent);
            }
        });
    }

    public void addNewUser(View view) {
        String newUser = etUser.getText().toString();
        users.add(newUser);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("users", users);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<String> restoredUsers = savedInstanceState.getStringArrayList("users");
        if(restoredUsers!=null && !restoredUsers.isEmpty()){
            users.clear();
            users.addAll(restoredUsers);
            adapter.notifyDataSetChanged();
        }
    }

    public void doMagic(View view) {
        tvText.setText(etUser.getText().toString());
    }
}
