package com.project.guido_yourtrekmate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class postAdapter extends RecyclerView.Adapter<postAdapter.ViewHolder> {
    public List<Posted> dataList1;
    public Context context1;

    public postAdapter(Context context1, List<Posted> dataList1){
        this.context1 =context1;
        this.dataList1=dataList1;
    }

    @NonNull
    @Override
    public postAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context1).inflate(R.layout.post_recycler, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull postAdapter.ViewHolder holder, int position) {
        Posted p = dataList1.get(position);
        holder.textView1.setText(p.getNameId());
        holder.postText.setText(p.getPostedMsg());
    }

    @Override
    public int getItemCount() {
        return dataList1.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView1, postText;

        public ViewHolder(View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.tv_id);
            postText = itemView.findViewById(R.id.tv_posted);
        }
    }
}
