package com.example.laboratorio6.ui.events.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.laboratorio6.ui.theme.Laboratorio6Theme

class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailsPage()
                }
            }
        }
    }
}

@Preview
@Composable
fun Details(){ //Preview de pantalla
    Laboratorio6Theme {
        DetailsPage()
    }
}

@Composable
fun DetailsPage(){
    Column {//Los elementos son mostrados en columna
        Box(modifier = Modifier.fillMaxWidth()){//Muestra de imagen representativa del eventos
            AsyncImage( //Imagen
                model = "https://htmlcolorcodes.com/assets/images/colors/light-orange-color-solid-background-1920x1080.png",
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(text = "Lugar", Modifier.align(Alignment.BottomStart))
        }
        //Detalles del evento
        Text(text = "Title", fontSize = 30.sp, modifier = Modifier.padding(5.dp))
        Row( //Fecha y hora
            Modifier
                .fillMaxWidth()
                .padding(15.dp), Arrangement.SpaceBetween) {
            Row( horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Icon(Icons.Filled.DateRange, contentDescription = "Date")
                Text(text = "Fecha: ")
            }
            Text(text = "Hora")
        }
        //Descripción
        Text(text = "About", fontSize = 20.sp, modifier = Modifier.padding(10.dp))
        Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Justify) //Texto justificado
        Spacer(modifier = Modifier.weight(1f)) //Espaciado entre texto y botones
        Row( //Botones de navegacion
            Modifier
                .fillMaxWidth()
                .padding(10.dp), Arrangement.SpaceAround) {
            Button(onClick = { /*TODO*/ }, modifier = Modifier.width(100.dp)) {
                Text(text = "Favorite") //Añadir a favorito
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.width(100.dp)) {
                Text(text = "Buy") //Comprar
            }
        }
        

    }
}
