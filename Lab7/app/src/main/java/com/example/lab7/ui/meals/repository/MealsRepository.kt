package com.example.lab7.ui.meals.repository

import com.example.lab7.networking.MealsWebService
import com.example.lab7.networking.response.MealsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    fun getMeals(categoryID: String, successCallback: (response: MealsResponse?) -> Unit) {
        return webService.getMeals(categoryID).enqueue(object : Callback<MealsResponse> {
            override fun onResponse(
                call: Call<MealsResponse>,
                response: Response<MealsResponse>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<MealsResponse>, t: Throwable) {
                // TODO treat failure
            }
        })
    }
}