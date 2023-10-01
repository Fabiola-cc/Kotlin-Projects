package com.example.lab7.networking

import com.example.lab7.networking.response.MealsCategoriesResponse
import com.example.lab7.networking.response.MealsDetailsResponse
import com.example.lab7.networking.response.MealsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {
    @GET("categories.php")
    fun getMealsCategories(): Call<MealsCategoriesResponse>
    @GET("lookup.php") //?i=52945
    fun getMealsDetail(@Query("i") idMeal: String): Call<MealsDetailsResponse>
    @GET("filter.php") //?c=seafood
    fun getMeals(@Query("c") categoryID: String): Call<MealsResponse>

}