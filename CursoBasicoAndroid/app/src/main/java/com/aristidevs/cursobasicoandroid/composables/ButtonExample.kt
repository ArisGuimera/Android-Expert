package com.aristidevs.cursobasicoandroid.composables

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ButtonExample(){
    Button( onClick = { print("Hola") }) {
        Text("Pulsame")
    }
}