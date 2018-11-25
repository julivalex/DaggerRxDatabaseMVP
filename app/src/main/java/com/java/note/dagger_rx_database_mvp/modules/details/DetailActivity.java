package com.java.note.dagger_rx_database_mvp.modules.details;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.java.note.dagger_rx_database_mvp.R;
import com.java.note.dagger_rx_database_mvp.base.BaseActivity;
import com.java.note.dagger_rx_database_mvp.mvp.model.Cake;

import butterknife.BindView;

public class DetailActivity extends BaseActivity {

    public static final String CAKE = "cake";

    @BindView(R.id.cakeImage) protected ImageView cakeImage;
    @BindView(R.id.cakeTitle) protected TextView cakeTitle;
    @BindView(R.id.cakeDescription) protected TextView cakeDescription;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cakeImage.setTransitionName("cakeImageAnimation");
        }

        showBackArrow();

        Cake cake = (Cake) intent.getSerializableExtra(CAKE);
        setTitle("Cake Detail");

        cakeTitle.setText(cake.getTitle());
        cakeDescription.setText(cake.getDetailDescription());

        Glide.with(this).load(cake.getImageUrl())
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA))
                .into(cakeImage);

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_detail;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
