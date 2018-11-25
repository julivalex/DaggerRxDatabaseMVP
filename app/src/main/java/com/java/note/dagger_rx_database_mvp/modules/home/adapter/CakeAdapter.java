package com.java.note.dagger_rx_database_mvp.modules.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.java.note.dagger_rx_database_mvp.R;
import com.java.note.dagger_rx_database_mvp.mvp.model.Cake;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.Holder> {

    private LayoutInflater layoutInflater;
    private List<Cake> cakeList = new ArrayList<>();

    public CakeAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = layoutInflater.inflate(R.layout.list_item_layout, viewGroup, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(cakeList.get(position));
    }

    @Override
    public int getItemCount() {
        return cakeList.size();
    }

    public void addCakes(List<Cake> cakes) {
        cakeList.addAll(cakes);
        notifyDataSetChanged();
    }

    public void clearCakes() {
        cakeList.clear();
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.cake_icon) protected ImageView cakeIcon;
        @BindView(R.id.textview_title) protected TextView cakeTitle;
        @BindView(R.id.textview_preview_description) protected TextView cakePreviewDescription;

        private Context context;
        private Cake cake;

        public Holder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            ButterKnife.bind(this, itemView);
        }

        public void bind(Cake cake) {
            this.cake = cake;

            cakeTitle.setText(cake.getTitle());
            cakePreviewDescription.setText(cake.getPreviewDescription());

//            Glide.with(context)
//                    .load(cake.getImageUrl())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .into(new ImageHacakeIcon)
        }
    }
}
