package com.example.applicatksu.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class EditUserActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        TextInputEditText email = findViewById(R.id.emailET);
        TextInputEditText name = findViewById(R.id.nameET);
        TextInputEditText surname = findViewById(R.id.surnameET);
        TextInputEditText password = findViewById(R.id.passwordET);
        TextInputEditText role = findViewById(R.id.roleET);

        MaterialButton deleteUser = findViewById(R.id.deleteUser);
        MaterialButton saveUser = findViewById(R.id.saveUser);

        email.setText(App.user.getEmail());
        name.setText(App.user.getName());
        surname.setText(App.user.getSurname());
        password.setText(App.user.getPassword());
        role.setText(App.user.getRole());

        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).removeValue().
                        addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(EditUserActivity.this,"Пользователь успешно удален!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(EditUserActivity.this, AdminActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(EditUserActivity.this,"Не удалось удалить пользователя!",Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        saveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> user = new HashMap<>();
                user.put("email", email.getText().toString());
                user.put("name", name.getText().toString());
                user.put("surname", surname.getText().toString());
                user.put("password", password.getText().toString());
                user.put("role", role.getText().toString());

                mDatabase.child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(user).
                        addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(EditUserActivity.this, "Успешно сохранено!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(EditUserActivity.this, AdminActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(EditUserActivity.this, "Не удалось сохранить изменения!", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });

    }
}