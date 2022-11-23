package com.mahshook.model.api

import com.mahshook.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class MealsWebService {
    private  lateinit var api:MealsApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApiService::class.java)
    }
    suspend fun getMeals(): MealsCategoriesResponse{
            return api.getMeals()
    }

    interface MealsApiService{
        @GET("categories.php")
        suspend fun getMeals(): MealsCategoriesResponse
    }
}