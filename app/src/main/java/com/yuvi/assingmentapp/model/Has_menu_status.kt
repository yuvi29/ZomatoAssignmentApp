package com.yuvi.assingmentapp.model

import com.google.gson.annotations.SerializedName

data class Has_menu_status (

		@SerializedName("delivery") val delivery : Boolean,
		@SerializedName("takeaway") val takeaway : Int
)