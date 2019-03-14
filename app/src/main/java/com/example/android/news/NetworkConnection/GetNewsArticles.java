package com.example.android.news.NetworkConnection;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.android.news.NewsItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetNewsArticles {

    private static final String LOG_TAG = "JSON parsing";

    public static List<NewsItem> newsArticlesDetails(String jsonData) {

        List<NewsItem> articles = new ArrayList<>();

        if (jsonData == null) {
            return null;
        }

        try {
            JSONObject newsObject = new JSONObject(jsonData);
            JSONArray articlesArray = newsObject.getJSONArray("articles");

            for (int i = 0; i < articlesArray.length(); i++) {
                JSONObject singleNewsObject = articlesArray.getJSONObject(i);
                String title = singleNewsObject.getString("title");
                Log.w(LOG_TAG, "Title -- " +title);
                String dateString = singleNewsObject.getString("publishedAt");
                String imageUrl = singleNewsObject.getString("urlToImage");
                Bitmap bitmap = HttpRequest.getBitmap(imageUrl);
                String localDate = GetNewsArticles.formattedDate(dateString);
                NewsItem newsItem = new NewsItem(title, localDate, bitmap);
                articles.add(newsItem);
            }
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Error with parsing JSON", e);
        } catch (IOException e){
            Log.e(LOG_TAG, "Error with parsing JSON", e);
        }

        return articles;
    }


    public static String formattedDate(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            Log.e(LOG_TAG, "Error with parsing date", e);
        }
        return timeFormat.format(date);
    }

}


