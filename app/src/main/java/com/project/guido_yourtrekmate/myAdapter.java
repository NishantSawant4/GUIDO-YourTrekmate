package com.project.guido_yourtrekmate;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myViewHolder> {
    private Context context;
    private List<DataClass>dataList;

    public myAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.recTitle.setText(dataList.get(position).getDataTitle());
        holder.recLoc.setText(dataList.get(position).getDataLoc());
        holder.recRat.setText(dataList.get(position).getDataRat());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Image",dataList.get(holder.getAdapterPosition()).getDataImage());



                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return dataList.size();
    }
}

class myViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recTitle,recLoc,recRat;
    CardView recCard;
    public myViewHolder(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        recTitle = itemView.findViewById(R.id.recTitle);
        recLoc = itemView.findViewById(R.id.recLoc);
        recRat = itemView.findViewById(R.id.recRat);
    }
}