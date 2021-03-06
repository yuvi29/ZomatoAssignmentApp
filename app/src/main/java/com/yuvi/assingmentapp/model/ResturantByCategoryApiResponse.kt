package com.yuvi.assingmentapp.model

import com.google.gson.annotations.SerializedName

data class ResturantByCategoryApiResponse (

		@SerializedName("results_found") val results_found : String,
		@SerializedName("results_start") val results_start : String,
		@SerializedName("results_shown") val results_shown : String,
		@SerializedName("restaurants") val restaurants : List<Restaurants>
)