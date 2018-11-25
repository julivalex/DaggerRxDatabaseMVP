package com.java.note.dagger_rx_database_mvp.modules.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.java.note.dagger_rx_database_mvp.R;
import com.java.note.dagger_rx_database_mvp.mvp.model.Cake;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.Holder> {

    private LayoutInflater layoutInflater;
    private OnCakeClickListener cakeClickListener;
    private List<Cake> cakeList = new ArrayList<>();

    public CakeAdapter(OnCakeClickListener cakeClickListener, LayoutInflater layoutInflater) {
        this.cakeClickListener = cakeClickListener;
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

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.cake_icon) protected ImageView cakeIcon;
        @BindView(R.id.textview_title) protected TextView cakeTitle;
        @BindView(R.id.textview_preview_description) protected TextView cakePreviewDescription;

        private Context context;
        private Cake cake;

        public Holder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bind(Cake cake) {
            this.cake = cake;
            cakeTitle.setText(cake.getTitle());
            cakePreviewDescription.setText(cake.getPreviewDescription());
            Glide.with(context)
                    .load(cake.getImageUrl())
                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA))
                    .into(cakeIcon);
        }

        @Override
        public void onClick(View view) {
            if (cakeClickListener != null) {
                cakeClickListener.onClick(cakeIcon, cake, getAdapterPosition());
            }
        }
    }

    public interface OnCakeClickListener {
        void onClick(View v, Cake cake, int position);
    }
}
