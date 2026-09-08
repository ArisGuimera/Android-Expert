package com.aristidevs.cursobasicoandroid.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ListExample(modifier: Modifier = Modifier) {

    val names = listOf(
        "Aris",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe",
        "MoureDev",
        "BettaTech",
        "SUSCRIBETE",
        "Manolo",
        "Pepe"
    )

    LazyColumn(modifier = modifier) {
        item {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(Color.Cyan),
                contentAlignment = Alignment.Center
            ) {
                Text("Título")
            }
        }
        items(names) {
            Text(it, color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.titleLarge)
        }
    }
}