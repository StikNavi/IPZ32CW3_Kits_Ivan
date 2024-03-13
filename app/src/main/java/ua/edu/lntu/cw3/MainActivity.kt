package ua.edu.lntu.cw3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeApp() {
    Surface(color = Color.Yellow) {
        Column {
            TopAppBar(
                title = { Text("Легка вечеря – 8 рецептів, швидких і смачних") },
            )
            LazyColumn {
                items(recipeList) { recipe ->
                    RecipeItem(recipe = recipe)
                }
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
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        if (expanded) {
            Text(
                text = recipe.description,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

data class Recipe(val name: String, val description: String, val imageResId: Int)

val recipeList = listOf(
    Recipe("Печеня з тофу", "тофу – від 630 до 650 г;\n" +
            "брокколі – такий же обсяг;\n" +
            "по 2 столові ложки рослинної олії (використовуємо рафінована) і рисового оцту;\n" +
            "соєвий соус – вистачить 3-х великих ложок;\n" +
            "часник – достатньо 4-х зубков;\n" +
            "червоний перець – ¼ чайної ложки пластівців достатньо;\n" +
            "кешью – ½ склянки;\n" +
            "крохмаль з кукурудзи – не більше столової ложки.", R.drawable.study),

    Recipe("Куряче філе, тушковане з ананасами і стручкової квасолею", "курячих грудок – кіло вагою приблизно 200 г;\n" +
            "\n" +
            "консервованих ананасів – 600 г цілком вистачить;\n" +
            "твердого сиру (візьмемо «Російський», жирністю 50%) – 150 г;\n" +
            "цибулевих головок – 2-х штук;\n" +
            "зеленої стручкової квасолі – 130-150 г;\n" +
            "склянки сметани – не занадто жирної;\n" +
            "такого ж об’єму молока;\n" +
            "рафінованої олії – 6 великих ложок;\n" +
            "високосортної пшеничного борошна – їдальні ложки з високою «шапочкою»;\n" +
            "улюблених спецій і солі.", R.drawable.study),

    Recipe("Легка куряча грудка по-дижонски\n", "курячого філе – візьмемо 2 кг;\n" +
            "рослинної олії (якщо соняшникової, то рафінованої) – 3-х столових ложок;\n" +
            "такого ж обсягу діжонської гірчиці;\n" +
            "сухарів для панірування (можна приготувати і самим) – 200 г;\n" +
            "паприки – вистачить пари чайних ложок;\n" +
            "прованських трав (раз вже вибрали французьке блюдо, будемо послідовними до кінця) – 2-х чайних ложок.", R.drawable.study),

    Recipe("Стейк з яловичини з грибами\n", "яловичина – досить 700 г;\n" +
            "свіжі гриби (краще взяти білі або печериці) – 100 г;\n" +
            "головка цибулі-шалот;\n" +
            "мадера – ½ склянки;\n" +
            "вода – ¾ склянки;\n" +
            "рослинна олія (підійде оливкова) – пара столових ложок;\n" +
            "сіль і перець мелений чорний – орієнтуйтеся на власний смак;\n" +
            "крохмаль з кукурудзи – пари чайних ложок цілком достатньо.", R.drawable.study),

    Recipe("Легкий стейк з лосося у фользі\n", "ососеві стейки – візьмемо 4 штуки;\n" +
            "сіль (морській рибі і сіль морська), чорний мелений перець, зелень (сушена), приправа до риби – у розрахунку на власний смак.\n" +
            "Для соусу:\n" +
            "йогурт (краще використовувати натуральний) – склянка;\n" +
            "суміш мелених перців, сіль, зелений кріп – скільки захочете самі;\n" +
            "часник – двох зубков буде достатньо.", R.drawable.study),

    Recipe("Лазанья з сосисками – просто і швидко", "фарш з м’яса курки або індички – візьмемо 300 г;\n" +
            "пара цибулин;\n" +
            "часник – вистачить 3-4 зубки;\n" +
            "сосиски – 4-х буде достатньо;\n" +
            "помідори у власному соку – 350 г в самий раз;\n" +
            "м’який сир («Моцарелла» підійде) – ¾ склянки;\n" +
            "твердий сир («Російський» іди «Голландський») – 150 г;\n" +
            "вода – півтори склянки;\n" +
            "лазанья (суха магазинна) – не менше 200 м;\n" +
            "рослинна олія – 3 столових ложок цілком достатньо.", R.drawable.study),

    Recipe("Спагетті з соусом з базиліка на вечерю", "спагетті – візьмемо 200 г;\n" +
            "сир (краще всього підійде «Пармезан») – 100 г;\n" +
            "базилік – 150 г цілком вистачить;\n" +
            "олія оливок – столова ложка;\n" +
            "сіль і мелений чорний перець – скільки забажаєте;\n" +
            "часник – не більше 2-х зубков.", R.drawable.study),

    Recipe("Сирна запіканка з макаронами на вечерю", "макарони і сир – відповідно 300 і 400 г;\n" +
            "сирі курячі яйця – 3-х штук вистачить;\n" +
            "оливки (або маслини) – вибирайте без кісточок;\n" +
            "твердий сир (будь-якого сорту) – хоча б 50 г;\n" +
            "молоко – достатньо 3-х столових ложок;\n" +
            "сіль і приправи додайте на свій смак.", R.drawable.study)
)

@Preview(showBackground = true)
@Composable
fun PreviewRecipeApp() {
    IPZ32CW3_Kits_IvanTheme {
        RecipeApp()
    }
}