package com.example.applicatksu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.applicatksu.R;
import com.google.android.material.button.MaterialButton;

public class KalkulyatorActivity extends AppCompatActivity {

    MaterialButton exzamen, napravlenie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulyator);

        exzamen = findViewById(R.id.exzamenBtn);
        napravlenie = findViewById(R.id.napravlenieBtn);

        exzamen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://calc.kursksu.ru/exam")));
            }
        });
        napravlenie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://calc.kursksu.ru/spec")));
            }
        });
    }
}