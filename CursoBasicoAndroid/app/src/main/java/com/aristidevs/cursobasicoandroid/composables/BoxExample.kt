package com.aristidevs.cursobasicoandroid.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun BoxExample() {
    Box(
        modifier = Modifier.size(150.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Column() {
            Text("Pepe")
            Text("Carlos")
            Text("Pepe")
            Text("Carlos")
        }
    }
}