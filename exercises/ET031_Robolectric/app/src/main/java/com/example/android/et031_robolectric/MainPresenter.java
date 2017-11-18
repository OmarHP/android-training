package com.example.android.et031_robolectric;

import android.support.annotation.VisibleForTesting;

import com.example.android.et031_robolectric.data.MathModel;

/**
 * Created by Aptivist-U001 on 11/2/2017.
 */

public class MainPresenter implements MainContract.Presenter {

    @VisibleForTesting
    public MainContract.View view;
    @VisibleForTesting
    public MathModel mathModel;

    public MainPresenter(MathModel mathModel) {
        this.mathModel = mathModel;
    }

    @Override
    public void doCalculation() {
        int result = mathModel.calculate();
        view.incrementCounter(result);
    }

    @Override
    public void init(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        this.view = null;
    }
}
