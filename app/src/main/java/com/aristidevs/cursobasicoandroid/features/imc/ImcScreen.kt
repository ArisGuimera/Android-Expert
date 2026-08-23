package com.aristidevs.cursobasicoandroid.features.imc

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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aristidevs.cursobasicoandroid.R
import com.aristidevs.cursobasicoandroid.features.imc.composables.CounterSelector
import com.aristidevs.cursobasicoandroid.features.imc.composables.GenderSelector
import com.aristidevs.cursobasicoandroid.features.imc.composables.HeightSelector
import com.aristidevs.cursobasicoandroid.ui.theme.BackgroundApp
import com.aristidevs.cursobasicoandroid.ui.theme.PrimaryButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImcScreen(onResultSelected: (Float) -> Unit, onBackSelected: () -> Unit) {

    var isMaleSelected by remember { mutableStateOf(true) }
    var height by remember { mutableStateOf(160f) }
    var weight by remember { mutableStateOf(80) }
    var age by remember { mutableStateOf(30) }

    Scaffold(
        containerColor = BackgroundApp, topBar = {
            TopAppBar(
                title = { Text("IMC Calculator") }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundApp,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                ), navigationIcon = {
                    IconButton(onClick = { onBackSelected() }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_back), contentDescription = ""
                        )
                    }
                })
        }) { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            GenderSelector(
                isMaleSelected = isMaleSelected, onGenderSelected = { isMaleSelected = it })
            HeightSelector(height, { height = it })
            CounterSelector(
                age = age,
                onPlusAgeSelected = { age++ },
                onMinusAgeSelected = { age-- },
                weight = weight,
                onPlusWeightSelected = { weight++ },
                onMinusWeightSelected = { weight-- })
            Spacer(Modifier.weight(1f))
            Button(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 32.dp)
                    .fillMaxWidth()
                    .height(72.dp), onClick = {
                    val result: Float = calculateBmi(height, weight)
                    onResultSelected(result)
                }, shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryButton,
                    contentColor = Color.White
                )
            ) {
                Text("Calcular", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

fun calculateBmi(
    height: Float, weight: Int
): Float {
    val heightInMeters = height / 100
    return weight / (heightInMeters * heightInMeters)
}