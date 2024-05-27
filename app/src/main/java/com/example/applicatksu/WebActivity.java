package com.example.applicatksu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        wb = findViewById(R.id.WB);

        String url = getIntent().getExtras().getString("url");
        wb.loadUrl(url);



    }
}