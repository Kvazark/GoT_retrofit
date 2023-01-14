package com.example.gameofthrones_retrofit.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Common {
    private val BASE_URL = "https://www.anapioficeandfire.com/api/"
    val retrofitService: RetrofitService
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
}
