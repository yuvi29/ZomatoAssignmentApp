package com.yuvi.assingmentapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.yuvi.assingmentapp.R
import com.yuvi.assingmentapp.ResturantByCategoryActivity
import com.yuvi.assingmentapp.model.CategoriesList
import com.yuvi.assingmentapp.model.CategoriesResponse




internal class CategoryAdapter(var mcontext : Context, private var categoryList: List<CategoriesList>) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.category_name)
        var category_id: TextView = view.findViewById(R.id.category_id)
        var imageView: ImageView = view.findViewById(R.id.image)

    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val category = categoryList[position]
        holder.title.text =categoryList[position].categories.name
        holder.category_id.text = categoryList[position].categories._id.toString()
        holder.imageView.setOnClickListener {
            val intent = Intent(mcontext, ResturantByCategoryActivity::class.java)
            intent.putExtra("categoryId",holder.category_id.text.toString())
            mcontext.startActivity(intent)
        }

    }
    override fun getItemCount(): Int {
        return categoryList.size
    }
}
