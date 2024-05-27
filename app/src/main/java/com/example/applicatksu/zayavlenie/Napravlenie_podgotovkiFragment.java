package com.example.applicatksu.zayavlenie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.example.applicatksu.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;


public class Napravlenie_podgotovkiFragment extends Fragment {

    public Napravlenie_podgotovkiFragment() {super(R.layout.fragment_napravlenie_podgotovki);}
    private DatabaseReference mDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_napravlenie_podgotovki, container, false);
    }
}