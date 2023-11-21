package com.plangrid.skeleton.presentation.videmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plangrid.skeleton.domain.recipe.repository.RecipeRepository
import com.plangrid.skeleton.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {

    var state by mutableStateOf(RecipeState())
        private set

    fun processIntent(intent: RecipeViewIntent) {
        when (intent) {
            is RecipeViewIntent.LoadRandomRecipe -> loadRandomRecipe()
            is RecipeViewIntent.SearchRecipes -> searchRecipe(intent.query)
        }
    }

    private fun loadRandomRecipe() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            when (val result = repository.getRandomRecipe()) {
                is Resource.Success -> {
                    state = state.copy(
                        recipeData = result.data,
                        isLoading = false,
                        error = null
                    )
                }

                is Resource.Error -> {
                    state = state.copy(
                        recipeData = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }

    private fun searchRecipe(query: String) {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            when (val result = repository.getSearchedRecipe(query)) {
                is Resource.Success -> {
                    state = state.copy(
                        recipeData = result.data,
                        isLoading = false,
                        error = null
                    )
                }

                is Resource.Error -> {
                    state = state.copy(
                        recipeData = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}