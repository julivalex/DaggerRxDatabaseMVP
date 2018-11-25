package com.java.note.dagger_rx_database_mvp.modules.details;

import android.widget.ImageView;
import android.widget.TextView;

import com.java.note.dagger_rx_database_mvp.R;
import com.java.note.dagger_rx_database_mvp.base.BaseActivity;

import butterknife.BindView;

public class DetailActivity extends BaseActivity {

    public static final String CAKE = "cake";

    @BindView(R.id.cakeImage) protected ImageView mCakeImage;
    @BindView(R.id.cakeTitle) protected TextView mCakeTitle;
    @BindView(R.id.cakeDescription) protected TextView mCakeDescription;

    @Override
    protected int getContentView() {
        return R.layout.activity_detail;
    }
}
