package com.plangrid.skeleton.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {

    @GET("/api/json/v1/1/random.php")
    suspend fun getRandomRecipe(): RecipeDto

    @GET("/api/json/v1/1/search.php?")
    suspend fun getSearchedRecipe(
        @Query("s") search: String
    ): RecipeDto
}