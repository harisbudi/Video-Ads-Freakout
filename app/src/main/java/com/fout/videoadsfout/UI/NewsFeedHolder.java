package com.fout.videoadsfout.UI;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fout.videoadsfout.Model.News;
import com.fout.videoadsfout.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsFeedHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tx_date_published_listitem) TextView  datepublished;
    @BindView(R.id.tx_uptitle_listitem) TextView uptitle;
    @BindView(R.id.tx_title_listitem) TextView title;
    @BindView(R.id.image_thumb) ImageView image;
    public final View rootView;

    public NewsFeedHolder(View view) {
        super(view);
        rootView = view;
        ButterKnife.bind(this,view);
    }
    public void setdata(News data){
        Picasso.get()
                .load(data.getImage())
                .into(image);
        title.setText(data.getTitle());
        uptitle.setText(data.getRubrik());
        datepublished.setText(data.getDate());
    }
}