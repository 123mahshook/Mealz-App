package com.mahshook.mealzapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
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

@Composable
fun MealsCategoriesScreen() {
    //val viewModel=MealsCategoriesViewModel()
    val viewModel: MealsCategoriesViewModel= viewModel()
    Text(text = "Hello Compose")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealsCategoriesScreen()
    }
}