package com.example.applicatksu.zayavlenie.dokuments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.applicatksu.R;

import java.time.Instant;
import java.util.ArrayList;

public class DocAdapter extends RecyclerView.Adapter<DocAdapter.MyViewHolder> {
    private ArrayList<DataClass> dataList;
    private Context context;
    public DocAdapter(ArrayList<DataClass> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.doc_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getImageURL()).into(holder.imageDoc);
        holder.nameDoc.setText(dataList.get(position).getCaption());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageDoc;
        TextView nameDoc;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            imageDoc = itemView.findViewById(R.id.image_doc);
            nameDoc = itemView.findViewById(R.id.name_doc);
        }
    }
}
