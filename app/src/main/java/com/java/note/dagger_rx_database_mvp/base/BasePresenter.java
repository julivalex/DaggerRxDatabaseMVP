package com.java.note.dagger_rx_database_mvp.base;

import com.java.note.dagger_rx_database_mvp.mvp.model.CakesResponse;
import com.java.note.dagger_rx_database_mvp.mvp.view.BaseView;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class BasePresenter<V extends BaseView> extends DisposableObserver<CakesResponse>  {

    @Inject
    protected V baseView;

    public V getView() {
        return baseView;
    }

    protected <T> void subscribe(Observable<T> observable, DisposableObserver<T> observer) {
        Disposable disposable = observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer);
    }
}
