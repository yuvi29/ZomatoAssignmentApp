package com.yuvi.assingmentapp.model

import com.google.gson.annotations.SerializedName

data class Reviews (

	@SerializedName("review") val review : List<String>
)