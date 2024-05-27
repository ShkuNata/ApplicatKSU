package com.example.applicatksu.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicatksu.R;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    Context context;
    ArrayList<User> arrayList;
    OnItemClickListener onItemClickListener;

    public UserAdapter(Context context, ArrayList<User> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.email.setText(arrayList.get(position).getEmail());
        holder.name.setText(arrayList.get(position).getName());
        holder.surname.setText(arrayList.get(position).getSurname());
        holder.role.setText(arrayList.get(position).getRole());
        holder.itemView.setOnClickListener(view -> onItemClickListener.onClick(arrayList.get(position)));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView email, name, surname, role;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            email = itemView.findViewById(R.id.list_item_email);
            name = itemView.findViewById(R.id.list_item_name);
            surname = itemView.findViewById(R.id.list_item_surname);
            role = itemView.findViewById(R.id.list_item_role);
        }
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener{
        void onClick(User user);
    }
}
