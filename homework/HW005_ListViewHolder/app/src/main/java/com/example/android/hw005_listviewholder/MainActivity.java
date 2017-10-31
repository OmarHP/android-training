package com.example.android.hw005_listviewholder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvUsers;
    private List<User> users;
    private ArrayAdapter<User> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvUsers = (ListView) findViewById(R.id.a_main_lv_users);
        users = UserUtils.getUsersFakeData(100);
        adapter = new UserArrayAdapter(this, users);
        lvUsers.setAdapter(adapter);
    }
}
