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
    Surface(color = MaterialTheme.colorScheme.background) {
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
    val rotationDegrees by remember { mutableStateOf(Animatable(initialValue = 0f)) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = recipe.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .graphicsLayer(rotationZ = rotationDegrees.value),
                contentScale = ContentScale.Crop
            )
            Text(
                text = recipe.name,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        if (expanded) {
            Text(
                text = recipe.description,
                modifier = Modifier.padding(start = 80.dp)
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded }
            .padding(horizontal = 16.dp)
    ) {
        LaunchedEffect(expanded) {
            rotationDegrees.animateTo(
                targetValue = if (expanded) 180f else 0f,
                animationSpec = tween(durationMillis = 300)
            )
        }
    }
}

data class Recipe(val name: String, val description: String, val imageResId: Int)

val recipeList = listOf(
    Recipe("Recipe 1", "Description for recipe 1", R.drawable.recipe1),

)

@Preview(showBackground = true)
@Composable
fun PreviewRecipeApp() {
    IPZ32CW3_Kits_IvanTheme {
        RecipeApp()
    }
}
