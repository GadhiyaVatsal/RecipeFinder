package com.plangrid.skeleton.data.remote

import com.fasterxml.jackson.annotation.JsonProperty

data class RecipeDto(
    @JsonProperty("meals")
    val meals: List<RecipeDataDto>
)
