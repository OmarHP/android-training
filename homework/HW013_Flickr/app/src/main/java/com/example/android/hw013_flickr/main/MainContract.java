package com.example.android.hw013_flickr.main;

import com.example.android.hw013_flickr.base.BasePresenter;
import com.example.android.hw013_flickr.base.BaseView;
import com.example.android.hw013_flickr.data.entities.Item;

import java.util.List;

/**
 * Created by Aptivist-U001 on 10/28/2017.
 */

public interface MainContract {

    interface View extends BaseView{
        void showResults(List<Item> results);
        void showProgress();
        void hideProgress();
        void showError(String message);
    }

    interface Presenter extends BasePresenter<View> {
        void loadPhotos();
    }
}
