package com.aristidevs.cursobasicoandroid.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TextExample(name:String) {
    Text(
        text = "Hola: $name",
        fontSize = 40.sp,
        color = Color(0xFF05D1FF),
        fontWeight = FontWeight.Thin
    )
}

@Preview
@Composable
fun TextExamplePreview(){
    TextExample("Pepe")
}