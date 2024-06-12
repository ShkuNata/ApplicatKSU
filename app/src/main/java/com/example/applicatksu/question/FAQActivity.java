package com.example.applicatksu.question;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.applicatksu.R;

import java.util.ArrayList;
import java.util.List;

public class FAQActivity extends AppCompatActivity {

    private RecyclerView faqRecyclerView;
    private FAQAdapter faqAdapter;
    private List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        // Инициализация списка вопросов
        questions = new ArrayList<>();
        // Добавление вопросов и ответов
        questions.add(new Question("Как поступить в университет?", "Для поступления необходимо..."));
        // Другие вопросы и ответы

        faqRecyclerView = findViewById(R.id.faqRecyclerView);
        faqRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        faqAdapter = new FAQAdapter(questions);
        faqRecyclerView.setAdapter(faqAdapter);
    }
}