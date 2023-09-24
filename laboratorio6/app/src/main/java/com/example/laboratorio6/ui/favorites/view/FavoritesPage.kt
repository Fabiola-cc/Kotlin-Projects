package com.example.laboratorio6.ui.favorites.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.laboratorio6.ui.events.viewmodel.Ievent
import com.example.laboratorio6.ui.events.viewmodel.favEvents
import com.example.laboratorio6.ui.theme.Apricot

//Formato de elementos a mostrar en pantalla
@Composable
fun EventCards(event: Ievent){
    Card(colors = CardDefaults.cardColors(Apricot),
        modifier = Modifier //Especificaciones para visibilidad de carta
            .clip(RoundedCornerShape(3.dp))
            .height(400.dp)
            .padding(10.dp)
            .width(300.dp)) {
        AsyncImage( //Imagen en carta
            model = event.image,
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
        )
        //Titulo y detalles de evento
        Column(Modifier.padding(8.dp)){
            Text(text = event.title, fontSize = 20.sp)
            Text(text = event.details)
        }
    }
}

//Pagina de eventos favoritos
@Composable
fun FavoritesPage(){
    //Formato general en columna
    Column(modifier = Modifier.padding(15.dp).fillMaxWidth(), verticalArrangement = Arrangement.Center){
        LazyColumn(Modifier.align(Alignment.CenterHorizontally)){
            items(favEvents) { event ->
                EventCards(event)
            }
        }
    }
}