package com.example.zurhemapp.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.zurhemapp.network.ApiClient;
import com.example.zurhemapp.network.ApiService;
import com.example.zurhemapp.responses.FeatureProductsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeatureProductRepository {

    private ApiService apiService;

    public FeatureProductRepository(){
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<FeatureProductsResponse> getFeatureProduct(int page){
        MutableLiveData<FeatureProductsResponse> data = new MutableLiveData<>();
        apiService.getFeatureProduct(page).enqueue(new Callback<FeatureProductsResponse>() {
            @Override
            public void onResponse(@NonNull Call<FeatureProductsResponse> call, @NonNull Response<FeatureProductsResponse> response) {
                data.setValue(response.body());
            }
            @Override
            public void onFailure(@NonNull Call<FeatureProductsResponse> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }


}
