package com.mahshook.mealzapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mahshook.mealzapp.ui.theme.MealzAppTheme
import com.mahshook.model.response.MealsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
    val coroutineScope=rememberCoroutineScope()
  LaunchedEffect(key1 = "GET_MEALS" )
  {
      coroutineScope.launch(Dispatchers.IO) {
          val meals=viewModel.getMeals()
          rememberedMeals.value=meals
      }
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