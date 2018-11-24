package com.java.note.dagger_rx_database_mvp.modules.home;

import android.content.Intent;
import android.os.Bundle;

import com.java.note.dagger_rx_database_mvp.R;
import com.java.note.dagger_rx_database_mvp.base.BaseActivity;
import com.java.note.dagger_rx_database_mvp.di.component.DaggerCakeComponent;
import com.java.note.dagger_rx_database_mvp.di.module.CakeModule;
import com.java.note.dagger_rx_database_mvp.mvp.model.Cake;
import com.java.note.dagger_rx_database_mvp.mvp.presenter.CakePresenter;
import com.java.note.dagger_rx_database_mvp.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;


public class MainActivity extends BaseActivity implements MainView {

    @Inject protected CakePresenter presenter;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        presenter.getCakes();
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerCakeComponent
                .builder()
                .applicationComponent(getApplicationComponent())
                .cakeModule(new CakeModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onCakeLoaded(List<Cake> cakes) {

    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onHideDialog() {

    }

    @Override
    public void onShowToast(String message) {

    }

    @Override
    public void onClearItems() {

    }
}
