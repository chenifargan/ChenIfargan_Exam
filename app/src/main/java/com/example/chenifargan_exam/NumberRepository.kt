package com.example.chenifargan_exam

import android.util.Log

class NumberRepository(private val apiService: ApiService) {
    suspend fun getSortedNumbers():List<Numbers>{
        val response =apiService.getAllData()
        if(response.isSuccessful){
            val numberResponse = response.body()
            val numbers = numberResponse?.numbers?: emptyList()
            return numbers.sortedBy { it.number }
        }
        else{
            Log.d("chen","Failed to fetch numbers")
        }
        return emptyList()
    }

}