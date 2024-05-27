package com.example.applicatksu.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.applicatksu.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {

    private DatabaseReference data;
    ArrayList<User> arrayList;
    String s1="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        FirebaseApp.initializeApp(AdminActivity.this);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        data= FirebaseDatabase.getInstance().getReference();
        data.child("Users").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    arrayList = new ArrayList<>();
                    for(DataSnapshot ds:task.getResult().getChildren()){
                            User user = ds.getValue(User.class);
                            user.id=ds.getKey();
                            assert user!=null;
                            arrayList.add(user);
                    }
                    UserAdapter adapter = new UserAdapter(AdminActivity.this, arrayList);
                    recyclerView.setAdapter(adapter);
                    adapter.setOnItemClickListener( new UserAdapter.OnItemClickListener() {
                        @Override
                        public void onClick(User user) {
                            App.user = user;
                            startActivity(new Intent(AdminActivity.this, EditUserActivity.class ));

                        }
                    });
                }
            }
        });
        FloatingActionButton add = findViewById(R.id.add_bt);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity.this, AddUserActivity.class));
            }
        });


    }
}