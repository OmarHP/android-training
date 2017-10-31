package com.example.android.et023_earthquakes.ui.main;

import com.example.android.et023_earthquakes.base.BasePresenter;
import com.example.android.et023_earthquakes.base.BaseView;
import com.example.android.et023_earthquakes.data.entities.Feature;

import java.util.List;

/**
 * Created by Aptivist-U001 on 10/27/2017.
 */

public interface MainContract {

    interface View extends BaseView{
        void showResults(List<Feature> results);
        void showProgress();
        void hideProgress();
    }

    interface Presenter extends BasePresenter<View>{
        void loadEarthquakes();
    }

}
