package com.example.myapp_retrofit_meal.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapp_retrofit_meal.Model.MealModel
import com.example.myapp_retrofit_meal.Repositories.MainRepo

class MainActivityViewModel: ViewModel(){
    private  val mainRepo: MainRepo.MainRepo

    val getMealList: LiveData<MealModel>
        get() = mainRepo.getMealModelLiveData
    init {
        mainRepo=MainRepo.MainRepo()
    }
}