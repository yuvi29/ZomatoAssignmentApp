package com.yuvi.assingmentapp.view_model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yuvi.assingmentapp.model.CategoriesResponse;
import com.yuvi.assingmentapp.retrofit.repository.RestaurantRepository;


public class CategoriesListViewModel extends ViewModel {
    private MutableLiveData<CategoriesResponse> mutableLiveData;


    public void newsId(String sourceId, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        RestaurantRepository newsRepository = new RestaurantRepository(context);
        mutableLiveData = newsRepository.getCategoriessData();

    }


    public LiveData<CategoriesResponse> getCategoriesList() {
        return mutableLiveData;
    }
}
