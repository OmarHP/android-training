package com.example.android.hw005_listviewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aptivist-U001 on 10/20/2017.
 */

class UserArrayAdapter extends ArrayAdapter<User> {

    List<User> users;

    public UserArrayAdapter(Context context, List<User> users) {
        super(context, R.layout.user_list_row, users);
        this.users = users;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.user_list_row, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.bind(users.get(position));

        return convertView;
    }


    private class ViewHolder{
        TextView tvName;
        TextView tvEmail;

        public ViewHolder(View view){
            tvName = view.findViewById(R.id.ly_user_row_name);
            tvEmail = view.findViewById(R.id.ly_user_row_email);
        }

        public void bind(User user){
            tvName.setText(user.getFirstName() + " " + user.getLastName());
            tvEmail.setText(user.getEmail());
        }
    }
}
