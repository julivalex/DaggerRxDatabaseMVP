package com.java.note.dagger_rx_database_mvp.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        onViewReady(savedInstanceState, getIntent());
    }

    protected abstract int getContentView();

    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        //To be used by child activities
    }

    protected void showDialog(String message) {
        if (dialog == null) {
            dialog = new ProgressDialog(this);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setCancelable(true);
        }
        dialog.setMessage(message);
        dialog.show();
    }

    protected void hideDialog() {
        if (dialog != null && !dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
