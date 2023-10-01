package com.example.lab7.ui.meals.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lab7.networking.response.MealsResponse
import com.example.lab7.ui.meals.repository.MealsRepository

class MealViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getMeals(categoryID: String, successCallback: (response: MealsResponse?) -> Unit) {
        repository.getMeals(categoryID) { response ->
            successCallback(response)
        }
    }
}