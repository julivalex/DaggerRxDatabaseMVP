package com.java.note.dagger_rx_database_mvp.mvp.view;

import com.java.note.dagger_rx_database_mvp.mvp.model.Cake;

import java.util.List;

public interface MainView extends BaseView {

    void onCakeLoaded(List<Cake> cakes);

    void onShowDialog(String message);

    void onHideDialog();

    void onShowToast(String message);

    void onClearItems();
}
