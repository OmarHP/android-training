package com.example.android.hw002_fragments;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnLoginActions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(R.id.a_mian_fl_fragment, new LoginFragment(), "LOGIN_FRAGMENT_TAG", false);
    }

    private void addFragment(int container, Fragment fragment, String tag, boolean toBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(container, fragment, tag);
        if (toBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onLoginClick(String user) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("username", user);
        detailFragment.setArguments(bundle);
        addFragment(R.id.a_mian_fl_fragment, detailFragment, "DETAIL_FRAGMENT_TAG", true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
