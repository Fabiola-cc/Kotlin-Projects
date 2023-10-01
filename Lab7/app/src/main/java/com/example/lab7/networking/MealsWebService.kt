package com.example.lab7.networking

import android.util.Log
import com.example.lab7.networking.response.MealsCategoriesResponse
import com.example.lab7.networking.response.MealsDetailsResponse
import com.example.lab7.networking.response.MealsResponse
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory

class MealsWebService {

    private lateinit var api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    fun getMealsCategories(): Call<MealsCategoriesResponse> {
        return api.getMealsCategories()
    }

    fun getMealsDetail(idMeal:String): Call<MealsDetailsResponse> {
        return api.getMealsDetail(idMeal)
    }

    fun getMeals(categoryID: String): Call<MealsResponse> {
        return api.getMeals(categoryID)
    }
}