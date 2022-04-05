package com.example.myapp_retrofit_meal.Network

import com.example.myapp_retrofit_meal.Model.MealModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("/api/json/v1/1/search.php?f=b")
    fun getMovieList(): Call<MealModel>
}