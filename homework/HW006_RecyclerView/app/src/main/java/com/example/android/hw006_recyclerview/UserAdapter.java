package com.example.android.hw006_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/**
 * Created by Aptivist-U001 on 10/20/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> dataset;

    private OnItemClickListener onItemClickListener;

    public static final int USER_TYPE = 1;
    public static final int IMAGE_TYPE = 2;

    public UserAdapter(List<Object> dataset, OnItemClickListener onItemClickListener){
        this.dataset = dataset;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;


        switch(viewType){
            case USER_TYPE:
                view = inflater.inflate(R.layout.user_list_row, parent, false);
                viewHolder = new UserViewHolder(view);
                break;
            case IMAGE_TYPE:
                view = inflater.inflate(R.layout.image_list_row, parent, false);
                viewHolder = new ImageViewHolder(view);
                break;
            default:
                view = inflater.inflate(android.R.layout.simple_list_item_activated_1, parent,false);
                viewHolder = new SimpleTextViewHolder(view);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case USER_TYPE:
                ((UserViewHolder) holder).bind((User)dataset.get(position), onItemClickListener);
                break;
            case IMAGE_TYPE:
                ((ImageViewHolder) holder).bind(dataset.get(position).toString(), onItemClickListener);
                break;
            default:
                ((SimpleTextViewHolder) holder).bind(dataset.get(position));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(dataset.get(position) instanceof User){
            return USER_TYPE;
        }else if (dataset.get(position) instanceof String) {
            return IMAGE_TYPE;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvEmail;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.ly_user_row_name);
            tvEmail = itemView.findViewById(R.id.ly_user_row_email);
        }

        public void bind(final User user, final OnItemClickListener onItemClickListener){
            tvName.setText(user.getFirstName() + " " + user.getLastName());
            tvEmail.setText(user.getEmail());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(user, getItemViewType());
                }
            });
        }
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ly_image_row_image);
        }

        public void bind(final String url, final OnItemClickListener onItemClickListener){
            RequestOptions options = new RequestOptions();
            Glide.with(itemView.getContext()).load(url).apply(options.centerCrop()).into(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(url, getItemViewType());
                }
            });
        }

    }

    public class SimpleTextViewHolder extends RecyclerView.ViewHolder{

        TextView tvText;


        public SimpleTextViewHolder(View itemView) {
            super(itemView);
            tvText = itemView.findViewById(android.R.id.text1);
        }

        public void bind(Object ob){
            tvText.setText(ob.toString());
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Object object, int type);
    }

}
