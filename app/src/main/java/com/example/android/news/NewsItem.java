package com.example.android.news;

import android.graphics.Bitmap;

public class NewsItem {

    private String mTitle;

    private String mTime;

    private Bitmap mImageBitmap;

    public NewsItem(String mTitle, String mTime, Bitmap mImageBitmap) {
        this.mTitle = mTitle;
        this.mTime = mTime;
        this.mImageBitmap = mImageBitmap;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public Bitmap getmImageBitmap() {
        return mImageBitmap;
    }

    public void setmImageBitmap(Bitmap mImageBitmap) {
        this.mImageBitmap = mImageBitmap;
    }
}

