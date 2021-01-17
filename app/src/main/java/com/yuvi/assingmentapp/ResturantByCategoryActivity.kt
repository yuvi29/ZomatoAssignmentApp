package com.yuvi.assingmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.yuvi.assingmentapp.constants.DataConstants
import com.yuvi.assingmentapp.model.CategoriesList
import com.yuvi.assingmentapp.view_model.CategoriesListViewModel
import com.yuvi.assingmentapp.view_model.ResturantByCategoryViewModel

class ResturantByCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchResturantByCategory()
    }

    fun fetchResturantByCategory ()
    {
        val categoryViewModel: ResturantByCategoryViewModel = ViewModelProviders.of(this).get(
            ResturantByCategoryViewModel::class.java)

        categoryViewModel.initialize(DataConstants.lat?.toDouble(),this,DataConstants.longti?.toDouble(),"1")
        categoryViewModel.getCategoriesList()?.observe(this, androidx.lifecycle.Observer {
            if (it!=null)
            {

              Log.e("Check" , "resturant===>   "+it.restaurants)

//                it.categorieslist.forEach {
//                    it.categories.name
//                    Log.e("CategoryList" , ""+it.categories.name)
//                }
//                Log.e("Check" , it.categorieslist[0].categories.name)
//
//                val categoryList: List<CategoriesList> = it.categorieslist
//                Log.e("Checked" , it.categorieslist[0].categories.name)

//                CategoryDataList.addAll(categoryList)
//
//                categoryAdapter.notifyDataSetChanged()
            }else
            {
                Log.i("Status" , "Failed")
            }
        } )



    }

}