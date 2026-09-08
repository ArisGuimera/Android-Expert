package com.aristidevs.cursobasicoandroid.features.imc.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aristidevs.cursobasicoandroid.ui.theme.BackgroundComponent
import com.aristidevs.cursobasicoandroid.ui.theme.ControlColor
import com.aristidevs.cursobasicoandroid.ui.theme.SecondaryText

@Composable
fun CounterSelector(
    age: Int,
    weight: Int,
    onPlusAgeSelected: () -> Unit,
    onMinusAgeSelected: () -> Unit,
    onPlusWeightSelected: () -> Unit,
    onMinusWeightSelected: () -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CounterCard(
            modifier = Modifier.weight(1f),
            title = "Peso",
            value = weight,
            onPlus = { onPlusWeightSelected() },
            onMinus = { onMinusWeightSelected() })
        CounterCard(
            modifier = Modifier.weight(1f),
            title = "Edad",
            value = age,
            onPlus = { onPlusAgeSelected() },
            onMinus = { onMinusAgeSelected() })
    }
}

@Composable
fun CounterCard(
    modifier: Modifier = Modifier,
    title: String,
    value: Int,
    onMinus: () -> Unit,
    onPlus: () -> Unit
) {

    Card(
        modifier.height(180.dp),
        colors = CardDefaults.cardColors(containerColor = BackgroundComponent),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                title, color = SecondaryText, fontSize = 18.sp, fontWeight = FontWeight.Medium
            )
            Spacer(Modifier.height(8.dp))
            Text(
                value.toString(),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                FloatingActionButton(
                    onClick = { onMinus() },
                    modifier = Modifier.size(52.dp),
                    containerColor = ControlColor,
                    contentColor = Color.White,
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("-", fontSize = 32.sp)
                }
                FloatingActionButton(
                    onClick = { onPlus() },
                    modifier = Modifier.size(52.dp),
                    containerColor = ControlColor,
                    contentColor = Color.White,
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("+", fontSize = 32.sp)
                }
            }
        }
    }
}

@Preview
@Composable
fun CounterCardPreview() {
    CounterCard(
        modifier = Modifier.width(200.dp),
        title = "PESO",
        value = 80,
        onPlus = {},
        onMinus = {})
}