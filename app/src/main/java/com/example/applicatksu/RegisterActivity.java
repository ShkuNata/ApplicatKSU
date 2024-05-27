package com.example.applicatksu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.applicatksu.admin.AddUserActivity;
import com.example.applicatksu.admin.AdminActivity;
import com.example.applicatksu.admin.User;
import com.example.applicatksu.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    String role = "applicat";
    private FirebaseAuth mAuth;
    ArrayList<User> arrayList;
    private DatabaseReference mDatabase;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        TextInputEditText email = findViewById(R.id.emailET);
        TextInputEditText name = findViewById(R.id.nameET);
        TextInputEditText surname = findViewById(R.id.surnameET);
        TextInputEditText password = findViewById(R.id.passwordET);

        MaterialButton addUser = findViewById(R.id.registerUser);

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Необходимо заполнить поле 'Почта'!", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Необходимо заполнить поле 'Пароль'!", Toast.LENGTH_SHORT).show();
                } else if (name.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Необходимо заполнить поле 'Имя'!", Toast.LENGTH_SHORT).show();
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
                                        userInfo.put("role", Objects.requireNonNull(role).toString());

                                        mDatabase.child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(userInfo);

                                        Toast.makeText(RegisterActivity.this, "Вы успешно зарегистрированны!", Toast.LENGTH_SHORT).show();

                                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                        finish();
                                    } else {
                                        Toast.makeText(RegisterActivity.this, "Не удалось зарегистрировать пользователя!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}
