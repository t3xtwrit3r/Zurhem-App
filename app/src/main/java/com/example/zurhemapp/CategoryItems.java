package com.example.zurhemapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.zurhemapp.Adapter.CategoryItemsAdapter;

public class CategoryItems extends AppCompatActivity {

    RecyclerView categoryItems;
    CategoryItemsAdapter categoryItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_items);

        categoryItems = findViewById(R.id.categoryItems);

        categoryItemsAdapter = new CategoryItemsAdapter(CategoryItems.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CategoryItems.this, RecyclerView.VERTICAL, false);
        categoryItems.setLayoutManager(linearLayoutManager);
        categoryItems.setAdapter(categoryItemsAdapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(CategoryItems.this, MainActivity.class));
    }
}