package com.example.android.et023_earthquakes.ui.main;

import com.example.android.et023_earthquakes.data.EarthquakeRepository;
import com.example.android.et023_earthquakes.data.entities.ResultApi;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Aptivist-U001 on 10/27/2017.
 */

public class MainPresenter implements MainContract.Presenter {

    private EarthquakeRepository earthquakeRepository;
    private MainContract.View view;
    private CompositeDisposable compositeDisposable;

    public MainPresenter(EarthquakeRepository earthquakeRepository) {
        this.earthquakeRepository = earthquakeRepository;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
        compositeDisposable.dispose();
    }

    @Override
    public void loadEarthquakes() {
        view.showProgress();
        earthquakeRepository.retrieveEarthquakes("2017-10-25", "2017-10-28", new Observer<ResultApi>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(ResultApi resultApi) {
                view.showResults(resultApi.getFeatures());
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                view.hideProgress();
            }
        });
    }
}
