package com.example.applicatksu.zayavlenie;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

public class Personal_infoFragment extends Fragment {
    public Personal_infoFragment() {super(R.layout.fragment_personal_info);}
    private DatabaseReference mDatabase;
    TextInputEditText numberPasport, seriyaPasport, vydanPasport, dataPasport, kodPasport;
    TextInputEditText gorodPropiska, stritPropiska, numberDomPropiska, numberKorpusPropiska, kvartiraPropiska;
    TextInputEditText gorodProzhivani, stritProzhivani, numberDomProzhivani, numberKorpusProzhivani, kvartiraProzhivani;
    Spinner oblastPropiska, oblastProzhivani;
    CheckBox adressSovpadeniy;
    MaterialButton saveZayavlenie ;
    String oblast_propiski=""; String oblast_prozhivani="";

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Resources res = getResources();
        String[] russianRegions = res.getStringArray(R.array.russian_regions);

        oblastPropiska = view.findViewById(R.id.oblast_propiska);
        oblastProzhivani = view.findViewById(R.id.oblast_prozhivani);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, russianRegions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        oblastPropiska.setAdapter(adapter);
        oblastProzhivani.setAdapter(adapter);

        numberPasport = view.findViewById(R.id.number_pasportET);
        seriyaPasport = view.findViewById(R.id.seriya_pasportET);
        vydanPasport = view.findViewById(R.id.vydan_pasportET);
        dataPasport = view.findViewById(R.id.date_pasportET);
        kodPasport = view.findViewById(R.id.kod_pasportET);

        gorodPropiska = view.findViewById(R.id.gorod_propiskaET);
        stritPropiska = view.findViewById(R.id.strit_propiskaET);
        numberDomPropiska = view.findViewById(R.id.number_dom_propiskaET);
        numberKorpusPropiska = view.findViewById(R.id.number_korpus_propiskaET);
        kvartiraPropiska = view.findViewById(R.id.kvartira_propiskaET);

        gorodProzhivani = view.findViewById(R.id.gorod_prozhivaniET);
        stritProzhivani = view.findViewById(R.id.strit_prozhivaniET);
        numberDomProzhivani = view.findViewById(R.id.number_dom_prozhivaniET);
        numberKorpusProzhivani = view.findViewById(R.id.number_korpus_prozhivaniET);
        kvartiraProzhivani = view.findViewById(R.id.number_korpus_prozhivaniET);

        saveZayavlenie = view.findViewById(R.id.saveBtn);

        adressSovpadeniy = view.findViewById(R.id.adress_sovpadeniy);

