package com.example.android.et020_mvp;

/**
 * Created by Aptivist-U001 on 10/25/2017.
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();

}
