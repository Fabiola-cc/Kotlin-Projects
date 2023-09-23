package com.example.laboratorio6.ui.events.view

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.laboratorio6.navegacion.NavigationState
import com.example.laboratorio6.ui.theme.Apricot

//Data class para facilidad de representacion de datos
data class Ievent(val title:String = "Title",
                  val details: String = "Supporting text",
                  val context: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed condimentum magna ultricies, placerat tellus sed, faucibus neque. Aenean porttitor eros.",
                  val date: String = "01/06/2016", val time: String = "08:00 p.m.",
                  val image: String = "https://img.freepik.com/free-vector/outdoor-music-festival-composition_1284-19595.jpg?w=2000"){
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventCards(event: Ievent, navController: NavController){ //Elementos para mostrar en el grid
    Card(colors = CardDefaults.cardColors(Apricot),
        modifier = Modifier //Especificaciones para visibilidad de carta
            .clip(RoundedCornerShape(3.dp))
            .height(250.dp),
        onClick = {
            /*
            val eventDetails = arrayListOf(event.details, event.context, event.date, event.title, event.time, event.image)
            navController.navigate(route = "detail/${eventDetails}") {
                // Pasa los detalles del evento como argumento
                launchSingleTop = true
                popUpTo(navController.graph.startDestinationId) {
                    saveState = true
                }}
             */
            navController.navigate(route = NavigationState.Detail.route)
        } ) {
        AsyncImage( //Imagen en carta
            model = event.image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
        )
        //Titulo y detalles de evento
        Column(Modifier.align(Alignment.CenterHorizontally)){
            Text(text = event.title, fontSize = 20.sp)
            Text(text = event.details)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AllEvents(navController: NavController){
    val defEvent = Ievent()
    //Listados de eventos a mostrar
    val favEvents = remember { mutableStateListOf(defEvent,
        Ievent(image = "https://www.tasteofhome.com/wp-content/uploads/2021/10/GettyImages-1284067715-e1633375884844.jpg"),
        Ievent(image = "https://images.template.net/76446/Free-Music-Concert-Vector-1.jpg"),
        Ievent(image = "https://img.freepik.com/premium-vector/people-holding-champagne-glasses_171919-963.jpg?w=2000")) }
    val events = remember { mutableStateListOf(
        Ievent(image = "https://www.tasteofhome.com/wp-content/uploads/2021/10/GettyImages-1284067715-e1633375884844.jpg"),
        defEvent, defEvent,
        Ievent(image = "https://images.template.net/76446/Free-Music-Concert-Vector-1.jpg"),
        Ievent(image = "https://img.freepik.com/premium-vector/people-holding-champagne-glasses_171919-963.jpg?w=2000"),
        defEvent) }
    //Formato general en columna
    //Scaffold{
        Column(modifier = Modifier.padding(15.dp)){
            //Favorites & All GRID
            LazyVerticalGrid(columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)){
                //Titulo de division, ocupa el espacio de pantalla completo
                item(span = { GridItemSpan(maxLineSpan) }){
                    Text(text = "Your Favorites ✧", fontSize = 18.sp,
                        modifier = Modifier.padding(10.dp))
                }
                items(favEvents) { event ->
                    EventCards(event, navController)
                }
                //Titulo de division, ocupa el espacio de pantalla completo
                item(span = { GridItemSpan(maxLineSpan) }){
                    Text(text = "All events", fontSize = 18.sp,
                        modifier = Modifier.padding(10.dp))
                }
                items(events) { event ->
                    EventCards(event, navController)
                }
            }
        }
    //}
}

