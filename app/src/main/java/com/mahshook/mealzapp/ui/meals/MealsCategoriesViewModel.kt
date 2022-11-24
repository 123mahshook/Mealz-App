package com.mahshook.mealzapp.ui.meals

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahshook.model.MealsRepository
import com.mahshook.model.response.MealsResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository= MealsRepository()):ViewModel() {
    //private val mealsJob= Job()
    init {
//val scope= CoroutineScope(mealsJob+Dispatchers.IO)
       // scope.launch() {
        Log.d("TAG_COROUTINES","we are about to launch a coroutine")
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("TAG_COROUTINES","we have launched the coroutine")
            val meals=getMeals()
            Log.d("TAG_COROUTINES","we have received the async data")
            mealsState.value=meals
        }
        Log.d("TAG_COROUTINES","other work")
    }
    val mealsState: MutableState<List<MealsResponse>> =
        mutableStateOf(emptyList<MealsResponse>())

/*    override fun onCleared() {
        super.onCleared()
        mealsJob.cancel()
    }*/

    private suspend fun getMeals():List<MealsResponse>{
        return  repository.getMeals().categories
    }
}