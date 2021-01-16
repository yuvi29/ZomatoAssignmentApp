package com.yuvi.assingmentapp.model

import com.google.gson.annotations.SerializedName


class CategoriesResponse  (

@SerializedName("categories") val categorieslist : List<CategoriesList>
)