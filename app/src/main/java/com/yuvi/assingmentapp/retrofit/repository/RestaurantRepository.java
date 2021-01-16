package com.yuvi.assingmentapp.retrofit.repository;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yuvi.assingmentapp.model.CategoriesResponse;
import com.yuvi.assingmentapp.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class RestaurantRepository{
    private static final String TAG = "CategoryRepository";
    private final ProgressDialog progressDoalog;
    private ApiRequest apiRequest;

    public RestaurantRepository(Context context) {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);

        progressDoalog = new ProgressDialog(context);
        progressDoalog.setMessage("Loading...");
        progressDoalog.show();
    }

    public MutableLiveData<CategoriesResponse> getCategoriessData() {
        MutableLiveData<CategoriesResponse> categoryData = new MutableLiveData<>();
        Log.d(TAG,"called");
        apiRequest.getCategories().enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                progressDoalog.dismiss();
                if (response.isSuccessful()) {
                    Log.d(TAG,"Res:"+response.message());
                    categoryData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {
                progressDoalog.dismiss();
                Log.d(TAG,"Res:"+t.getLocalizedMessage());
                categoryData.setValue(null);
            }
        });
        return categoryData;
    }
}
