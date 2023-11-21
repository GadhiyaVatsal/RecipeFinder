package com.plangrid.skeleton.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.plangrid.skeleton.presentation.component.ErrorComponent
import com.plangrid.skeleton.presentation.component.LoadingComponent
import com.plangrid.skeleton.presentation.component.SuccessComponent
import com.plangrid.skeleton.presentation.ui.theme.RecipeAppTheme
import com.plangrid.skeleton.presentation.videmodel.RecipeState
import com.plangrid.skeleton.presentation.videmodel.RecipeViewIntent
import com.plangrid.skeleton.presentation.videmodel.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeActivity : ComponentActivity() {

    private val viewModel: RecipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RecipeAppTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    if (viewModel.state.isLoading) LoadingComponent()
                    viewModel.state.recipeData?.let {
                        SuccessComponent(recipes = it, onSearchClicked = {query ->
                            viewModel.processIntent(RecipeViewIntent.SearchRecipes(query))
                        })
                    }

                    viewModel.state.error?.let {msg ->
                        ErrorComponent(message = msg, onRefreshClicked = {
                            viewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
                        })
                    }

                    LaunchedEffect(Unit) {
                        viewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
                    }
                }
            }
        }
    }
}