package com.example.lab7.ui.categories.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lab7.networking.response.MealsCategoriesResponse
import com.example.lab7.ui.categories.repository.MealsCategoriesRepository

class MealsCategoriesViewModel (private val repository: MealsCategoriesRepository = MealsCategoriesRepository()): ViewModel() {
    fun getCategories(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        repository.getMealsC { response ->
            successCallback(response)
        }
    }
}