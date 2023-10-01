package com.example.lab7.ui.mealdetail.repository

import com.example.lab7.networking.MealsWebService
import com.example.lab7.networking.response.MealsDetailsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsDetailsRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMealsD(idMeal: String, successCallback: (response: MealsDetailsResponse?) -> Unit) {
        return webService.getMealsDetail(idMeal).enqueue(object : Callback<MealsDetailsResponse> {
            override fun onResponse(
                call: Call<MealsDetailsResponse>,
                response: Response<MealsDetailsResponse>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<MealsDetailsResponse>, t: Throwable) {
                // TODO treat failure
            }
        })
    }
}