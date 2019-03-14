package com.example.android.news.NetworkConnection;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.news.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequest {

    private static final String LOG_TAG = "Network Connection";

    // To make sure HttpRequest is not accidentally accessed
    public HttpRequest() {
    }

    public static String getJsonResponse(String stringUrl) {
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        String jsonResponse = "";

        // if the url string is empty return
        if (stringUrl == null) {
            return null;
        }

        try {

            /**
             * Establish a new network connection using the url
             */
            httpURLConnection = (HttpURLConnection) (new URL(stringUrl).openConnection());
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.connect();

            // Read input stream and get json response only if the network connection is success
            if (httpURLConnection.getResponseCode() == 200) {
                /** Get the input stream */
                inputStream = httpURLConnection.getInputStream();

                /**
                 * Read the response and assign the response to the jsonResponse string
                 */
                StringBuilder builder = new StringBuilder();
                String line = null;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                try {
                    while ((line = bufferedReader.readLine()) != null) {
                        builder.append(line);
                    }
                    jsonResponse = builder.toString();
                } catch (IOException e) {
                    Log.e(LOG_TAG, "Error with getting the json response", e);
                } finally {
                    inputStream.close();
                    httpURLConnection.disconnect();
                }
            }

        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with the url", e);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error with the network connection");
        }
        return jsonResponse;
    }

    public static Bitmap getBitmap(String stringUrl) throws IOException {
        Bitmap bitmap = null;
        InputStream inputStream = null;
        try {
            URL imageUrl = new URL(stringUrl);
            inputStream = imageUrl.openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error with retrieving image form url", e);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return bitmap;
    }
}





