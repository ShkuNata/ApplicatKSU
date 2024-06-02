package com.example.applicatksu.zayavlenie;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.applicatksu.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ObrazovanieFragment extends Fragment {

    public ObrazovanieFragment() {super(R.layout.fragment_obrazovanie);}
    private DatabaseReference mDatabase;

    Spinner urovenObrazovania;
    String uroven_obrazovania="";
    TextInputEditText numberObrazovania, seriyObrazovania, nameObrazovania, dateVidachi, sradniyBall, language;
    MaterialButton saveZayavlenie;

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

    mDatabase = FirebaseDatabase.getInstance().getReference();

    urovenObrazovania = view.findViewById(R.id.uroven_obrazovania);

    numberObrazovania = view.findViewById(R.id.nubmer_obrazovaniaET);
    seriyObrazovania = view.findViewById(R.id.seriy_obrazovaniaET);
    nameObrazovania = view.findViewById(R.id.name_obrazovaniaET);
    dateVidachi = view.findViewById(R.id.date_vidachiET);
    sradniyBall = view.findViewById(R.id.sredniy_ballET);
    language = view.findViewById(R.id.languageET);

    saveZayavlenie = view.findViewById(R.id.saveBtn);

    Resources res = getResources();
    String[] education_levels_array = res.getStringArray(R.array.education_levels_array);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, education_levels_array);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    urovenObrazovania.setAdapter(adapter);

        saveZayavlenie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                urovenObrazovania.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position != 0){
                            uroven_obrazovania = (String) parent.getItemAtPosition(position);
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getActivity().getApplicationContext(),  "Необходимо заполнить поле 'Уровень образования'!", Toast.LENGTH_SHORT).show();
                    }
                });

                Map<String, Object> zayavlenie = new HashMap<>();
                zayavlenie.put("urovenObrazovania", uroven_obrazovania.toString());
                zayavlenie.put("numberObrazovania", numberObrazovania.getText().toString());
                zayavlenie.put("seriyObrazovania", seriyObrazovania.getText().toString());
                zayavlenie.put("nameObrazovania", nameObrazovania.getText().toString());
                zayavlenie.put("dateVidachi", dateVidachi.getText().toString());
                zayavlenie.put("sradniyBall", sradniyBall.getText().toString());
                zayavlenie.put("language", language.getText().toString());


                mDatabase.child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Zayavlenie").updateChildren(zayavlenie).
                        addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getActivity().getApplicationContext(),  "Успешно сохранено!", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getActivity().getApplicationContext(),  "Не удалось сохранить данные!", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_obrazovanie, container, false);
    }
}