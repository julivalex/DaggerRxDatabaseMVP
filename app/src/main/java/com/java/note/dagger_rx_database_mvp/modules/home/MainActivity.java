package com.java.note.dagger_rx_database_mvp.modules.home;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.java.note.dagger_rx_database_mvp.R;
import com.java.note.dagger_rx_database_mvp.base.BaseActivity;
import com.java.note.dagger_rx_database_mvp.di.component.DaggerCakeComponent;
import com.java.note.dagger_rx_database_mvp.di.module.CakeModule;
import com.java.note.dagger_rx_database_mvp.modules.details.DetailActivity;
import com.java.note.dagger_rx_database_mvp.modules.home.adapter.CakeAdapter;
import com.java.note.dagger_rx_database_mvp.mvp.model.Cake;
import com.java.note.dagger_rx_database_mvp.mvp.presenter.CakePresenter;
import com.java.note.dagger_rx_database_mvp.mvp.view.MainView;
import com.java.note.dagger_rx_database_mvp.utils.NetworkUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView,
        CakeAdapter.OnCakeClickListener {

    @BindView(R.id.cake_list)
    protected RecyclerView cakeList;

    @Inject
    public CakePresenter presenter;

    private CakeAdapter cakeAdapter;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        initializeList();
        loadCakes();
    }

    private void initializeList() {
        cakeList.setHasFixedSize(true);
        cakeList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        cakeAdapter = new CakeAdapter(this, getLayoutInflater());
        cakeList.setAdapter(cakeAdapter);
    }

    private void loadCakes() {
        if (NetworkUtils.isNetAvailable(this)) {
            presenter.getCakes();
        } else {

        }
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_reload:
                loadCakes();
                return true;
            case R.id.action_about:
                showAbout();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAbout() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("Developed by Filippo Engidashet on 24/09/2016. \n\nGet the code and follow me on github!")
                .setCancelable(true)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Get Code", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Uri address = Uri.parse("https://github.com/filippella/Dagger-Rx-Database-MVP");
                        Intent intent = new Intent(Intent.ACTION_VIEW, address);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();
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
        cakeAdapter.addCakes(cakes);
    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }

    @Override
    public void onShowToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClearItems() {
        cakeAdapter.clearCakes();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dispose();
    }

    @Override
    public void onClick(View view, Cake cake, int position) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(DetailActivity.CAKE, cake);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions
                    .makeSceneTransitionAnimation(MainActivity.this, view, "cakeImageAnimation");
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }
}
