package com.example.android.hw003_twofragments;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aptivist-U001 on 10/19/2017.
 */

public class UserListAdapter extends ArrayAdapter<User> {

    public List<User> users;
    public Context context;

    public UserListAdapter(Context context, List<User> users){
        super(context, R.layout.user_list_row, users);
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        convertView = layoutInflater.inflate(R.layout.user_list_row, parent, false);
        ((TextView) convertView.findViewById(R.id.ly_user_row_name)).setText(users.get(position).getName() + " " + users.get(position).getLastName());
        ((TextView) convertView.findViewById(R.id.ly_user_row_email)).setText(users.get(position).getEmail());
        return  convertView;
    }
}
