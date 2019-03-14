package com.example.android.news.NetworkConnection;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.news.NewsIListItemsAdapter;
import com.example.android.news.NewsItem;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SampleNewsAsynTask extends AsyncTask<String, Void, List<NewsItem>> {

    private List<NewsItem> articlesList = null;
    private Context mContext;
    private RecyclerView mRecyclerView;
    private NewsIListItemsAdapter adapter;

    public SampleNewsAsynTask(Context mContext, RecyclerView mRecyclerView) {
        this.mContext = mContext;
        this.mRecyclerView = mRecyclerView;
    }

    @Override
    protected List<NewsItem> doInBackground(String... urlString) {
//        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        String jsonResponse = HttpRequest.getJsonResponse(urlString[0]);
        articlesList = GetNewsArticles.newsArticlesDetails(jsonResponse);
        return articlesList;
    }

    @Override
    protected void onPostExecute(List<NewsItem> newsItems) {
        super.onPostExecute(newsItems);
        updateUi(newsItems);
    }

    private void updateUi(List<NewsItem> newsItems) {
        adapter = new NewsIListItemsAdapter(mContext, newsItems);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext);

        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(adapter);
    }
}
