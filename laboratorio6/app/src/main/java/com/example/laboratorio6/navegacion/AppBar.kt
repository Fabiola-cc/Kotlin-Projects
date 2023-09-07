package com.example.laboratorio6.navegacion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@ExperimentalMaterial3Api
@Composable
fun AppBar(title: String) {
    TopAppBar(
        title = {
            Text(text = title, color = Color.White)
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF6650a4) ),
        navigationIcon = {

        })
}