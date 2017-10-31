package com.example.android.hw013_flickr.main;

import com.example.android.hw013_flickr.data.FlickrRepository;
import com.example.android.hw013_flickr.data.entities.ResultApi;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Aptivist-U001 on 10/28/2017.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private FlickrRepository repository;
    private CompositeDisposable compositeDisposable;

    public MainPresenter(FlickrRepository repository) {
        this.repository = repository;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void attachView(MainContract.View view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    @Override
    public void loadPhotos() {
        mView.showProgress();
        repository.retrievePhotos("tree", new Observer<ResultApi>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(ResultApi resultApi) {
                mView.showResults(resultApi.getItems());
            }

            @Override
            public void onError(Throwable e) {
                mView.showError(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.hideProgress();
            }
        });
    }
}
