package com.example.lab7.ui.mealdetail.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lab7.networking.response.MealsDetailsResponse
import com.example.lab7.ui.mealdetail.repository.MealsDetailsRepository

class MealDetailsViewModel (private val repository: MealsDetailsRepository = MealsDetailsRepository()): ViewModel() {
    fun getDetails(idMeal:String, successCallback: (response: MealsDetailsResponse?) -> Unit) {
        repository.getMealsD(idMeal){ response ->
            successCallback(response)
        }
    }
}