package com.yuvi.assingmentapp.views

import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.yuvi.assingmentapp.R

import com.yuvi.assingmentapp.model.CategoriesList
import com.yuvi.assingmentapp.model.CategoriesResponse
import com.yuvi.assingmentapp.view_model.CategoriesListViewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    private val CategoryDataList: ArrayList<CategoriesList> = ArrayList<CategoriesList>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchCategory ()
    }

    fun fetchCategory ()
    {

        val newsViewModel: CategoriesListViewModel = ViewModelProviders.of(this).get(CategoriesListViewModel::class.java)

        newsViewModel.newsId("1",this@MainActivity)
        newsViewModel.getCategoriesList().observe(this, androidx.lifecycle.Observer {
            if (it!=null)
            {
                Log.e("Check" , it.categorieslist[0].categories.name)

                val categoryList: List<CategoriesList> = it.categorieslist
                Log.e("Checked" , it.categorieslist[0].categories.name)

                CategoryDataList.addAll(categoryList)
            }else
            {
                Log.i("Status" , "Failed")
            }
        } )



    }

}