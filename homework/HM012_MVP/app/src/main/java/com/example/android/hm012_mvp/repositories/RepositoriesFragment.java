package com.example.android.hm012_mvp.repositories;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.android.hm012_mvp.R;
import com.example.android.hm012_mvp.data.entities.GitHubRepo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RepositoriesFragment extends Fragment implements RepositoriesContract.View {


    private RepositoriesContract.Presenter mPresenter;

    @BindView(R.id.f_repos_rv)
    protected RecyclerView rvRepos;

    @BindView(R.id.f_repos_etUsername)
    protected EditText etUsername;

    private ReposCustomAdapter mAdapter;

    public RepositoriesFragment() {
        // Required empty public constructor
    }

    public static RepositoriesFragment newInstance(){return new RepositoriesFragment();}


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new ReposCustomAdapter(new ArrayList<GitHubRepo>(0));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repositories, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        rvRepos.setAdapter(mAdapter);
        rvRepos.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @OnClick(R.id.f_repos_btnSearch)
    public void loadRepositories(View view){
        mPresenter.loadRepositories(etUsername.getText().toString());
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showRepositories(List<GitHubRepo> repos) {
        mAdapter.replaceData(repos);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setPresenter(RepositoriesContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
