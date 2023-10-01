/**
 * Universidad del Valle de Guatemala -UVG-
 * Ing. en Ciencia de la Computación y TI
 * Programación de Plataformas Móviles
 * Laboratorio 7 - Networking
 *
 * Fabiola Contreras
 * Carné 22787
 */

package com.example.lab7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.lab7.navegacion.Navigation
import com.example.lab7.ui.theme.Laboratorio7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio7Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}