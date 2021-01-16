package com.yuvi.assingmentapp.retrofit.repository

import com.yuvi.assingmentapp.model.CategoriesResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.Call


interface ApiRequest {

    @Headers("user_key: 327e75c31ca03dbb55cbabe4257acfa9")
    @GET("api/v2.1/categories")
    fun getCategories():Call<CategoriesResponse>
}