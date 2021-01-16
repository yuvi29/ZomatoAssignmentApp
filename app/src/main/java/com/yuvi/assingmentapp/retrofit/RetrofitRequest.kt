package com.yuvi.assingmentapp.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRequest {


    companion object {

        private var retrofit: Retrofit? = null

        @kotlin.jvm.JvmStatic
        fun  getRetrofitInstance(): Retrofit? {
            val httpClient = OkHttpClient.Builder()
            val logging = HttpLoggingInterceptor()

            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            httpClient.addNetworkInterceptor(logging)

            if(retrofit == null)
            {

                retrofit = retrofit2.Retrofit.Builder()
                        .baseUrl("https://developers.zomato.com/")
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit

        }
    }







    }

