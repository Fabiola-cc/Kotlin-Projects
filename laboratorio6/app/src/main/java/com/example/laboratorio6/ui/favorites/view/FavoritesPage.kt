package com.example.laboratorio6.ui.favorites.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.laboratorio6.ui.events.view.Ievent
import com.example.laboratorio6.ui.theme.Apricot

@Composable
fun EventCards(event: Ievent){ //Elementos para mostrar en el grid
    Card(colors = CardDefaults.cardColors(Apricot),
        modifier = Modifier //Especificaciones para visibilidad de carta
            .clip(RoundedCornerShape(3.dp))
            .height(250.dp)) {
        AsyncImage( //Imagen en carta
            model = event.image,
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .width(200.dp)
        )
        //Titulo y detalles de evento
        Column(Modifier.align(Alignment.CenterHorizontally)){
            Text(text = event.title, fontSize = 20.sp)
            Text(text = event.details)
        }
    }
}
@Composable
fun favoritesPage(favEvents: SnapshotStateList<Ievent>){
    //Formato general en columna
    Column(modifier = Modifier.padding(15.dp)){
        //Título principal de app
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)){
            Text(text = "Eventos favoritos", fontSize = 22.sp)
            Icon(Icons.Filled.MoreVert, contentDescription = null)
        }
        LazyColumn(Modifier.padding(10.dp)){
            items(favEvents) { event ->
                com.example.laboratorio6.ui.events.view.EventCards(event)
            }
        }
    }
}

@Preview
@Composable
fun favoritesView(){
    val favEvents = remember { mutableStateListOf(Ievent(),
        Ievent(image = "https://www.tasteofhome.com/wp-content/uploads/2021/10/GettyImages-1284067715-e1633375884844.jpg"),
        Ievent(image = "https://images.template.net/76446/Free-Music-Concert-Vector-1.jpg"),
        Ievent(image = "https://img.freepik.com/premium-vector/people-holding-champagne-glasses_171919-963.jpg?w=2000")) }
    favoritesPage(favEvents)
}