package com.mahshook.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.mahshook.model.MealsRepository
import com.mahshook.model.response.MealsCategoriesResponse
import com.mahshook.model.response.MealsResponse

class MealsCategoriesViewModel(private val repository: MealsRepository= MealsRepository()):ViewModel() {
    fun getMeals(successCallback:(response:MealsCategoriesResponse?)->Unit){
         repository.getMeals{
           response->
           successCallback(response)
       }
    }
}