package com.example.android.et031_robolectric;

/**
 * Created by Aptivist-U001 on 11/2/2017.
 */

public interface MainContract {

    interface View{
        void showError(String error);
        void incrementCounter(int counter);
        void showProgress();
        void hideProgress();
    }

    interface Presenter {
        void doCalculation();
        void init(View view);
        void destroy();
    }
}
