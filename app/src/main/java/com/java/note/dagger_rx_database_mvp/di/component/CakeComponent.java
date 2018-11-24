package com.java.note.dagger_rx_database_mvp.di.component;

import com.java.note.dagger_rx_database_mvp.modules.home.MainActivity;
import com.java.note.dagger_rx_database_mvp.di.module.CakeModule;
import com.java.note.dagger_rx_database_mvp.di.scope.PerActivity;

import dagger.Component;

@PerActivity
@Component(modules = CakeModule.class, dependencies = ApplicationComponent.class)
public interface CakeComponent {
    void inject(MainActivity activity);
}
