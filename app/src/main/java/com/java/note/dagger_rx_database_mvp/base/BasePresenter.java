package com.java.note.dagger_rx_database_mvp.base;

import com.java.note.dagger_rx_database_mvp.mvp.view.BaseView;

import javax.inject.Inject;

public class BasePresenter<V extends BaseView> {

    @Inject
    protected V baseView;

    protected V getView() {
        return baseView;
    }
}
