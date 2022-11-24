package com.mahshook.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mahshook.mealzapp.ui.meals.MealsCategoriesScreen
import com.mahshook.mealzapp.ui.theme.MealzAppTheme

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

