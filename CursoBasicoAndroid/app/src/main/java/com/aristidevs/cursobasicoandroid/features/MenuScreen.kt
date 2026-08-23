package com.aristidevs.cursobasicoandroid.features

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(onImcSelected: () -> Unit, onSettingsSelected: () -> Unit) {

    Scaffold(Modifier.fillMaxSize(), topBar = {
        TopAppBar(title = { Text("AristiDevs App") })
    }) { paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 18.dp)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { onImcSelected() }) {
                Text("IMC Calculator")
            }

            Spacer(Modifier.height(24.dp))

            Button(onClick = { onSettingsSelected() }) {
                Text("Settings")
            }
        }
    }


}