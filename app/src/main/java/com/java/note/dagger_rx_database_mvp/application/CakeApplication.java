package com.java.note.dagger_rx_database_mvp.application;

import android.app.Application;

import com.java.note.dagger_rx_database_mvp.di.module.ApplicationModule;
import com.java.note.dagger_rx_database_mvp.di.component.ApplicationComponent;
import com.java.note.dagger_rx_database_mvp.di.component.DaggerApplicationComponent;

public class CakeApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this, "https://gist.githubusercontent.com"))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
