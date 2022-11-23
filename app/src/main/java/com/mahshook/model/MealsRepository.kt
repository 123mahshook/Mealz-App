package com.mahshook.model

import com.mahshook.model.api.MealsWebService
import com.mahshook.model.response.MealsCategoriesResponse

class MealsRepository(private val  webService: MealsWebService=MealsWebService()) {

    fun getMeals(): MealsCategoriesResponse?{
        return webService.getMeals().execute().body()//bad practice

    }
}