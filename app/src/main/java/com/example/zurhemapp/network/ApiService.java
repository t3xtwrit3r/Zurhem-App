package com.example.zurhemapp.network;


import com.example.zurhemapp.responses.CategoryItemResponse;
import com.example.zurhemapp.responses.FeatureProductsResponse;
import com.example.zurhemapp.responses.ProductDetailsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("feature_product")
    Call<FeatureProductsResponse> getFeatureProduct(@Query("page") int page);

    @GET("category/product/{slug}")
    Call<CategoryItemResponse> getCategoryItems(@Path("slug") String slug, @Query("page") int page);

    @GET("product-detail/{id}")
    Call<ProductDetailsResponse> getProductDetails (@Path("id") int id);

}