        adressSovpadeniy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    oblastPropiska.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                            String selectedValue = (String) parentView.getItemAtPosition(position);
                            ArrayAdapter<String> adapter = (ArrayAdapter<String>) oblastProzhivani.getAdapter();
                            if (adapter != null) {
                                int newPosition = adapter.getPosition(selectedValue);
                                oblastProzhivani.setSelection(newPosition);
                            }
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parentView) {
                            Toast.makeText(getActivity().getApplicationContext(),  "Необходимо заполнить поле 'Область'!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    oblastProzhivani.setEnabled(false);
                    gorodProzhivani.setText(gorodPropiska.getText().toString());
                    gorodProzhivani.setFocusable(false);
                    gorodProzhivani.setFocusableInTouchMode(false);
                    gorodProzhivani.setInputType(InputType.TYPE_NULL);
                    stritProzhivani.setText(stritPropiska.getText().toString());
                    stritProzhivani.setFocusable(false);
                    stritProzhivani.setFocusableInTouchMode(false);
                    stritProzhivani.setInputType(InputType.TYPE_NULL);
                    numberDomProzhivani.setText(numberDomPropiska.getText().toString());
                    numberDomProzhivani.setFocusable(false);
                    numberDomProzhivani.setFocusableInTouchMode(false);
                    numberDomProzhivani.setInputType(InputType.TYPE_NULL);
                    numberKorpusProzhivani.setText(numberKorpusPropiska.getText().toString());
                    numberKorpusProzhivani.setFocusable(false);
                    numberKorpusProzhivani.setFocusableInTouchMode(false);
                    numberKorpusProzhivani.setInputType(InputType.TYPE_NULL);
                    kvartiraProzhivani.setText(kvartiraPropiska.getText().toString());
                    kvartiraProzhivani.setFocusable(false);
                    kvartiraProzhivani.setFocusableInTouchMode(false);
                    kvartiraProzhivani.setInputType(InputType.TYPE_NULL);
                } else {
                    oblastProzhivani.setEnabled(true);
                    gorodProzhivani.setFocusable(true);
                    gorodProzhivani.setFocusableInTouchMode(true);
                    gorodProzhivani.setInputType(InputType.TYPE_CLASS_TEXT);
                    stritProzhivani.setFocusable(true);
                    stritProzhivani.setFocusableInTouchMode(true);
                    stritProzhivani.setInputType(InputType.TYPE_CLASS_TEXT);
                    numberDomProzhivani.setFocusable(true);
                    numberDomProzhivani.setFocusableInTouchMode(true);
                    numberDomProzhivani.setInputType(InputType.TYPE_CLASS_TEXT);
                    numberKorpusProzhivani.setFocusable(true);
                    numberKorpusProzhivani.setFocusableInTouchMode(true);
                    numberKorpusProzhivani.setInputType(InputType.TYPE_CLASS_TEXT);
                    kvartiraProzhivani.setFocusable(true);
                    kvartiraProzhivani.setFocusableInTouchMode(true);
                    kvartiraProzhivani.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }
        });

        saveZayavlenie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                oblastPropiska.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position != 0){
                            oblast_propiski = (String) parent.getItemAtPosition(position);
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getActivity().getApplicationContext(),  "Необходимо заполнить поле 'Область'!", Toast.LENGTH_SHORT).show();
                    }
                });

                oblastProzhivani.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position != 0){
                            oblast_prozhivani = (String) parent.getItemAtPosition(position);
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getActivity().getApplicationContext(),  "Необходимо заполнить поле 'Область'!", Toast.LENGTH_SHORT).show();
                    }
                });

                Map<String, Object> zayavlenie = new HashMap<>();
                zayavlenie.put("numberPasport", numberPasport.getText().toString());
                zayavlenie.put("seriyaPasport", seriyaPasport.getText().toString());
                zayavlenie.put("vydanPasport", vydanPasport.getText().toString());
                zayavlenie.put("dataPasport", dataPasport.getText().toString());
                zayavlenie.put("kodPasport", kodPasport.getText().toString());
                zayavlenie.put("gorodPropiska", gorodPropiska.getText().toString());
                zayavlenie.put("stritPropiska", stritPropiska.getText().toString());
                zayavlenie.put("numberDomPropiska", numberDomPropiska.getText().toString());
                zayavlenie.put("numberKorpusPropiska", numberKorpusPropiska.getText().toString());
                zayavlenie.put("kvartiraPropiska", kvartiraPropiska.getText().toString());
                zayavlenie.put("gorodProzhivani", gorodProzhivani.getText().toString());
                zayavlenie.put("stritProzhivani", stritProzhivani.getText().toString());
                zayavlenie.put("numberDomProzhivani", numberDomProzhivani.getText().toString());
                zayavlenie.put("numberKorpusProzhivani", numberKorpusProzhivani.getText().toString());
                zayavlenie.put("kvartiraProzhivani", kvartiraProzhivani.getText().toString());
                zayavlenie.put("oblast_propiski", oblast_propiski.toString());
                zayavlenie.put("oblast_prozhivani=", oblast_prozhivani.toString());

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
        return inflater.inflate(R.layout.fragment_personal_info, container, false);
    }
}