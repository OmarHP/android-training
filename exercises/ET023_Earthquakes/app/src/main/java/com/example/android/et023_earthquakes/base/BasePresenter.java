package com.example.android.et023_earthquakes.base;

/**
 * Created by Aptivist-U001 on 10/27/2017.
 */

public interface BasePresenter<V extends  BaseView> {

    void attachView(V view);

    void detachView();
}
