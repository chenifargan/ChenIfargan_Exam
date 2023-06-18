package com.example.chenifargan_exam

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {
    private const val URL= "https://pastebin.com"
    private val retrofit :Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val numberApiService :ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}