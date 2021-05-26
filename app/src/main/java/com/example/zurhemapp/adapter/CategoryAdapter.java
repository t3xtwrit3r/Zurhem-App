package com.example.zurhemapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zurhemapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> categoryNames;

    public CategoryAdapter(Context context, ArrayList<String> categoryNames) {
        this.context = context;
        this.categoryNames = categoryNames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String category = categoryNames.get(position%categoryNames.size());
        holder.categoryName.setText(category);

    }

    @Override
    public int getItemCount() {

        return categoryNames==null?0:Integer.MAX_VALUE;
        
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
        }
    }
}
