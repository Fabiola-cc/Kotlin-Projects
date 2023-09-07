package com.example.laboratorio6.ui.events.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import coil.compose.AsyncImage
import com.example.laboratorio6.ui.theme.Apricot
import com.example.laboratorio6.ui.theme.Laboratorio6Theme

class InfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InfoPage()
                }
            }
        }
    }
}

@Preview
@Composable
fun Info(){ //Preview de pantalla
    Laboratorio6Theme {
        InfoPage()
    }
}

//Data class para facilidad de representacion de datos
data class Ievent(val title:String = "Title",
                  val details: String = "Supporting text",
                  val image: String = "https://img.freepik.com/free-vector/outdoor-music-festival-composition_1284-19595.jpg?w=2000")

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

@Composable
fun InfoPage(){
    //Listados de eventos a mostrar
    val favEvents = remember { mutableStateListOf(Ievent(),
        Ievent(image = "https://www.tasteofhome.com/wp-content/uploads/2021/10/GettyImages-1284067715-e1633375884844.jpg"),
        Ievent(image = "https://images.template.net/76446/Free-Music-Concert-Vector-1.jpg"),
        Ievent(image = "https://img.freepik.com/premium-vector/people-holding-champagne-glasses_171919-963.jpg?w=2000")) }
    val events = remember { mutableStateListOf(
        Ievent(image = "https://www.tasteofhome.com/wp-content/uploads/2021/10/GettyImages-1284067715-e1633375884844.jpg"),
        Ievent(), Ievent(),
        Ievent(image = "https://images.template.net/76446/Free-Music-Concert-Vector-1.jpg"),
        Ievent(image = "https://img.freepik.com/premium-vector/people-holding-champagne-glasses_171919-963.jpg?w=2000"),
        Ievent()) }
    //Formato general en columna
    Column(modifier = Modifier.padding(15.dp)){
        //Título principal de app
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)){
            Text(text = "Todo Eventos ╰(*°▽°*)╯", fontSize = 22.sp)
            Icon(Icons.Filled.MoreVert, contentDescription = null)
        }

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
                EventCards(event)
            }
            //Titulo de division, ocupa el espacio de pantalla completo
            item(span = { GridItemSpan(maxLineSpan) }){
                Text(text = "All events", fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp))
            }
            items(events) { event ->
                EventCards(event)
            }
        }
    }
}