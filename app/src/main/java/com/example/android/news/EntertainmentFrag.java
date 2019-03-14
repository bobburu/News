package com.example.android.news;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.news.NetworkConnection.GetNewsArticles;
import com.example.android.news.NetworkConnection.HttpRequest;
import com.example.android.news.NetworkConnection.SampleAsyncTaskLoader;
import com.example.android.news.NetworkConnection.SampleNewsAsynTask;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntertainmentFrag extends Fragment implements LoaderManager.LoaderCallbacks<List<NewsItem>> {


    public EntertainmentFrag() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;

    NewsIListItemsAdapter mAdapter;

    /**
     * URL for the headlines
     */
    private static final String NEWS_URL = "https://newsapi.org/v2/top-headlines?country=in&category=entertainment&apiKey=36ea9548713341c2a86f3aca28a60ae7";

    private static final int LOADER_ID = 2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragments_tab, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.news_list_recycler_view);

        /** Create new async task to get the news articles and to update the UI
         * execute the async tak
         */
        getLoaderManager().initLoader(LOADER_ID, null, this);

        return view;
    }

    @Override
    public Loader<List<NewsItem>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new SampleAsyncTaskLoader(getContext(), NEWS_URL);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<NewsItem>> loader, List<NewsItem> newsItems) {

        mAdapter = new NewsIListItemsAdapter(getContext(), newsItems);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<NewsItem>> loader) {
        recyclerView.setAdapter(null);
    }

}
