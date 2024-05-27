package com.example.applicatksu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ImageView exitIv;
    MaterialButton podatZayavlenieBtn ;
    MaterialButton priemnaya_kompaniyaBtn ;
    MaterialButton fakultetyBtn ;
    MaterialButton napravlenie_podgotovkiBtnr ;
    MaterialButton kalkulyator_rgrBtn ;
    MaterialButton kalendar_postupleniyaBtn ;
    MaterialButton voprosy_i_otvetyBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priemnaya_kompaniyaBtn = findViewById(R.id.priemnaya_kompaniyaBtn);
        fakultetyBtn = findViewById(R.id.fakultetyBtn);
        napravlenie_podgotovkiBtnr = findViewById(R.id.napravlenie_podgotovkiBtn);
        kalkulyator_rgrBtn = findViewById(R.id.kalkulyator_rgrBtn);
        kalendar_postupleniyaBtn = findViewById(R.id.kalendar_postupleniyaBtn);
        voprosy_i_otvetyBtn = findViewById(R.id.voprosy_i_otvetyBtn);
        podatZayavlenieBtn=findViewById(R.id.podatZayavlenieBtn);

        exitIv = findViewById(R.id.exitIv);

        exitIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });

        podatZayavlenieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ZayavlenieActivity.class));
            }
        });

        priemnaya_kompaniyaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PriemnayaKomissiaActivity.class));
            }
        });

        fakultetyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FacultetActivity.class));
            }
        });

        kalkulyator_rgrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KalkulyatorActivity.class));
            }
        });



    }
}