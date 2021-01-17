package com.yuvi.assingmentapp.model

import com.google.gson.annotations.SerializedName

data class R (

		@SerializedName("res_id") val res_id : String,
		@SerializedName("is_grocery_store") val is_grocery_store : String,
		@SerializedName("has_menu_status") val has_menu_status : Has_menu_status
)