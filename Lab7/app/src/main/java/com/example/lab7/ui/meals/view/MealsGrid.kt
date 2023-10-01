package com.example.lab7.ui.meals.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.lab7.networking.response.Meals
import com.example.lab7.ui.meals.viewmodel.MealViewModel
import com.example.lab7.ui.theme.Apricot

/**
 * Elemento para grid principal
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealCards(meal: Meals, navController: NavController){ //Elementos para mostrar en el grid
    Card(colors = CardDefaults.cardColors(Apricot),
        modifier = Modifier //Especificaciones para visibilidad de carta
            .clip(RoundedCornerShape(3.dp))
            .height(250.dp),
        //Navegación a pantalla con detalles}
        onClick = {navController.navigate(route = "detail/" + meal.id )}) {
        AsyncImage( //Imagen en carta
            model = meal.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
        )
        //Titulo y detalles de evento
        Column(Modifier.align(Alignment.CenterHorizontally)){
            Text(text = meal.name, fontSize = 15.sp, fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize())
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MealGrid(categoryID: String, navController: NavController){
    val viewModel: MealViewModel = viewModel()
    val rememberedMeals: MutableState<List<Meals>> = remember { mutableStateOf(emptyList()) }

    viewModel.getMeals(categoryID) { response ->
        val mealsFromTheApi = response?.meals
        rememberedMeals.value = mealsFromTheApi.orEmpty()
    }

    Column(modifier = Modifier.padding(15.dp)){
        Box(
            Modifier
                .background(Apricot)
                .fillMaxWidth()
                .height(60.dp)
                .padding(10.dp)){
            Text(text = "$categoryID Meals", textAlign = TextAlign.Center, fontSize = 28.sp,
            fontFamily = FontFamily.Cursive, modifier = Modifier.fillMaxSize())
            Button(modifier = Modifier //Botón para retornar a pantalla de grid
                .align(Alignment.TopStart)
                .padding(5.dp),
                onClick = { navController.navigateUp() }) {
                Icon(Icons.Rounded.ArrowBack, contentDescription = "Go back")
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        //Meals GRID
        LazyVerticalGrid(columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)){
            items(rememberedMeals.value) { meal ->
                MealCards(meal, navController)
            }

        }
    }
}

