package com.plangrid.skeleton.presentation.videmodel

import com.plangrid.skeleton.domain.recipe.RecipeData

data class RecipeState(
    val recipeData: List<RecipeData>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)