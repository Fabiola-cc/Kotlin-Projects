package com.example.laboratorio6.navegacion

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.laboratorio6.ui.detail.view.PlacesPage
import com.example.laboratorio6.ui.events.view.AllEvents
import com.example.laboratorio6.ui.events.view.DetailsPage
import com.example.laboratorio6.ui.favorites.view.FavoritesPage
import com.example.laboratorio6.ui.profile.view.ProfilePage

/*
 * Rutas de navegación
 */
sealed class NavigationState(val route: String) {
    object Home: NavigationState("Home") //Grid de eventos
    object Detail: NavigationState("detail/{eventDetails}") //Detalle de un evento
}

/*
    NavHost, navegación directa
    Esta función es empleada para navegar entre el grid de eventos y la pantalla de detalle del evento
*/
@Composable
fun CardNavigation(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = NavigationState.Home.route, //Inicia en el Grid de eventos
        modifier = modifier) {
        composable(route = NavigationState.Home.route) {
            AllEvents(navController) //Ruta a grid
        }
        composable( //Ruta a pantalla de detalles, recibe el argumento de ID para el evento a mostrar
            route = NavigationState.Detail.route,
            arguments = listOf(navArgument("eventDetails") { type = NavType.StringType })
        ) {
            val eventID = it.arguments?.getString("eventDetails") //Toma el string de la función anterior
            if (eventID != null) DetailsPage(navController = navController, eventID = eventID) //Llama a la función de la pantalla de detalle
        }
    }
}

typealias ComposableFun = @Composable () -> Unit

/*
 * Tab Navigation items
 * sealed class que permite establecer las rutas de movimiento para la barra en la app
 */
sealed class TabItem(var icon: ImageVector, var title: String, var screen: ComposableFun) {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    object Home : TabItem(Icons.Filled.Home, "Events", {
        val navController = rememberNavController()
        CardNavigation(navController = navController)
    })
    object Places : TabItem(Icons.Filled.LocationOn, "Places", { PlacesPage() }) //Lista
    object Favorites : TabItem(Icons.Filled.FavoriteBorder, "Favorites", { FavoritesPage() })
    object Profile : TabItem(Icons.Filled.Face, "Profile", { ProfilePage() }) //Perfil
}