package com.yuvi.assingmentapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yuvi.assingmentapp.adapter.CategoryAdapter
import com.yuvi.assingmentapp.adapter.RestaurantAdapter
import com.yuvi.assingmentapp.constants.DataConstants
import com.yuvi.assingmentapp.model.CategoriesList
import com.yuvi.assingmentapp.model.Restaurants
import com.yuvi.assingmentapp.model.ResturantByCategoryApiResponse
import com.yuvi.assingmentapp.view_model.CategoriesListViewModel
import com.yuvi.assingmentapp.view_model.ResturantByCategoryViewModel
import com.yuvi.assingmentapp.views.MainActivity
import java.util.ArrayList

class ResturantByCategoryActivity : AppCompatActivity() {

    var catId: String? =null
    private val restaurantsDataList: ArrayList<Restaurants> = ArrayList<Restaurants>()
    private lateinit var restaurantAdapter: RestaurantAdapter
    private var mContext : Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)
        mContext = this@ResturantByCategoryActivity
        catId= intent.getStringExtra("categoryId")

  //      Toast.makeText(this,catId,Toast.LENGTH_LONG).show()


        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        restaurantAdapter = RestaurantAdapter(mContext as ResturantByCategoryActivity,restaurantsDataList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = restaurantAdapter

        fetchResturantByCategory()
    }

    fun fetchResturantByCategory ()
    {
        val resturantViewModel: ResturantByCategoryViewModel = ViewModelProviders.of(this).get(
            ResturantByCategoryViewModel::class.java)

        resturantViewModel.initialize(DataConstants.lat?.toDouble(),this,DataConstants.longti?.toDouble(),catId.toString())
        resturantViewModel.getCategoriesList()?.observe(this, androidx.lifecycle.Observer {
            if (it!=null)
            {

              Log.e("Check" , "resturant===>   "+it.restaurants[0].restaurant.id)

                it.restaurants.forEach {
                    it.restaurant.id

                }

if(it.restaurants.size !=0)
{
    val restList: List<Restaurants> = it.restaurants


    restaurantsDataList.addAll(restList)

    restaurantAdapter.notifyDataSetChanged()
}

            }else
            {
                Log.i("Status" , "Failed")
            }
        } )



    }

}