package com.plangrid.skeleton.data.repository

import com.plangrid.skeleton.data.remote.RecipeApi
import com.plangrid.skeleton.data.wrapper.toRecipeDataDtoMap
import com.plangrid.skeleton.domain.recipe.RecipeData
import com.plangrid.skeleton.domain.recipe.repository.RecipeRepository
import com.plangrid.skeleton.domain.util.Resource
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val api: RecipeApi
) : RecipeRepository {

    override suspend fun getRandomRecipe(): Resource<List<RecipeData>> {
        return try {
            Resource.Success(data = api.getRandomRecipe().toRecipeDataDtoMap())
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

    override suspend fun getSearchedRecipe(search: String): Resource<List<RecipeData>> {
        return try {
            Resource.Success(data = api.getSearchedRecipe(search).toRecipeDataDtoMap())
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

}