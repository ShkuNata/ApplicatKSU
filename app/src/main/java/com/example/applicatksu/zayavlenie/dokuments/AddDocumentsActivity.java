package com.example.applicatksu.zayavlenie.dokuments;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.applicatksu.R;
import com.example.applicatksu.ZayavlenieActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class AddDocumentsActivity extends AppCompatActivity {
    private FloatingActionButton uploadButton;
    private ImageView uploadImage;
    TextInputEditText uploadCaption;
    ProgressBar progressBar;
    private Uri imageUri;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_documents);

        uploadButton = findViewById(R.id.add_doc_btn);
        uploadCaption = findViewById(R.id.name_doc_ET);
        uploadImage = findViewById(R.id.uploadImage);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            imageUri = data.getData();
                            uploadImage.setImageURI(imageUri);
                        }else {
                            Toast.makeText(AddDocumentsActivity.this, "Изображение не выбрано!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
    );
        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phonePicker = new Intent();
                phonePicker.setAction(Intent.ACTION_GET_CONTENT);
                phonePicker.setType("image/*");
                activityResultLauncher.launch(phonePicker);
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caption = uploadCaption.getText().toString();
                if(imageUri != null && !caption.isEmpty()){
                    uploadImageToFirebase(caption, imageUri);
                }else{
                    Toast.makeText(AddDocumentsActivity.this, "Пожалуйста, введите название и выберете изображение!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void uploadImageToFirebase(String caption, Uri imageUri) {
        progressBar.setVisibility(View.VISIBLE);
        StorageReference imageReference = storageReference.child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(caption);

        imageReference.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                imageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        saveDocumentInfoToDatabase(caption, uri);
                    }
                });
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                // Обновление прогресса загрузки
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(AddDocumentsActivity.this, "Неудалось загрузить!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveDocumentInfoToDatabase(String caption, Uri downloadUri) {
        DataClass dataClass = new DataClass(downloadUri.toString(), caption);
        databaseReference.child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Zayavlenie").child("doc").child(caption).setValue(dataClass)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(AddDocumentsActivity.this, "Изображение загружено!", Toast.LENGTH_SHORT).show();
                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("photo", dataClass);
                        setResult(Activity.RESULT_OK, returnIntent);
                        finish();
                    }
                });
    }
}