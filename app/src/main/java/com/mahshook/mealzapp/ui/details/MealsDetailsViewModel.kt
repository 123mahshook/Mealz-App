package com.mahshook.mealzapp.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mahshook.model.MealsRepository
import com.mahshook.model.response.MealsResponse

class MealsDetailsViewModel (
    private val savedStateHandle:SavedStateHandle,

    ):ViewModel(){
    private val repository: MealsRepository = MealsRepository.getInstance()
    var mealState= mutableStateOf<MealsResponse?>(null)

    init {
        val mealId=savedStateHandle.get<String>("meal_category_id")?:""
        mealState.value=repository.getMeal(mealId)
    }
}