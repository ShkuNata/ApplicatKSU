package com.example.applicatksu.zayavlenie.dokuments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.applicatksu.MainActivity;
import com.example.applicatksu.R;
import com.example.applicatksu.ZayavlenieActivity;
import com.example.applicatksu.admin.AdminActivity;
import com.example.applicatksu.admin.App;
import com.example.applicatksu.admin.EditUserActivity;
import com.example.applicatksu.admin.User;
import com.example.applicatksu.admin.UserAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class DokumentsFragment extends Fragment {
    private static final int REQUEST_CODE = 123;
    FloatingActionButton add;
    RecyclerView recyclerDoc;
    ArrayList<DataClass> dataList;
    DocAdapter adapter;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;
    DataClass dataClass;

    public DokumentsFragment() {
        super(R.layout.fragment_dokuments);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dokuments, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        add = view.findViewById(R.id.add_doc_btn);
        recyclerDoc = view.findViewById(R.id.rececler_doc);

        recyclerDoc.setHasFixedSize(true);
        recyclerDoc.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        dataList = new ArrayList<>();
        adapter = new DocAdapter(dataList, getActivity().getApplicationContext());
        recyclerDoc.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();

        loadDataFromFirebase();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddDocumentsActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

        private void loadDataFromFirebase() {
            databaseReference.child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Zayavlenie").child("doc").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (!task.isSuccessful()) {
                        Log.e("firebase", "Error getting data", task.getException());
                        Toast.makeText(getActivity(), "Ошибка загрузки данных", Toast.LENGTH_SHORT).show();
                    } else {
                        dataList.clear();
                        for (DataSnapshot dataSnapshot : task.getResult().getChildren()) {
                            DataClass dataClass = dataSnapshot.getValue(DataClass.class);
                            dataList.add(dataClass);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }
            });
        }
        public void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
                DataClass newDocument = data.getParcelableExtra("photo");
                if (newDocument != null) {
                    dataList.add(newDocument);
                    adapter.notifyItemInserted(dataList.size() - 1);
                }
            }
        }
    }






