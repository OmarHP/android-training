package com.example.android.et015_httprequest.entities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aptivist-U001 on 10/23/2017.
 */

public class ResultAdapater extends RecyclerView.Adapter<ResultAdapater.ViewHolder> {

    List<Result> results;

    public ResultAdapater(List<Result> results) {
        this.results = results;
    }

    @Override
    public ResultAdapater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view  = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ResultAdapater.ViewHolder holder, int position) {
        holder.bind(results.get(position));

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setData(List<Result> data) {
        this.results = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView text;
        public ViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(android.R.id.text1);
        }

        public void bind(Result result){
            text.setText(result.getName().getFirst());
        }
    }
}
