package com.yuvi.assingmentapp.model

import All_reviews
import User_rating
import com.google.gson.annotations.SerializedName

data class Restaurant (

		@SerializedName("R") val r : R,
		@SerializedName("apikey") val apiapikey : String,
		@SerializedName("id") val id : Int,
		@SerializedName("name") val name : String,
		@SerializedName("url") val url : String,
		@SerializedName("location") val location : Location,
		@SerializedName("switch_to_order_menu") val switch_to_order_menu : Int,
		@SerializedName("cuisines") val cuisines : String,
		@SerializedName("timings") val timings : String,
		@SerializedName("average_cost_for_two") val average_cost_for_two : Int,
		@SerializedName("price_range") val price_range : Int,
		@SerializedName("currency") val currency : String,
		@SerializedName("highlights") val highlights : List<String>,
		@SerializedName("offers") val offers : List<String>,
		@SerializedName("opentable_support") val opentable_support : Int,
		@SerializedName("is_zomato_book_res") val is_zomato_book_res : Int,
		@SerializedName("mezzo_provider") val mezzo_provider : String,
		@SerializedName("is_book_form_web_view") val is_book_form_web_view : Int,
		@SerializedName("book_form_web_view_url") val book_form_web_view_url : String,
		@SerializedName("book_again_url") val book_again_url : String,
		@SerializedName("thumb") val thumb : String,
		@SerializedName("user_rating") val user_rating : User_rating,
		@SerializedName("all_reviews_count") val all_reviews_count : Int,
		@SerializedName("photos_url") val photos_url : String,
		@SerializedName("photo_count") val photo_count : Int,
		@SerializedName("menu_url") val menu_url : String,
		@SerializedName("featured_image") val featured_image : String,
		@SerializedName("medio_provider") val medio_provider : Boolean,
		@SerializedName("has_online_delivery") val has_online_delivery : Int,
		@SerializedName("is_delivering_now") val is_delivering_now : Int,
		@SerializedName("store_type") val store_type : String,
		@SerializedName("include_bogo_offers") val include_bogo_offers : Boolean,
		@SerializedName("deeplink") val deeplink : String,
		@SerializedName("order_url") val order_url : String,
		@SerializedName("order_deeplink") val order_deeplink : String,
		@SerializedName("is_table_reservation_supported") val is_table_reservation_supported : Int,
		@SerializedName("has_table_booking") val has_table_booking : Int,
		@SerializedName("events_url") val events_url : String,
		@SerializedName("phone_numbers") val phone_numbers : String,
		@SerializedName("all_reviews") val all_reviews : All_reviews,
		@SerializedName("establishment") val establishment : List<String>,
		@SerializedName("establishment_types") val establishment_types : List<String>
)