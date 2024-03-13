package ua.edu.lntu.cw3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.lntu.cw3.ui.theme.IPZ32CW3_Kits_IvanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ32CW3_Kits_IvanTheme {
                RecipeApp()
            }
        }
    }
}

@Composable
fun RecipeApp() {
    Surface(color = Color.Yellow) {
        LazyColumn {
            items(recipeList) { recipe ->
                RecipeItem(recipe = recipe)
            }
        }
    }
}

@Composable
fun RecipeItem(recipe: Recipe) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = recipe.imageResId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clickable { expanded = !expanded },
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = recipe.name,
            modifier = Modifier.padding(horizontal = 120.dp)
        )

        if (expanded) {
            Text(
                text = recipe.description,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

data class Recipe(val name: String, val description: String, val imageResId: Int)

val recipeList = listOf(
    Recipe("Recipe 1", "Description for recipe 1", R.drawable.study),
    Recipe("Recipe 2", "Description for recipe 2", R.drawable.study),
    Recipe("Recipe 3", "Description for recipe 3", R.drawable.study),
    Recipe("Recipe 4", "Description for recipe 4", R.drawable.study),
    Recipe("Recipe 5", "Description for recipe 5", R.drawable.study),
    Recipe("Recipe 6", "Description for recipe 6", R.drawable.study),
    Recipe("Recipe 7", "Description for recipe 7", R.drawable.study),
    Recipe("Recipe 8", "Description for recipe 8", R.drawable.study),
    Recipe("Recipe 9", "Description for recipe 9", R.drawable.study),
    Recipe("Recipe 10", "Description for recipe 10", R.drawable.study)
)

@Preview(showBackground = true)
@Composable
fun PreviewRecipeApp() {
    IPZ32CW3_Kits_IvanTheme {
        RecipeApp()
    }
}
