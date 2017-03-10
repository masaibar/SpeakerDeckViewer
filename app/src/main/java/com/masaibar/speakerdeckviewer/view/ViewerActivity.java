package com.masaibar.speakerdeckviewer.view;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.masaibar.speakerdeckviewer.HTMLFetcher;
import com.masaibar.speakerdeckviewer.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class ViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);

        String url = getUrl();
        ((TextView) findViewById(R.id.text_url)).setText(url);

        new HTMLFetcher(new OkHttpClient()).fetch(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("!!!", "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("!!!", "onResponse");
                final String source = response.body().string();
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        ((TextView) findViewById(R.id.text_source)).setText(source);
                    }
                });
            }
        });
    }

    @Nullable
    private String getUrl() {
        Intent intent = getIntent();
        if (intent == null) {
            return null;
        }

        return intent.getDataString();
    }
}
