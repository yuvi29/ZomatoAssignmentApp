package com.yuvi.assingmentapp.views

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.JobIntentService.enqueueWork
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yuvi.assingmentapp.R
import com.yuvi.assingmentapp.adapter.CategoryAdapter
import com.yuvi.assingmentapp.model.CategoriesList
import com.yuvi.assingmentapp.service.ZomatoIntentSerive
import com.yuvi.assingmentapp.view_model.CategoriesListViewModel
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var pendingIntent: PendingIntent
    private val CategoryDataList: ArrayList<CategoriesList> = ArrayList<CategoriesList>()
    private lateinit var categoryAdapter: CategoryAdapter
    private var mContext : Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = this@MainActivity




        val serviceIntent = Intent(this, ZomatoIntentSerive::class.java)
        serviceIntent.putExtra("data","Test Data")
        ZomatoIntentSerive.enqueueWork(this, serviceIntent)

        
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        categoryAdapter = CategoryAdapter(mContext as MainActivity,CategoryDataList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = categoryAdapter

//        Toast.makeText(this@MainActivity,DataConstants.lat,Toast.LENGTH_LONG).show()
//        Toast.makeText(this@MainActivity,DataConstants.longti,Toast.LENGTH_LONG).show()

        fetchCategory ()
    }

//    fun enqueueWork(v: View?) {
//
//        val serviceIntent = Intent(this, ZomatoIntentSerive::class.java)
//        serviceIntent.putExtra("data","Test Data")
//        ZomatoIntentSerive.enqueueWork(this, serviceIntent)
//
//    }

    fun fetchCategory ()
    {

        val categoryViewModel: CategoriesListViewModel = ViewModelProviders.of(this).get(CategoriesListViewModel::class.java)

        categoryViewModel.newsId("1",this@MainActivity)
        categoryViewModel.getCategoriesList().observe(this, androidx.lifecycle.Observer {
            if (it!=null)
            {

                it.categorieslist.forEach {
                    it.categories.name
                    Log.e("CategoryList" , ""+it.categories.name)
                }
                Log.e("Check" , it.categorieslist[0].categories.name)

                val categoryList: List<CategoriesList> = it.categorieslist
                Log.e("Checked" , it.categorieslist[0].categories.name)

                CategoryDataList.addAll(categoryList)

                categoryAdapter.notifyDataSetChanged()
            }else
            {
                Log.i("Status" , "Failed")
            }
        } )



    }

}