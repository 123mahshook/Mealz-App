package com.mahshook.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.mahshook.model.MealsRepository
import com.mahshook.model.response.MealsResponse

class MealsCategoriesViewModel(private val repository: MealsRepository= MealsRepository()):ViewModel() {
    suspend fun getMeals():List<MealsResponse>{
        return  repository.getMeals().categories
    }
}