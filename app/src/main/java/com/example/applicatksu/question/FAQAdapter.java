package com.example.applicatksu.question;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.applicatksu.R;

import java.util.List;

public class FAQAdapter extends RecyclerView.Adapter<FAQAdapter.ViewHolder> {

    private List<Question> questions;

    public FAQAdapter(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public FAQAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.questionTextView.setText(question.getQuestion());
        holder.answerTextView.setText(question.getAnswer());
        holder.itemView.setOnClickListener(v -> {
            // Раскрытие или скрытие ответа
            boolean isVisible = holder.answerTextView.getVisibility() == View.VISIBLE;
            holder.answerTextView.setVisibility(isVisible ? View.GONE : View.VISIBLE);
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView questionTextView;
        TextView answerTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.questionTextView);
            answerTextView = itemView.findViewById(R.id.answerTextView);
            answerTextView.setVisibility(View.GONE); // Скрыть ответ по умолчанию
        }
    }
}

