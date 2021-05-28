package com.example.zurhemapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zurhemapp.R;
import com.example.zurhemapp.activity.CategoryItemActivity;
import com.example.zurhemapp.activity.ProductDetailsActivity;
import com.example.zurhemapp.model.Datum;

import java.util.List;

public class CategoryItemsAdapter extends RecyclerView.Adapter<CategoryItemsAdapter.ViewHolder> {

    private Context context;
    private List<Datum> categoryItemsList;

    public CategoryItemsAdapter(Context context, List<Datum> categoryItemsList) {
        this.context = context;
        this.categoryItemsList = categoryItemsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.each_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(context.getString(R.string.imgUrl).concat(categoryItemsList.get(position).getImage())).into(holder.productImage);
        holder.proName.setText(categoryItemsList.get(position).getName());
        holder.proPrice.setText(categoryItemsList.get(position).getPrice());


        holder.productImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProductDetailsActivity.class);
                intent.putExtra("id", categoryItemsList.get(position).getId());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryItemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView proName, proPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            proName = itemView.findViewById(R.id.proName);
            proPrice = itemView.findViewById(R.id.proPrice);

        }
    }
}
