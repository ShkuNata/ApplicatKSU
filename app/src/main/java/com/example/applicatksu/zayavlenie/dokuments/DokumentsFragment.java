package com.example.applicatksu.zayavlenie.dokuments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applicatksu.MainActivity;
import com.example.applicatksu.R;
import com.example.applicatksu.ZayavlenieActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DokumentsFragment extends Fragment {

    FloatingActionButton add;
    public DokumentsFragment() {super(R.layout.fragment_dokuments);}

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        add = view.findViewById(R.id.add_doc_btn);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity(), AddDocumentsActivity.class);
                startActivity(intent);
            }
        });

    }

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dokuments, container, false);
    }
}