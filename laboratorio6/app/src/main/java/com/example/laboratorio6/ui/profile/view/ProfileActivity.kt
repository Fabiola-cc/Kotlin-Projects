package com.example.laboratorio6.ui.profile.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.laboratorio6.ui.theme.Laboratorio6Theme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfilePage()
                }
            }
        }
    }
}

@Preview
@Composable
fun Profile(){ //Preview de pantalla
    Laboratorio6Theme {
        ProfilePage()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable //Componente de ProfilePage
fun Editable(icon: ImageVector, text: String){
    ListItem( //Creación de elemento para lista
        headlineText = { Text(text = text, fontSize = 15.sp) }, //Texto titular
        trailingContent = { //Elemento a la derecha del texto
            IconButton(onClick = { }) {
            Icon(Icons.Outlined.KeyboardArrowUp,  contentDescription = null) } },
        //Elemento a la izquierda del texto
        leadingContent = { Icon(icon, contentDescription = null) }
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(){
    Column {
        Box(modifier = Modifier
            .fillMaxWidth() //Especificaciones del contenedor
            .align(Alignment.CenterHorizontally)){
            AsyncImage( //Imagen de fondo del perfil
                model = "https://free4kwallpapers.com/uploads/originals/2020/10/30/colorful-wallpaper.png",
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
            )
            AsyncImage( //Imagen de perfil principal
                model = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .clip(CircleShape)
                    .height(130.dp)
                    .width(130.dp)
                    .align(Alignment.Center)
            )
            Text(text = "Nombre de usuario", color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomCenter) //Ubicación al centro y final
                    .padding(bottom = 20.dp), //Espaciado
                fontSize = 20.sp, fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraBold)
        }
        //Elementos en lista
        Editable(icon = Icons.Outlined.Person, text = "Edit Profile")
        Editable(icon = Icons.Outlined.Lock, text = "Reset Password")
        ListItem( //Elemento especial, contiene un botón switch en lugar de botón normal
            headlineText = { Text(text = "Notifications", fontSize = 15.sp) },
            trailingContent = {
                var checked by remember { mutableStateOf(true) }
                Switch(
                    checked = checked,
                    onCheckedChange = {
                        checked = it
                    }
                )
            },
            leadingContent = { Icon(Icons.Outlined.Notifications, contentDescription = null) }
        )
        Editable(icon = Icons.Outlined.FavoriteBorder, text = "Favorites")
    }
}