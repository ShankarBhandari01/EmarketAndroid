package com.example.emarketapplication.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val BASE_URL = "http://10.0.2.2:90"
    // private const val BASE_URL = "http://192.168.10.72:90/"
    //private const val BASE_URL = "http://localhost:90/"

    var token: String? = null
    private val okHttp = OkHttpClient.Builder()
    private val retroBuilder = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())


    // create retrofit instance
    private val retrofit = retroBuilder.build()
    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

    fun loadImagePath(): String {
        return BASE_URL
    }
}