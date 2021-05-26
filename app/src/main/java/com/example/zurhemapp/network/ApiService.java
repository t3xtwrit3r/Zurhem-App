package com.example.zurhemapp.network;


import com.example.zurhemapp.responses.CategoryItemResponse;
import com.example.zurhemapp.responses.FeatureProductsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("feature_product")
    Call<FeatureProductsResponse> getFeatureProduct(@Query("page") int page);

    @GET("category/product/men")
    Call<CategoryItemResponse> getCategoryItems(@Query("page") int page);



}
