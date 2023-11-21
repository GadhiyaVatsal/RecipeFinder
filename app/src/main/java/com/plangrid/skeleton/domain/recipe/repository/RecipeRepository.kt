package com.plangrid.skeleton.domain.recipe.repository

import com.plangrid.skeleton.domain.recipe.RecipeData
import com.plangrid.skeleton.domain.util.Resource

interface RecipeRepository {

    suspend fun getRandomRecipe(): Resource<List<RecipeData>>

    suspend fun  getSearchedRecipe(search: String): Resource<List<RecipeData>>
}