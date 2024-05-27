package com.example.applicatksu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PriemnayaKomissiaActivity extends AppCompatActivity {

    TextView adres_map_inf, adres_map_inost_inf;
    TextView spoTV, vo_bacTV, vo_magTV, vo_aspTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priemnaya_komissia);

        adres_map_inf = findViewById(R.id.adres_map_inf);
        adres_map_inost_inf = findViewById(R.id.adres_map_inost_inf);

        spoTV = findViewById(R.id.spoTV);
        vo_bacTV = findViewById(R.id.vo_bacTV);
        vo_magTV = findViewById(R.id.vo_magTV);
        vo_aspTV = findViewById(R.id.vo_aspTV);

        adres_map_inf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:51.735498, 36.191748")));
            }
        });

        adres_map_inost_inf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:51.734310, 36.190581")));
            }
        });

        spoTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kursksu.ru/abitur/spo_sredn/")));
            }
        });

        vo_bacTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kursksu.ru/abitur/bachelor/")));
            }
        });

        vo_magTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kursksu.ru/abitur/magistr/")));
            }
        });

        vo_aspTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kursksu.ru/abitur/aspirant/")));
            }
        });
    }
}