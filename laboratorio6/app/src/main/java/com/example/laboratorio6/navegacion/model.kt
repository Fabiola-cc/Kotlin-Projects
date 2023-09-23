package com.example.laboratorio6.navegacion

import android.os.Build
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
    object Detail: NavigationState("Detail") //Detalle de un evento
}

@Composable
fun CardNavigation(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = NavigationState.Home.route,
        modifier = modifier) {
        composable(route = NavigationState.Detail.route){
            DetailsPage(navController)
        }
        composable(route = NavigationState.Home.route) {
            AllEvents(navController)
        }
        /*
        composable(
            route = "detail/{eventId}",
            arguments = listOf(navArgument("eventId") { type = NavType.StringType })
        ) { backStackEntry ->
            val eventId = backStackEntry.arguments?.getStringArrayList("eventId")
            if (eventId != null) {
                DetailsPage(navController = navController, eventId = eventId)
            }
        }
         */
    }
}

typealias ComposableFun = @Composable () -> Unit

//Tab Navigation
sealed class TabItem(var icon: ImageVector, var title: String, var screen: ComposableFun) {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    object Home : TabItem(Icons.Filled.Home, "Events", {
        val navController = rememberNavController()
        CardNavigation(navController = navController)
    })
    object Places : TabItem(Icons.Filled.LocationOn, "Places", { PlacesPage() })
    object Favorites : TabItem(Icons.Filled.FavoriteBorder, "Favorites", { FavoritesPage() })
    object Profile : TabItem(Icons.Filled.Face, "Profile", { ProfilePage() })
}