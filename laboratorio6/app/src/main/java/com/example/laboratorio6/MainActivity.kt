/**
 * Universidad del Valle de Guatemala -UVG-
 * Ing. en Ciencia de la Computación y TI
 * Programación de Plataformas Móviles
 * Laboratorio 6 - Navegación
 *
 * Fabiola Contreras
 * Carné 22787
 */

package com.example.laboratorio6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.laboratorio6.navegacion.TabNavigation
import com.example.laboratorio6.ui.theme.Laboratorio6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TabNavigation()
                }
            }
        }
    }
}