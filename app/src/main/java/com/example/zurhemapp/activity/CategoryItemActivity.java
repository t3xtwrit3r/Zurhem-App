package com.example.zurhemapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.zurhemapp.adapter.CategoryItemsAdapter;
import com.example.zurhemapp.R;
import com.example.zurhemapp.model.Datum;
import com.example.zurhemapp.responses.CategoryItemResponse;
import com.example.zurhemapp.viewmodel.CategoryItemsViewModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryItemActivity extends AppCompatActivity {

    private RecyclerView categoryItems;
    private CategoryItemsAdapter categoryItemsAdapter;
    private List<Datum> categoryItemsList = new ArrayList<>();
    private CategoryItemsViewModel categoryItemsViewModel;
    private int currentPage = 1;
    private int totalAvailablePages = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_items);
        categoryItemsViewModel = ViewModelProviders.of(this).get(CategoryItemsViewModel.class);

        categoryItems = findViewById(R.id.categoryItems);

        categoryItemsAdapter = new CategoryItemsAdapter(CategoryItemActivity.this, categoryItemsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CategoryItemActivity.this, RecyclerView.VERTICAL, false);
        categoryItems.setLayoutManager(linearLayoutManager);
        categoryItems.setAdapter(categoryItemsAdapter);
        categoryItems.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!categoryItems.canScrollVertically(1)){
                    if (currentPage <= totalAvailablePages){
                        currentPage += 1;
                        getCategoryItems();
                    }
                }
            }
        });
        getCategoryItems();
    }

    public void getCategoryItems(){

        categoryItemsViewModel.getCategoryItems(getIntent().getStringExtra("slug"), currentPage).observe(this, CategoryItemResponse -> {
            if (CategoryItemResponse != null){
                totalAvailablePages = CategoryItemResponse.getMeta().getLastPage();
                if (CategoryItemResponse.getData() != null){
                    int OldCount = categoryItemsList.size();
                    categoryItemsList.addAll(CategoryItemResponse.getData());
                    categoryItemsAdapter.notifyItemRangeInserted(OldCount, categoryItemsList.size());
                }
            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(CategoryItemActivity.this, MainActivity.class));
    }
}