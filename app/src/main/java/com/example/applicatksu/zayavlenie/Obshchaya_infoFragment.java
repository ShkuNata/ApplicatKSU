package com.example.applicatksu.zayavlenie;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.applicatksu.R;
import com.example.applicatksu.admin.App;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Obshchaya_infoFragment extends Fragment {
    public Obshchaya_infoFragment(){
        super(R.layout.fragment_obshchaya_info);
    }
    private DatabaseReference mDatabase;
    TextInputEditText surname, name, otchestvo, berthday, berthplace ;
    CheckBox soglas;
    MaterialButton saveZayavlenie ;
    RadioGroup genderRG;
    RadioButton men, women;
    String gender="";

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        surname = view.findViewById(R.id.surnameET);
        name = view.findViewById(R.id.nameET);
        otchestvo = view.findViewById(R.id.otchestvoET);
        berthday = view.findViewById(R.id.berthdayET);
        berthplace = view.findViewById(R.id.berthplaceET);

        genderRG = view.findViewById(R.id.genderRadioGroup);

        saveZayavlenie = view.findViewById(R.id.saveBtn);

        soglas = view.findViewById(R.id.soglas_checkBox);

        men = view.findViewById(R.id.MRadioButton);
        women = view.findViewById(R.id.WRadioButton);

        saveZayavlenie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(soglas.isChecked()) {
                    if(men.isChecked()){
                        gender="men";
                    }
                    else if(women.isChecked()){
                        gender="women";
                    }

                    Map<String, Object> zayavlenie = new HashMap<>();
                    zayavlenie.put("surname", surname.getText().toString());
                    zayavlenie.put("name", name.getText().toString());
                    zayavlenie.put("otchestvo", otchestvo.getText().toString());
                    zayavlenie.put("berthday", berthday.getText().toString());
                    zayavlenie.put("berthplace", berthplace.getText().toString());
                    zayavlenie.put("gender", gender.toString());

                    mDatabase.child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Zayavlenie").updateChildren(zayavlenie).
                            addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getActivity().getApplicationContext(),  "Успешно сохранено!", Toast.LENGTH_SHORT).show();
                                    //startActivity(new Intent(getActivity().getApplicationContext(), Personal_infoFragment.class));
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getActivity().getApplicationContext(),  "Не удалось сохранить данные!", Toast.LENGTH_SHORT).show();
                                }
                            });
                }else {
                    Toast.makeText(getActivity().getApplicationContext(),  "Без согласия !", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                View view =inflater.inflate(R.layout.fragment_obshchaya_info, container, false);

         // return view
        return view;
    }


}