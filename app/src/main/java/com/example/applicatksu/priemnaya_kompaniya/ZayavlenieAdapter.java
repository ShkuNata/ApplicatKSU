package com.example.applicatksu.priemnaya_kompaniya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicatksu.R;

import java.util.ArrayList;
public class ZayavlenieAdapter extends RecyclerView.Adapter<ZayavlenieAdapter.ViewHolder> {
    Context context;
    ArrayList<Zayavlenie> arrayList;
    OnItemClickListener onItemClickListener;

    public ZayavlenieAdapter(Context context, ArrayList<Zayavlenie> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.zayavlenie_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.surname.setText(arrayList.get(position).getSurname());
        holder.name.setText(arrayList.get(position).getName());
        holder.otchestvo.setText(arrayList.get(position).getOtchestvo());
        holder.itemView.setOnClickListener(view -> onItemClickListener.onClick(arrayList.get(position)));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView otchestvo, name, surname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            surname = itemView.findViewById(R.id.list_item_surname);
            name = itemView.findViewById(R.id.list_item_name);
            otchestvo = itemView.findViewById(R.id.list_item_otchestvo);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onClick(Zayavlenie zayavlenie);
    }
}
