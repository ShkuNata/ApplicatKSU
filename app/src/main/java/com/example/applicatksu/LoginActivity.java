package com.example.applicatksu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicatksu.admin.AdminActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference();

        TextInputEditText email = findViewById(R.id.emailET);
        TextInputEditText password = findViewById(R.id.passwordET);

        MaterialButton loginUser = findViewById(R.id.loginUser);

        TextView go_to_register_activity_tv = findViewById(R.id.go_to_register_activity_tv);

        loginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Необходимо заполнить поле 'Почта'!", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Необходимо заполнить поле 'Пароль'!", Toast.LENGTH_SHORT).show();
                } else{
                    mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                FirebaseUser currentUser = mAuth.getCurrentUser();
                                if(currentUser != null){
                                    String userId = currentUser.getUid();

                                    databaseReference.child("Users").child(userId).child("role").addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                String role = snapshot.getValue(String.class);
                                                // Теперь у вас есть роль пользователя, и вы можете использовать её для проверки доступа
                                                if ("admin".equals(role)) {
                                                    startActivity(new Intent(LoginActivity.this, AdminActivity.class));
                                                    Toast.makeText(getApplicationContext(), "Вход в систему прошел успешно!", Toast.LENGTH_LONG).show();
                                                    finish();// Пользователь является администратором
                                                } else if("applicat".equals(role)) {
                                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                                    Toast.makeText(getApplicationContext(), "Вход в систему прошел успешно!", Toast.LENGTH_LONG).show();
                                                    finish();//Пользователь является абитуриентом
                                                }
                                            }
                                        }
                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {
                                            Toast.makeText(getApplicationContext(), "Вход в систему не удался!", Toast.LENGTH_LONG).show();
                                        }
                                    });
                                }

                            } else {Toast.makeText(getApplicationContext(), "Вход в систему не удался!"+ task.getException().getMessage(), Toast.LENGTH_LONG).show();}
                        }
                    });
                }
            }
        });
        go_to_register_activity_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });
    }
}
