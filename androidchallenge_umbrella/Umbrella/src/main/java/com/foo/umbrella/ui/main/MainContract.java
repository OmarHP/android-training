package com.foo.umbrella.ui.main;

import com.foo.umbrella.base.BasePresenter;
import com.foo.umbrella.base.BaseView;
import com.foo.umbrella.data.model.CurrentObservation;
import com.foo.umbrella.data.model.ForecastCondition;

import org.threeten.bp.LocalDate;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by Aptivist-U001 on 11/1/2017.
 */

public interface MainContract {

    interface View extends BaseView{
        void showProgres();

        void hideProgress();

        void showWeatherForecast(CurrentObservation currentObservation, TreeMap<LocalDate, List<ForecastCondition>> days);

        void showWarmTheme();

        void showCoolTheme();
    }

    interface Presenter extends BasePresenter<MainContract.View>{
        void loadWeatherForecast(String zip);
    }
}
