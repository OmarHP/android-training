package com.example.android.hw003_twofragments;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements UserListFragment.OnUserListFragmentActions {

    private UserListFragment userListFragment;
    private DetailFragment detailFragment;
    private FrameLayout flListFragment;
    private FrameLayout flDetailFragment;
    private ActionBar actionBar;
    private boolean isDetailVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userListFragment = (UserListFragment) getSupportFragmentManager().findFragmentById(R.id.a_main_fg_list);
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.a_main_fg_detail);
        flListFragment = (FrameLayout) findViewById(R.id.a_main_fl_list_fragment);
        flDetailFragment = (FrameLayout) findViewById(R.id.a_main_fl_detail_fragment);
        actionBar = getSupportActionBar();
    }

    @Override
    public void onItemSelected(User user) {
        detailFragment.setUserData(user);

        if(getOrientation() == Configuration.ORIENTATION_PORTRAIT){
            flListFragment.setVisibility(View.GONE);
        }

        flDetailFragment.setVisibility(View.VISIBLE);
        isDetailVisible = true;

    }


    @Override
    public void onBackPressed() {

        if(isDetailVisible){
            if(getOrientation() == Configuration.ORIENTATION_PORTRAIT){
                flListFragment.setVisibility(View.VISIBLE);
            }
            flDetailFragment.setVisibility(View.GONE);
            isDetailVisible = false;
        }else{
            super.onBackPressed();
        }
    }

    private int getOrientation(){
        return getResources().getConfiguration().orientation;
    }
}