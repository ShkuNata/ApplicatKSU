package com.example.applicatksu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FacultetActivity extends AppCompatActivity {

    TextView defektologicheskijTV, estestvenno_geograficheskijTV, industrialno_pedagogicheskijTV, inostrannyh_yazykovTV;
    TextView institut_ekonomiki_i_upravleniyaTV, iskusstv_i_art_pedagogikiTV, istoricheskijTV, pedagogiki_i_psihologiiTV;
    TextView aspiranturaTV, teologii_i_religiovedeniyaTV, fiziki_matematiki_informatikiTV, fizicheskoj_kultury_i_sportaTV;
    TextView filologicheskijTV, filosofii_i_sociologiiTV, hudozhestvenno_graficheskijTV, yuridicheskijTV;
    TextView kafedra_inostrannyh_yazykov_i_professionalnoj_kommunikaciiTV, kafedra_pedagogiki_i_professionalnogo_obrazovaniyaTV;
    TextView kafedra_psihologiiTV, kafedra_russkogo_yazyka_dlya_inostrannyh_grazhdanTV, kafedra_socialnoj_rabotyTV;
    TextView kolledzh_kommercii_tekhnologij_i_servisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultet);

        defektologicheskijTV = findViewById(R.id.defektologicheskijTV);
        estestvenno_geograficheskijTV = findViewById(R.id.estestvenno_geograficheskijTV);
        industrialno_pedagogicheskijTV = findViewById(R.id.industrialno_pedagogicheskijTV);
        inostrannyh_yazykovTV = findViewById(R.id.inostrannyh_yazykovTV);
        institut_ekonomiki_i_upravleniyaTV = findViewById(R.id.institut_ekonomiki_i_upravleniyaTV);
        iskusstv_i_art_pedagogikiTV = findViewById(R.id.iskusstv_i_art_pedagogikiTV);
        istoricheskijTV = findViewById(R.id.istoricheskijTV);
        pedagogiki_i_psihologiiTV = findViewById(R.id.pedagogiki_i_psihologiiTV);
        aspiranturaTV = findViewById(R.id.aspiranturaTV);
        teologii_i_religiovedeniyaTV = findViewById(R.id.teologii_i_religiovedeniyaTV);
        fiziki_matematiki_informatikiTV = findViewById(R.id.fiziki_matematiki_informatikiTV);
        fizicheskoj_kultury_i_sportaTV = findViewById(R.id.fizicheskoj_kultury_i_sportaTV);
        filologicheskijTV = findViewById(R.id.filologicheskijTV);
        filosofii_i_sociologiiTV = findViewById(R.id.filosofii_i_sociologiiTV);
        hudozhestvenno_graficheskijTV = findViewById(R.id.hudozhestvenno_graficheskijTV);
        yuridicheskijTV = findViewById(R.id.yuridicheskijTV);

        kafedra_inostrannyh_yazykov_i_professionalnoj_kommunikaciiTV = findViewById(R.id.kafedra_inostrannyh_yazykov_i_professionalnoj_kommunikaciiTV);
        kafedra_pedagogiki_i_professionalnogo_obrazovaniyaTV = findViewById(R.id.kafedra_pedagogiki_i_professionalnogo_obrazovaniyaTV);
        kafedra_psihologiiTV = findViewById(R.id.kafedra_psihologiiTV);
        kafedra_russkogo_yazyka_dlya_inostrannyh_grazhdanTV = findViewById(R.id.kafedra_russkogo_yazyka_dlya_inostrannyh_grazhdanTV);
        kafedra_socialnoj_rabotyTV = findViewById(R.id.kafedra_socialnoj_rabotyTV);

        kolledzh_kommercii_tekhnologij_i_servisa = findViewById(R.id.kolledzh_kommercii_tekhnologij_i_servisa);

        defektologicheskijTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/faculties/view/defectology")));
                Intent intent = new Intent(FacultetActivity.this, WebActivity.class);
                intent.putExtra("url", "https://kursksu.ru/faculties/view/defectology");
                startActivity(intent);
            }
        });

        estestvenno_geograficheskijTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/faculties/view/geography")));
                Intent intent = new Intent(FacultetActivity.this, WebActivity.class);
                intent.putExtra("url", "https://kursksu.ru/faculties/view/geography");
                startActivity(intent);
            }
        });

        industrialno_pedagogicheskijTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/faculties/view/industrial")));
            }
        });

        inostrannyh_yazykovTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/faculties/view/foreign_languages")));
            }
        });

        institut_ekonomiki_i_upravleniyaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/faculties/view/economics")));
            }
        });

        iskusstv_i_art_pedagogikiTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/faculties/view/art")));
                Intent intent = new Intent(FacultetActivity.this, WebActivity.class);
                intent.putExtra("url", "https://kursksu.ru/faculties/view/art");
                startActivity(intent);
            }
        });

        istoricheskijTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/faculties/view/history")));
            }
        });

        pedagogiki_i_psihologiiTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/faculties/view/psychology-teaching")));
            }
        });

        aspiranturaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/faculties/view/qualification")));
            }
        });

        teologii_i_religiovedeniyaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/faculties/view/teology")));
            }
        });

        fiziki_matematiki_informatikiTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/faculties/view/FMI")));
            }
        });

        fizicheskoj_kultury_i_sportaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/faculties/view/sport")));
            }
        });

        filologicheskijTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/faculties/view/philology")));
            }
        });

        filosofii_i_sociologiiTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/faculties/view/philosophy")));
            }
        });

        hudozhestvenno_graficheskijTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/faculties/view/graph")));
            }
        });

        yuridicheskijTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/faculties/view/law")));
            }
        });

        kafedra_inostrannyh_yazykov_i_professionalnoj_kommunikaciiTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/departments/about/Foreign_Languages_Prof_Communication")));
            }
        });

        kafedra_pedagogiki_i_professionalnogo_obrazovaniyaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/departments/about/pedsh")));
            }
        });

        kafedra_psihologiiTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/departments/about/psychology")));
            }
        });


        kafedra_russkogo_yazyka_dlya_inostrannyh_grazhdanTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/departments/about/foreignstuds")));
            }
        });

        kafedra_socialnoj_rabotyTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/departments/about/social_work_and_it_in_social_sphere")));
            }
        });

        kolledzh_kommercii_tekhnologij_i_servisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kursksu.ru/offices/information/col_commercial")));
            }
        });

    }
}