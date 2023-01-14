package com.example.gameofthrones_retrofit.services

import com.example.gameofthrones_retrofit.models.Hero
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("characters")
    fun getHeroesList(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): Call<MutableList<Hero>>
}