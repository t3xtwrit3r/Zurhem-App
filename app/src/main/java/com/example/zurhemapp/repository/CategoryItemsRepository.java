package com.example.zurhemapp.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.zurhemapp.network.ApiClient;
import com.example.zurhemapp.network.ApiService;
import com.example.zurhemapp.responses.CategoryItemResponse;
import com.example.zurhemapp.responses.FeatureProductsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryItemsRepository {

    private ApiService apiService;

    public CategoryItemsRepository(){
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<CategoryItemResponse> getCategoryItems(String slug, int page){
        MutableLiveData<CategoryItemResponse> data = new MutableLiveData<>();
        apiService.getCategoryItems(slug, page).enqueue(new Callback<CategoryItemResponse>() {
            @Override
            public void onResponse(@NonNull Call<CategoryItemResponse> call, @NonNull Response<CategoryItemResponse> response) {
                data.setValue(response.body());
            }
            @Override
            public void onFailure(@NonNull Call<CategoryItemResponse> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }



}
