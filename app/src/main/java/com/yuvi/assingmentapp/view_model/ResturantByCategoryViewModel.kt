package com.yuvi.assingmentapp.view_model

import ResturantByCategoryApiResponse
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yuvi.assingmentapp.model.CategoriesResponse
import com.yuvi.assingmentapp.model.ResturantByCategoryApiResponse
import com.yuvi.assingmentapp.retrofit.repository.RestaurantRepository

class ResturantByCategoryViewModel {
    private var mutableLiveData: MutableLiveData<ResturantByCategoryApiResponse?>? = null


    fun initialize(lat: Double?, context: Context?, lon:Double, cat_id: String) {
        if (mutableLiveData != null) {
            return
        }
        val newsRepository = RestaurantRepository(context)
        mutableLiveData = newsRepository.resturantByCategory
    }


    fun getCategoriesList(): LiveData<ResturantByCategoryApiResponse?>? {
        return mutableLiveData
    }
}