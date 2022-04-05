package com.example.myapp_retrofit_meal.Repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.myapp_retrofit_meal.Model.MealModel
import com.example.myapp_retrofit_meal.Network.APIService
import com.example.myapp_retrofit_meal.common.Common
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepo {

    class MainRepo {
        private val apiService: APIService

        companion object{
            private const val TAG="MainRepo"
        }
        init {
            apiService= Common.getAPIService
        }
        val getMealModelLiveData: MutableLiveData<MealModel>
            get() {
                val data: MutableLiveData<MealModel> =
                    MutableLiveData<MealModel>()
                apiService.getMovieList().enqueue(object : Callback<MealModel> {
                    override fun onResponse(
                        call: Call<MealModel>,
                        response: Response<MealModel>
                    ) {
                        Log.e(TAG,"onResponse"+response.code())
                        if (response.isSuccessful){
                            data.value=response.body()
                        }
                        else{
                            data.value=null
                        }
                    }

                    override fun onFailure(call: Call<MealModel>, t: Throwable) {
                        Log.e(TAG,"onFailure onResponse"+t.message)
                    }

                })
                return data
            }
    }
}