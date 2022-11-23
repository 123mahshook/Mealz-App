package com.mahshook.mealzapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mahshook.mealzapp.ui.theme.MealzAppTheme
import com.mahshook.model.response.MealsResponse

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // val viewModel by viewModels<MealsCategoriesViewModel>()
        setContent {
            MealzAppTheme {
                MealsCategoriesScreen()
           }
        }
    }
}

@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel= viewModel()
    val rememberedMeals:MutableState<List<MealsResponse>> = remember{
        mutableStateOf(emptyList<MealsResponse>())
    }
  viewModel.getMeals{
       response ->
      val mealsFromTheApi= response?.categories
      rememberedMeals.value=mealsFromTheApi.orEmpty()
   }
    LazyColumn{
        items(rememberedMeals.value){
            meals->
            Text(text = meals.name)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealsCategoriesScreen()
    }
}