package com.example.lab7.networking.response

import com.google.gson.annotations.SerializedName


data class MealsCategoriesResponse(val categories: List<MealCategories>)

data class MealCategories(
    @SerializedName("idCategory") val categoryID: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)