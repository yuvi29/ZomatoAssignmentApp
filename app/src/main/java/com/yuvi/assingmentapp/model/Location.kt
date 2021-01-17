package com.yuvi.assingmentapp.model

import com.google.gson.annotations.SerializedName

data class Location (

		@SerializedName("address") val address : String,
		@SerializedName("locality") val locality : String,
		@SerializedName("city") val city : String,
		@SerializedName("city_id") val city_id : Int,
		@SerializedName("latitude") val latitude : Double,
		@SerializedName("longitude") val longitude : Double,
		@SerializedName("zipcode") val zipcode : Int,
		@SerializedName("country_id") val country_id : Int,
		@SerializedName("locality_verbose") val locality_verbose : String
)