package com.example.zurhemapp.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.zurhemapp.network.ApiClient;
import com.example.zurhemapp.network.ApiService;
import com.example.zurhemapp.responses.ProductDetailsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsRepository {

    private ApiService apiService;

    public ProductDetailsRepository(){
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<ProductDetailsResponse> getProductDetails(int id){
        MutableLiveData<ProductDetailsResponse> data = new MutableLiveData<>();
        apiService.getProductDetails(id).enqueue(new Callback<ProductDetailsResponse>() {
            @Override
            public void onResponse(@NonNull Call<ProductDetailsResponse> call, @NonNull Response<ProductDetailsResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ProductDetailsResponse> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

}
