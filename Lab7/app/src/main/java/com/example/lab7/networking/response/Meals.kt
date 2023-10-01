package com.example.lab7.networking.response

import com.google.gson.annotations.SerializedName

data class MealsResponse(val meals: List<Meals>)

data class Meals(
    @SerializedName("idMeal") val id: String,
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val imageUrl: String
)