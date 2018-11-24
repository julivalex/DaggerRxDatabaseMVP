package com.java.note.dagger_rx_database_mvp.mvp.presenter;

import com.java.note.dagger_rx_database_mvp.api.CakeApiService;
import com.java.note.dagger_rx_database_mvp.base.BasePresenter;
import com.java.note.dagger_rx_database_mvp.mapper.CakeMapper;
import com.java.note.dagger_rx_database_mvp.mvp.model.Cake;
import com.java.note.dagger_rx_database_mvp.mvp.model.CakesResponse;
import com.java.note.dagger_rx_database_mvp.mvp.model.Storage;
import com.java.note.dagger_rx_database_mvp.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CakePresenter extends BasePresenter<MainView>  {

    @Inject protected CakeApiService apiService;
    @Inject protected CakeMapper cakeMapper;
    @Inject protected Storage storage;

    @Inject
    public CakePresenter() {

    }

    public void getCakes() {
        getView().onShowDialog("Loading cakes...");
        Observable<CakesResponse> cakesResponseObservable = apiService.getCakes();
        subscribe(cakesResponseObservable, this);
    }

    @Override
    public void onNext(CakesResponse cakesResponse) {
        List<Cake> cakes = cakeMapper.mapCakes(storage, cakesResponse);
        getView().onClearItems();
        getView().onCakeLoaded(cakes);
    }

    @Override
    public void onError(Throwable e) {
        getView().onHideDialog();
        getView().onShowToast("Error loading cakes " + e.getMessage());
    }

    @Override
    public void onComplete() {
        getView().onHideDialog();
        getView().onShowToast("Cakes loading complete!");
    }
}
