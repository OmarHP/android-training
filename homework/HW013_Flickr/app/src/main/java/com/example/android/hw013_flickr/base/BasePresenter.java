package com.example.android.hw013_flickr.base;

/**
 * Created by Aptivist-U001 on 10/28/2017.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

}
