package com.yuvi.assingmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class  CategoriesData (
        @SerializedName("id") val _id : Int,
        @SerializedName("name") val name : String
)

