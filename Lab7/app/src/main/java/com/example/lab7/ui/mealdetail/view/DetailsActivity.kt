package com.example.lab7.ui.mealdetail.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.lab7.networking.response.MealDetails
import com.example.lab7.ui.mealdetail.viewmodel.MealDetailsViewModel
import com.example.lab7.ui.theme.Apricot

/**
 * Pantalla de detalles
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsPage(navController: NavController, idMeal:String){
    // Obtener los detalles del evento de los argumentos
    val viewModel: MealDetailsViewModel = viewModel()
    val rememberedMeals: MutableState<List<MealDetails>> = remember { mutableStateOf(emptyList()) }

    viewModel.getDetails(idMeal) { response ->
        val mealsFromTheApi = response?.details
        rememberedMeals.value = mealsFromTheApi.orEmpty()
    }

    // Obtener los detalles del evento de los argumentos
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item{
            Box(
            Modifier
                .background(Apricot)
                .fillMaxWidth()
                .height(60.dp)
                .padding(10.dp)){
            Text(text = "Food Details", textAlign = TextAlign.Center, fontSize = 28.sp,
                fontFamily = FontFamily.Cursive, modifier = Modifier.fillMaxSize())
            Button(modifier = Modifier //Botón para retornar a pantalla de grid
                .align(Alignment.TopStart)
                .padding(5.dp),
                onClick = { navController.navigateUp() }) {
                Icon(Icons.Rounded.ArrowBack, contentDescription = "Go back")
                }
            }
        }
        items(rememberedMeals.value) { meal ->
            ImageView(imageURL = meal.imageUrl)
            MainDetails(meal)
            Ingredientes(meal)
            //Instrucciones
            Text(text = "Instructions", fontSize = 20.sp, modifier = Modifier.padding(10.dp))
            Text(text = meal.instructions, modifier = Modifier.padding(10.dp), textAlign = TextAlign.Justify)
        }
    }
}
@Composable
fun ImageView(imageURL: String){
    //Muestra de imagen representativa
        AsyncImage( //Imagen
            model = imageURL,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
                .height(410.dp)
        )
}

@Composable
fun MainDetails(meal: MealDetails){
    //Detalles de receta
    Text(text = meal.name, fontSize = 30.sp, modifier = Modifier.padding(5.dp))
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        Icon(Icons.Filled.Place, contentDescription = "categoria")
        Text(text = meal.area)
    }
}


@Composable
fun Ingredientes(meal: MealDetails)
{
    Text(text = "Ingredients", fontSize = 20.sp, modifier = Modifier.padding(10.dp))
    for (i in 1..20) {
        val ingredientField = meal.javaClass.getDeclaredField("ingredient$i")
        val measureField = meal.javaClass.getDeclaredField("measure$i")

        ingredientField.isAccessible = true
        measureField.isAccessible = true

        val ingredientValue = ingredientField.get(meal) as String
        val measureValue = measureField.get(meal) as String

        if (ingredientValue != "") Text(text = "\t-> $ingredientValue: $measureValue")
    }
}

@Preview
@Composable
fun Preview(){
    DetailsPage(rememberNavController(), "52959")
}
