package com.example.android.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewsIListItemsAdapter extends RecyclerView.Adapter<NewsIListItemsAdapter.MyViewHolder> {


    private Context mContext;
    private List<NewsItem> newsArticles;

    public NewsIListItemsAdapter(Context mContext, List<NewsItem> newsArticles) {
        this.mContext = mContext;
        this.newsArticles = newsArticles;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.news_list_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {

        myViewHolder.newsItemImage.setImageBitmap(newsArticles.get(i).getmImageBitmap());
        myViewHolder.newsItemTitle.setText(newsArticles.get(i).getmTitle());
        myViewHolder.newsItemTime.setText(newsArticles.get(i).getmTime());

    }

    @Override
    public int getItemCount() {
        return newsArticles.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView newsItemImage;
        TextView newsItemTitle;
        TextView newsItemTime;

        public MyViewHolder(View itemView) {
            super(itemView);

            newsItemImage = (ImageView) itemView.findViewById(R.id.item_image);
            newsItemTitle = (TextView) itemView.findViewById(R.id.item_title_text_view);
            newsItemTime = (TextView) itemView.findViewById(R.id.item_time_text_view);
        }
    }
}
