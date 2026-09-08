package com.aristidevs.cursobasicoandroid.features

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aristidevs.cursobasicoandroid.ui.theme.BackgroundApp
import com.aristidevs.cursobasicoandroid.ui.theme.BackgroundComponent
import com.aristidevs.cursobasicoandroid.ui.theme.PrimaryButton
import com.aristidevs.cursobasicoandroid.ui.theme.SecondaryText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    onImcSelected: () -> Unit, onSettingsSelected: () -> Unit, onDogsSelected: () -> Unit
) {

    Scaffold(
        Modifier.fillMaxSize(), containerColor = BackgroundApp, topBar = {
            TopAppBar(
                title = { Text("AristiDevs App") }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundComponent, titleContentColor = Color.White
                )
            )
        }) { paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(24.dp)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { onImcSelected() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(2.dp, Color.White),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryButton)
            ) {
                Text("IMC Calculator", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = { onSettingsSelected() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                border = BorderStroke(2.dp, Color.White),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryButton)
            ) {
                Text("Settings", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = { onDogsSelected() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                border = BorderStroke(2.dp, Color.White),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryButton)
            ) {
                Text("Dogs", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.weight(1f))
            Text("Made with love by @AristiDevs", color = SecondaryText)
        }
    }


}