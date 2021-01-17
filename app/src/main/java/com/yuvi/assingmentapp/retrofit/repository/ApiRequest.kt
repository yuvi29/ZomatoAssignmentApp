package com.yuvi.assingmentapp.retrofit.repository

import ResturantByCategoryApiResponse
import com.yuvi.assingmentapp.model.CategoriesResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.Call
import retrofit2.http.Query


interface ApiRequest {

    @Headers("user_key: 327e75c31ca03dbb55cbabe4257acfa9")
    @GET("api/v2.1/categories")
    fun getCategories():Call<CategoriesResponse>

    @Headers("user_key: 327e75c31ca03dbb55cbabe4257acfa9")
    @GET("api/v2.1/search")
    fun getResturantByCategory(
        @Query("lat") lat:Double,
        @Query("lon") lon:Double,
        @Query("category") category:String
    ):Call<ResturantByCategoryApiResponse>

    // 58882
    @Headers("user_key: 327e75c31ca03dbb55cbabe4257acfa9")
    @GET("api/v2.1/restaurant")
    fun getResturantDetail(
        @Query("res_id") lat:Double
    ):Call<CategoriesResponse>


}