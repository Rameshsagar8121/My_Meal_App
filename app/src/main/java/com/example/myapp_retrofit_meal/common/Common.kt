package com.example.myapp_retrofit_meal.common

import com.example.myapp_retrofit_meal.Network.APIService
import com.example.myapp_retrofit_meal.Network.Retrofit


object Common {

    private const val BASE_URL="https://www.omdbapi.com/"
    val getAPIService: APIService
        get() = Retrofit.getRetrofitClient(BASE_URL).create(APIService::class.java)
}