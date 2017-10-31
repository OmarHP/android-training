package com.example.android.et020_mvp.ui.main;

import com.example.android.et020_mvp.BasePresenter;
import com.example.android.et020_mvp.BaseView;

import java.util.List;

/**
 * Created by Aptivist-U001 on 10/25/2017.
 */

public interface MainContract {

    interface View extends BaseView{
        void showResults(List<String> results);
    }

    interface Presenter extends BasePresenter<View>{
        void loadData();
    }

}
