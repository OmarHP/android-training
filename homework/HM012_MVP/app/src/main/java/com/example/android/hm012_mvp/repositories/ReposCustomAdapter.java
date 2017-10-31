package com.example.android.hm012_mvp.repositories;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.hm012_mvp.R;
import com.example.android.hm012_mvp.data.entities.GitHubRepo;

import java.util.List;

/**
 * Created by Aptivist-U001 on 10/26/2017.
 */

class ReposCustomAdapter extends RecyclerView.Adapter<ReposCustomAdapter.ViewHolder> {

    private List<GitHubRepo> repos;
    private Integer selected;

    public ReposCustomAdapter(List<GitHubRepo> repos){
        this.repos = repos;
    }

    @Override
    public ReposCustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repository_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ReposCustomAdapter.ViewHolder holder, final int position) {
        holder.bind(repos.get(position));
        final GitHubRepo repo = repos.get(position);
        View view = holder.itemView;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repos.get(position).selected = !repo.selected ;
                holder.updateState(repos.get(position));
                if(selected != null){
                    repos.get(selected).selected = false;
                    notifyDataSetChanged();
                }
                selected = position;
            }
        });
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public void replaceData(List<GitHubRepo> repos) {
        this.repos = repos;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName;
        private TextView tvDescr;
        private TextView tvStars;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.ly_repo_name);
            tvDescr = itemView.findViewById(R.id.ly_repo_descr);
            tvStars = itemView.findViewById(R.id.ly_repo_likes);
        }

        public void bind(GitHubRepo repo){
            String descr = "";
            if(repo.getDescription() != null){
                descr = repo.getDescription().toString();
                if(descr.length() > 100){
                    descr.substring(0,100);
                }
            }
            tvName.setText(repo.getName());
            tvDescr.setText(descr);
            tvStars.setText(repo.getStargazersCount()+ "");
            updateState(repo);
        }

        public void updateState(GitHubRepo gitHubRepo) {
            this.itemView.setSelected(gitHubRepo.selected);
        }
    }
}
