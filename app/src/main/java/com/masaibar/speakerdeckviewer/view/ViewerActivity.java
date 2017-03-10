package com.masaibar.speakerdeckviewer.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.masaibar.speakerdeckviewer.R;

public class ViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);

        setUrlText();
    }

    private void setUrlText() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }

        String data = intent.getDataString();

        if (TextUtils.isEmpty(data)) {
            return;
        }

        ((TextView) findViewById(R.id.text_url)).setText(data);
    }
}
