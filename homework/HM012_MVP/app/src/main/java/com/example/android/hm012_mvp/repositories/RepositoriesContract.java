package com.example.android.hm012_mvp.repositories;

import com.example.android.hm012_mvp.BasePresenter;
import com.example.android.hm012_mvp.BaseView;
import com.example.android.hm012_mvp.data.entities.GitHubRepo;

import java.util.List;

/**
 * Created by Aptivist-U001 on 10/26/2017.
 */

public interface RepositoriesContract {

    interface View extends BaseView<Presenter>{
        void showRepositories(List<GitHubRepo> repos );
        void showProgress();
        void hideProgress();
    }
    interface Presenter extends BasePresenter {

        void loadRepositories(String username);
    }
}

