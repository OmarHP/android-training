package com.example.android.et011_recyclerviews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Aptivist-U001 on 10/19/2017.
 */

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<User> users;

    public CustomAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view  = layoutInflater.inflate(R.layout.list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {
        User user = users.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        Button button;
        private String lastName;

        public ViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.l_row_btn);
            textView = itemView.findViewById(R.id.l_row_txt);
            imageView = itemView.findViewById(R.id.l_row_image);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), getItemId() +" " + lastName, Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void bind(User user) {
            textView.setText(user.getFirstName());
            lastName = user.getLatName();
            Glide.with(itemView.getContext())
                    .load(user.getImage())
                    .into(imageView);

        }
    }
}
