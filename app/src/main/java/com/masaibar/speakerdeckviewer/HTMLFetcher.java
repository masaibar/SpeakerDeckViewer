package com.masaibar.speakerdeckviewer;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HTMLFetcher {

    private OkHttpClient mClient;

    public HTMLFetcher(OkHttpClient client) {
        mClient = client;
    }

    public void fetch(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        mClient.newCall(request).enqueue(callback);
    }

}
