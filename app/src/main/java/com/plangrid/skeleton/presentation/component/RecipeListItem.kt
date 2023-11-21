package com.plangrid.skeleton.presentation.component

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.plangrid.skeleton.domain.recipe.RecipeData

@Composable
fun RecipeListItem(
    recipes: List<RecipeData>,
    modifier: Modifier = Modifier
) {
    var expanded: Boolean by remember {
        mutableStateOf(false)
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(recipes) { meal ->
            Log.d("RecipeData", "RecipeListItem: $meal")
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(4.dp),
                border = BorderStroke(1.dp, Color.LightGray),
                contentColor = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    if (!meal.strMealThumb.isNullOrEmpty()) {
                        AsyncImage(
                            model = meal.strMealThumb,
                            contentDescription = "Thumbnail",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .clip(
                                    RoundedCornerShape(8.dp)
                                )
                        )
                    }
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(
                        text = meal.strMeal ?: "",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Ingredients",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(text = getIngredients(meal))
                    Spacer(modifier = Modifier.padding(8.dp))
                    AnimatedVisibility(visible = expanded) {
                        Column {
                            Text(
                                text = "Instructions",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = meal.strInstructions ?: ""
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                expanded = !expanded
                            }
                    ) {
                        Icon(
                            imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = "Clear",
                            tint = Color.Black,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }

                }
            }
        }
    }
}

fun getIngredients(meal: RecipeData): String {
    var ingredients = ""

    with(meal) {
        if (!strIngredient1.isNullOrEmpty()) ingredients += "$strIngredient1 - $strMeasure1\n"
        if (!strIngredient2.isNullOrEmpty()) ingredients += "$strIngredient2 - $strMeasure2\n"
        if (!strIngredient3.isNullOrEmpty()) ingredients += "$strIngredient3 - $strMeasure3\n"
        if (!strIngredient4.isNullOrEmpty()) ingredients += "$strIngredient4 - $strMeasure4\n"
        if (!strIngredient5.isNullOrEmpty()) ingredients += "$strIngredient5 - $strMeasure5\n"
        if (!strIngredient6.isNullOrEmpty()) ingredients += "$strIngredient6 - $strMeasure6\n"
        if (!strIngredient7.isNullOrEmpty()) ingredients += "$strIngredient7 - $strMeasure7\n"
        if (!strIngredient8.isNullOrEmpty()) ingredients += "$strIngredient8 - $strMeasure8\n"
        if (!strIngredient9.isNullOrEmpty()) ingredients += "$strIngredient9 - $strMeasure9\n"
        if (!strIngredient10.isNullOrEmpty()) ingredients += "$strIngredient10 - $strMeasure10\n"
        if (!strIngredient11.isNullOrEmpty()) ingredients += "$strIngredient11 - $strMeasure11\n"
        if (!strIngredient12.isNullOrEmpty()) ingredients += "$strIngredient12 - $strMeasure12\n"
        if (!strIngredient13.isNullOrEmpty()) ingredients += "$strIngredient13 - $strMeasure13\n"
        if (!strIngredient14.isNullOrEmpty()) ingredients += "$strIngredient14 - $strMeasure14\n"
        if (!strIngredient15.isNullOrEmpty()) ingredients += "$strIngredient15 - $strMeasure15\n"
        if (!strIngredient16.isNullOrEmpty()) ingredients += "$strIngredient16 - $strMeasure16\n"
        if (!strIngredient17.isNullOrEmpty()) ingredients += "$strIngredient17 - $strMeasure17\n"
        if (!strIngredient18.isNullOrEmpty()) ingredients += "$strIngredient18 - $strMeasure18\n"
        if (!strIngredient19.isNullOrEmpty()) ingredients += "$strIngredient19 - $strMeasure19\n"
        if (!strIngredient20.isNullOrEmpty()) ingredients += "$strIngredient20 - $strMeasure20\n"
    }
    return ingredients.trimEnd('\n')
}

@Preview
@Composable
fun RecipeListItemPreview() {
    RecipeListItem(
        recipes = listOf(
            RecipeData(
                idMeal = "52786",
                strArea = "American",
                strCategory = "Dessert",
                strIngredient1 = "Miniature Marshmallows",
                strIngredient2 = "Chocolate Chips",
                strIngredient3 = "Peanut Butter",
                strIngredient4 = "Vanilla Extract",
                strIngredient5 = "Peanuts",
                strInstructions = """Line an 8-inch-square baking pan with wax paper or foil, and coat with non-stick spray.
                Pour ½ cup of the miniature marshmallows into the bottom of the lined baking dish.
                In a microwave-safe bowl, combine the chocolate chips and peanut butter. Microwave the chocolate mixture in 20-second intervals, stirring in between each interval, until the chocolate is melted.
        Add the vanilla extract and stir well, until smooth.
                Reserve 2 tablespoons of the chopped almonds or peanuts, and set aside.
        Fold 1 ½ cups of the miniature marshmallows and the remaining chopped nuts into the chocolate mixture.
        Transfer the chocolate mixture into the prepared pan and spread into an even layer. Immediately top with the reserved chopped nuts and the mallow bits or additional miniature marshmallows, if using.
        Refrigerate for 4 hours, or until set.
        Remove the fudge and wax paper from the pan. Carefully peel all of wax paper from the fudge.
        Cut the fudge into bite-sized pieces and serve.""",
                strMeal = "Rocky Road Fudge",
                strMealThumb = "https://www.themealdb.com/images/media/meals/vtxyxv1483567157.jpg",
                strMeasure1 = "2 cups",
                strSource = "http://tiphero.com/rocky-road-fudge/, strTags=Chocolate,Snack,Sweet,Baking",
                strYoutube = "https://www.youtube.com/watch?v=N1aJ3nEYXyg",
                dateModified = null,
                strCreativeCommonsConfirmed = null,
                strDrinkAlternate = null,
                strImageSource = null,
                strIngredient6 = null,
                strIngredient7 = null,
                strIngredient8 = null,
                strIngredient9 = null,
                strIngredient10 = null,
                strIngredient11 = null,
                strIngredient12 = null,
                strIngredient13 = null,
                strIngredient14 = null,
                strIngredient15 = null,
                strIngredient16 = null,
                strIngredient17 = null,
                strIngredient18 = null,
                strIngredient19 = null,
                strIngredient20 = null,
                strMeasure2 = null,
                strMeasure3 = null,
                strMeasure4 = null,
                strMeasure5 = null,
                strMeasure6 = null,
                strMeasure7 = null,
                strMeasure8 = null,
                strMeasure9 = null,
                strMeasure10 = null,
                strMeasure11 = null,
                strMeasure12 = null,
                strMeasure13 = null,
                strMeasure14 = null,
                strMeasure15 = null,
                strMeasure16 = null,
                strMeasure17 = null,
                strMeasure18 = null,
                strMeasure19 = null,
                strMeasure20 = null,
                strTags = null
            )
        )
    )
}
