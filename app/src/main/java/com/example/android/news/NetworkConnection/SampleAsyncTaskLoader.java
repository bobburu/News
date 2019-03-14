package com.example.android.news.NetworkConnection;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import com.example.android.news.NewsItem;

import java.io.IOException;
import java.util.List;

public class SampleAsyncTaskLoader extends AsyncTaskLoader<List<NewsItem>> {

    private Context mContext;
    private String mUrl;

    public SampleAsyncTaskLoader(Context context, String mUrl) {
        super(context);
        this.mUrl = mUrl;
    }


    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<NewsItem> loadInBackground() {
        if (mUrl == null){
            return null;
        }
        String jsonResponse = HttpRequest.getJsonResponse(mUrl);
        List<NewsItem> articlesList = GetNewsArticles.newsArticlesDetails(jsonResponse);
        return articlesList;
    }
}
