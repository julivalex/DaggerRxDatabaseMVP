package com.java.note.dagger_rx_database_mvp.di.component;

import android.content.Context;

import com.java.note.dagger_rx_database_mvp.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Context exposeContext();

    Retrofit exposeRetrofit();
}
