package com.example.lab7.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lab7.ui.categories.view.Categories
import com.example.lab7.ui.mealdetail.view.DetailsPage
import com.example.lab7.ui.meals.view.MealGrid

/*
 * Rutas de navegación
 */
sealed class NavigationState(val route: String) {
    object Home: NavigationState("Home") //Lista de categorías
    object Meals: NavigationState("meals/{Category}") //Grid de comidas
    object Detail: NavigationState("detail/{MealID}") //Detalle de un evento
}

/*
    Navegación directa entre pantallas
*/
@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = NavigationState.Home.route, //Inicia en el listado de categorías
        modifier = modifier) {
        composable(route = NavigationState.Home.route) {
            Categories(navController) //Ruta a lista
        }
        composable( //Ruta a pantalla de detalles, recibe el argumento de ID para la comida a mostrar
            route = NavigationState.Detail.route,
            arguments = listOf(navArgument("MealID") { type = NavType.StringType })
        ) {
            val mealID = it.arguments?.getString("MealID") //Toma el string de la función anterior
            if (mealID != null) DetailsPage(navController = navController, idMeal = mealID) //Llama a la función de la pantalla de detalle
        }
        composable( //Ruta a pantalla de comidas, recibe el argumento de la categoría a mostrar
            route = NavigationState.Meals.route,
            arguments = listOf(navArgument("Category") { type = NavType.StringType })
        ) {
            val categoryID = it.arguments?.getString("Category") //Toma el string de la función anterior
            if (categoryID != null) MealGrid(navController = navController, categoryID = categoryID) //Llama a la función de la pantalla de detalle
        }
    }
}