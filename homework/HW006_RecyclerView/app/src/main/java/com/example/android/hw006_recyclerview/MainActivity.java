package com.example.android.hw006_recyclerview;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements UserAdapter.OnItemClickListener{

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG_" ;
    private List<Object> dataset;
    private RecyclerView rvUsers;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvUsers = (RecyclerView) findViewById(R.id.a_main_rv_users);
        dataset = new ArrayList<>();
        dataset.addAll(UserUtils.getUsersFakeData(50));
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            dataset.add(random.nextInt(dataset.size()), "http://www.mindinventory.com/blog/wp-content/uploads/2017/06/android-studio-3.0.jpg");
        }
        userAdapter = new UserAdapter(dataset, this);

        rvUsers.setAdapter(userAdapter);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    public void onItemClick(Object object, int type) {
        switch (type){
            case UserAdapter.USER_TYPE:
                User user = ((User) object);
                Snackbar.make(findViewById(R.id.a_main_cordinator_layout), user.getFirstName() + " " + user.getLastName(), Snackbar.LENGTH_SHORT).show();
                break;
            case UserAdapter.IMAGE_TYPE:
                Toast.makeText(this, "Image URL: " + object, Toast.LENGTH_SHORT).show();
                break;
            default:
                Log.d(TAG, "onItemClick: Unknown item type clicked");
        }
    }
}
