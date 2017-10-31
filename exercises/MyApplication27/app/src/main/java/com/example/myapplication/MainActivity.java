package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<User> users;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.a_main_list);
        users = createUsers();

        customAdapter = new CustomAdapter(this, users);

        listView.setAdapter(customAdapter);
    }

    private List<User> createUsers() {
        return Arrays.asList(
                new User("Edwin", "Hernandez", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Isaias", "Lagunes", "http://nulm.gov.in/images/user.png"),
                new User("Omar", "Ham", "https://cdn1.iconfinder.com/data/icons/unique-round-blue/93/user-512.png")
        );
    }
}
