package com.example.chenifargan_exam

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/raw/8wJzytQX")
    suspend fun getAllData():Response<NumberResponse>
}