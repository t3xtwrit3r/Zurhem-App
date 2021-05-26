package com.example.zurhemapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.zurhemapp.repository.FeatureProductRepository;
import com.example.zurhemapp.responses.FeatureProductsResponse;

public class ProductViewModel extends ViewModel {

    private FeatureProductRepository featureProductRepository;

    public ProductViewModel(){
        featureProductRepository = new FeatureProductRepository();
    }

    public LiveData<FeatureProductsResponse> getFeatureProduct(int page){
        return featureProductRepository.getFeatureProduct(page);
    }

}
