package com.yuvi.assingmentapp.view_model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yuvi.assingmentapp.model.CategoriesResponse
import com.yuvi.assingmentapp.model.ResturantByCategoryApiResponse
import com.yuvi.assingmentapp.retrofit.repository.RestaurantRepository

class ResturantByCategoryViewModel : ViewModel() {
    private var mutableLiveData: MutableLiveData<ResturantByCategoryApiResponse?>? = null


    fun initialize(lat: Double?, context: Context?, lon:Double?, cat_id: String) {
        if (mutableLiveData != null) {
            return
        }
        val newsRepository = RestaurantRepository(context)
        mutableLiveData = newsRepository.getResturantByCategory(lat,lon,cat_id)
    }


    fun getCategoriesList(): LiveData<ResturantByCategoryApiResponse?>? {
        return mutableLiveData
    }
}