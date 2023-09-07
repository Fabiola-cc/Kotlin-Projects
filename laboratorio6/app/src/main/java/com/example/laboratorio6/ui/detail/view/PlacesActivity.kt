package com.example.laboratorio6.ui.detail.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio6.ui.events.view.Ievent
import com.example.laboratorio6.ui.theme.Apricot
import com.example.laboratorio6.ui.theme.Coral
import com.example.laboratorio6.ui.theme.Laboratorio6Theme

class PlacesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PlacesPage()
                }
            }
        }
    }
}

@Preview
@Composable
fun Place(){ //Preview de pantalla
    Laboratorio6Theme {
        PlacesPage()
    }
}

@Composable
fun PlacesPage(){ //Función principal de pantalla
    val allEvents = remember { mutableStateListOf(
        Ievent(title = "Guns And Roses LA", details = "LA Hall"),
        Ievent(title = "Guns And Roses Denver", details = "Denver Hall"),
        Ievent(title = "Guns And Roses New York", details = "Maddison Square Garden")) }
    //Columna deslizable, con elementos generales de lugares para eventos
    LazyColumn(modifier = Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(5.dp)){
        items(allEvents){event ->
            Places(event)
            Divider(thickness = 1.dp, modifier = Modifier.padding(8.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable //Componente de PlacesPage
fun Places(event: Ievent){
    ListItem(
        headlineText = { Text(event.title) }, //Titulo principal
        supportingText = { Text(event.details) }, //Detalles mínimos
        trailingContent = { //Botón a la derecha
            IconButton(onClick = { }) {
            Icon(Icons.Outlined.KeyboardArrowUp,  contentDescription = "See more") }
        },
        leadingContent = { //Elemento a la izquierda del texto
            //Elemento circular con la primera letra del evento
            Text(text = event.title.first().toString(),
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Apricot)
                    .width(40.dp) //Tamaño de circulo
                    .height(40.dp)
                    .padding(7.dp),
                textAlign = TextAlign.Center, fontFamily = FontFamily.Monospace,
                fontSize = 20.sp, color = Coral
            )
        }
    )
}