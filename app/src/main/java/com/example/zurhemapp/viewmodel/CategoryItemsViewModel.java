package com.example.zurhemapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.zurhemapp.repository.CategoryItemsRepository;
import com.example.zurhemapp.responses.CategoryItemResponse;

public class CategoryItemsViewModel extends ViewModel {

    private CategoryItemsRepository categoryItemsRepository;

    public CategoryItemsViewModel(){
        categoryItemsRepository = new CategoryItemsRepository();
    }

    public LiveData<CategoryItemResponse> getCategoryItems(String slug, int page){
        return categoryItemsRepository.getCategoryItems(slug, page);
    }

}
