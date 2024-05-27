package com.example.applicatksu.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.applicatksu.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class AddUserActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    ArrayList<User> arrayList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        mAuth = FirebaseAuth.getInstance();

        TextInputEditText email = findViewById(R.id.emailET);
        TextInputEditText name = findViewById(R.id.nameET);
        TextInputEditText surname = findViewById(R.id.surnameET);
        TextInputEditText password = findViewById(R.id.passwordET);
        TextInputEditText role = findViewById(R.id.roleET);

        MaterialButton addUser = findViewById(R.id.addUser);

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Необходимо заполнить поле 'Почта'!", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Необходимо заполнить поле 'Пароль'!", Toast.LENGTH_SHORT).show();
                } else if (name.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Необходимо заполнить поле 'Имя'!", Toast.LENGTH_SHORT).show();
                } else if (role.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Необходимо заполнить поле 'Роль'!", Toast.LENGTH_SHORT).show();
                } else if (surname.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Необходимо заполнить поле 'Фамилия'!", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.createUserWithEmailAndPassword(Objects.requireNonNull(email.getText()).toString(), Objects.requireNonNull(password.getText()).toString()).
                            addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        HashMap<String, Object> userInfo = new HashMap<>();
                                        userInfo.put("email", Objects.requireNonNull(email.getText()).toString());
                                        userInfo.put("surname", Objects.requireNonNull(surname.getText()).toString());
                                        userInfo.put("name", Objects.requireNonNull(name.getText()).toString());
                                        userInfo.put("role", Objects.requireNonNull(role.getText()).toString());

                                        mDatabase.child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(userInfo);

                                        Toast.makeText(AddUserActivity.this,"Пользователь успешно добавлен!", Toast.LENGTH_SHORT).show();

                                        startActivity(new Intent(AddUserActivity.this, AdminActivity.class));
                                        finish();
                                    }else{
                                        Toast.makeText(AddUserActivity.this,"Не удалось добавить пользователя!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}







































