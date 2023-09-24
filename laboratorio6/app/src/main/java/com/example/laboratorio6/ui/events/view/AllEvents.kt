package com.example.laboratorio6.ui.events.view

import android.annotation.SuppressLint
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.laboratorio6.ui.events.viewmodel.Ievent
import com.example.laboratorio6.ui.events.viewmodel.events
import com.example.laboratorio6.ui.events.viewmodel.favEvents
import com.example.laboratorio6.ui.theme.Apricot

/**
 * Elemento para grid principal
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventCards(event: Ievent, navController: NavController){ //Elementos para mostrar en el grid
    Card(colors = CardDefaults.cardColors(Apricot),
        modifier = Modifier //Especificaciones para visibilidad de carta
            .clip(RoundedCornerShape(3.dp))
            .height(250.dp),
        //Navegación a pantalla con detalles del evento
        onClick = {navController.navigate(route = "detail/" + event.eventID)}) {
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
}

