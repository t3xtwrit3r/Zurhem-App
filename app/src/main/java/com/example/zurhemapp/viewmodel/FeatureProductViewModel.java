package com.example.zurhemapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.zurhemapp.repository.FeatureProductRepository;
import com.example.zurhemapp.responses.FeatureProductsResponse;

public class FeatureProductViewModel extends ViewModel {

    private FeatureProductRepository featureProductRepository;

    public FeatureProductViewModel(){
        featureProductRepository = new FeatureProductRepository();
    }

    public LiveData<FeatureProductsResponse> getFeatureProduct(int page){
        return featureProductRepository.getFeatureProduct(page);
    }

}
