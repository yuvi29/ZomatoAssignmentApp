package com.yuvi.assingmentapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yuvi.assingmentapp.R
import com.yuvi.assingmentapp.ResturantByCategoryActivity
import com.yuvi.assingmentapp.model.CategoriesList
import com.yuvi.assingmentapp.model.Restaurants


internal class RestaurantAdapter(var mcontext : Context, private var restaurantList: List<Restaurants>) :
    RecyclerView.Adapter<RestaurantAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.category_name)
        var rest_id: TextView = view.findViewById(R.id.category_id)
        var imageView: ImageView = view.findViewById(R.id.image)

    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restuarant, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val restaurant = restaurantList[position]
        holder.title.text = restaurant.restaurant.name
        holder.rest_id.text = restaurant.restaurant.id

        if (restaurant.restaurant.featured_image !== null) {
            Glide.with(mcontext)
                .load(restaurant.restaurant.featured_image)
                .into( holder.imageView)
        }
        else
        {

        }

        holder.imageView.setOnClickListener {
//            val intent = Intent(mcontext, ResturantByCategoryActivity::class.java)
//            intent.putExtra("categoryId",)
//            mcontext.startActivity(intent)
        }

    }
    override fun getItemCount(): Int {
        return restaurantList.size
    }
}