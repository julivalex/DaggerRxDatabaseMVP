package com.java.note.dagger_rx_database_mvp.di.module;

import com.java.note.dagger_rx_database_mvp.api.CakeApiService;
import com.java.note.dagger_rx_database_mvp.di.scope.PerActivity;
import com.java.note.dagger_rx_database_mvp.mvp.presenter.CakePresenter;
import com.java.note.dagger_rx_database_mvp.mvp.view.MainView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class CakeModule {

    private MainView mainView;

    public CakeModule(MainView mainView) {
        this.mainView = mainView;
    }

    @PerActivity
    @Provides
    CakeApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(CakeApiService.class);
    }

    @PerActivity
    @Provides
    MainView provideView() {
        return mainView;
    }

    @PerActivity
    @Provides
    CakePresenter provideCakePresenter() {
        return new CakePresenter();
    }
}
