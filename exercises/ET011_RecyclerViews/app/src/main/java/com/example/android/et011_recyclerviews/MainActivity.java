package com.example.android.et011_recyclerviews;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<User> users;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.a_main_recycler);
        users = createUsers();
        CustomAdapter customAdapter = new CustomAdapter(users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(customAdapter);
        //A slide optimization
        recyclerView.setHasFixedSize(true);
    }

    private List<User> createUsers() {
        return Arrays.asList(
                new User("Edwin", "Hernandez", "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"),
                new User("Isaias", "Lagunes", "http://nulm.gov.in/images/user.png"),
                new User("Omar", "Ham", "https://cdn1.iconfinder.com/data/icons/unique-round-blue/93/user-512.png")
        );
    }
}
