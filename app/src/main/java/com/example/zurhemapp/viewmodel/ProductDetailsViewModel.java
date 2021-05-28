package com.example.zurhemapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.zurhemapp.repository.ProductDetailsRepository;
import com.example.zurhemapp.responses.ProductDetailsResponse;

public class ProductDetailsViewModel extends ViewModel {

    private ProductDetailsRepository productDetailsRepository;

    public ProductDetailsViewModel(){
        productDetailsRepository = new ProductDetailsRepository();
    }

    public LiveData<ProductDetailsResponse> getProductDetails(int id){
        return productDetailsRepository.getProductDetails(id);
    }

}
