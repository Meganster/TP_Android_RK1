package com.example.yury.rk_1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private int[] data;
    private LayoutInflater layoutInflater;
    private Context context;
    private ItemClickListener itemClickListener;

    MyRecyclerViewAdapter(Context context, int[] data) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.myTextView.setId(data[position]);
        holder.myTextView.setText(String.valueOf(data[position]));

        if (data[position] % 2 == 0) {
            holder.myTextView.setTextColor(context.getResources().getColor(R.color.red));
        } else {
            holder.myTextView.setTextColor(context.getResources().getColor(R.color.blue));
        }
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.info_text);
            myTextView.setTextSize(25);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null)
                itemClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    String getItem(int id) {
        return String.valueOf(data[id]);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}