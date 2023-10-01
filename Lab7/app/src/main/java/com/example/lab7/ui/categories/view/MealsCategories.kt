package com.example.lab7.ui.categories.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.lab7.networking.response.MealCategories
import com.example.lab7.ui.categories.viewmodel.MealsCategoriesViewModel
import com.example.lab7.ui.theme.Apricot

@Composable
fun Categories(navController: NavController){ //Función principal de pantalla
    val viewModel: MealsCategoriesViewModel = viewModel()
    val rememberedMeals: MutableState<List<MealCategories>> = remember { mutableStateOf(emptyList()) }

    viewModel.getCategories { response ->
        val mealsFromTheApi = response?.categories
        rememberedMeals.value = mealsFromTheApi.orEmpty()
    }

    //Columna deslizable, con elementos generales de lugares para eventos
    LazyColumn {
        item{Row(
            Modifier
                .background(Apricot)
                .fillMaxWidth()
                .height(60.dp)
                .padding(10.dp)){
            Text(text = "Meal Categories", textAlign = TextAlign.Center, fontSize = 28.sp,
                fontFamily = FontFamily.Cursive, modifier = Modifier.fillMaxSize())}}
        item { Spacer(modifier = Modifier.padding(8.dp)) }
        items(rememberedMeals.value) { meal ->
            Elements(meal,navController)
            Divider(thickness = 1.dp, modifier = Modifier.padding(8.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable //Componente de pagina con categorías
fun Elements(meal: MealCategories, navController: NavController){
    ListItem(
        headlineText = { Text(meal.name + "\n", fontSize = 18.sp ) }, //Titulo principal
        trailingContent = { //Botón a la derecha
            IconButton(onClick = { navController.navigate(route = "meals/" + meal.name )}) {
            Icon(Icons.Outlined.Search,  contentDescription = "See more") }
        },
        leadingContent = { //Elemento a la izquierda del texto
            //Elemento circular con imagen
            AsyncImage(model = meal.imageUrl, contentDescription = "Descriptive image",
                modifier = Modifier
                    .clip(CircleShape)
                    .width(70.dp) //Tamaño de circulo
                    .height(70.dp)
                    .padding(7.dp),
                alignment = Alignment.TopStart)
        },
    )
}

@Preview
@Composable
fun ElementPreview(){
    val meal = MealCategories(
        categoryID = "1",
        name = "Plato Principal",
        description = "Categoría de platos principales",
        imageUrl = "https://www.example.com/images/main_dish.jpg"
    )

    Elements(meal = meal, navController = rememberNavController())
}