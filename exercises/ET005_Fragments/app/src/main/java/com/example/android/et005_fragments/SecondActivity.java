package com.example.android.et005_fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void addPink(View view) {
        addFragment(getContainer(view), new PinkFragment(), "PINK_FRAGMENT_TAG");
    }

    public void addBlue(View view) {
        addFragment(getContainer(view), new BlueFragment(), "BLUE_FRAGMENT_TAG");
    }

    public void addPurple(View view) {
        addFragment(getContainer(view), new PurpleFragment(), "PURPLE_FRAGMENT_TAG");
    }

    private int getContainer(View view){
        int container = R.id.a_second_frame_pink;
        switch(((View)view.getParent()).getId()){
            case R.id.a_second_btn_group1:
                container = R.id.a_second_frame_pink;
                break;
            case R.id.a_second_btn_group2:
                container = R.id.a_second_frame_blue;
                break;
        }
        return  container;
    }

    private void addFragment(int container, Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction()
                .add(container, fragment, tag)
                .addToBackStack(null)
                .commit();
    }
}
