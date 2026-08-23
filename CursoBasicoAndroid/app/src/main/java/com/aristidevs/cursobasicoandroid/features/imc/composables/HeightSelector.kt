package com.aristidevs.cursobasicoandroid.features.imc.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
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
fun HeightSelector(height: Float, onHeightChange: (Float) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(180.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = BackgroundComponent)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("ALTURA", fontSize = 18.sp, color = SecondaryText)
            Text("${height.toInt()} cm", fontSize = 48.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Slider(
                value =height,
                onValueChange = { onHeightChange(it) },
                valueRange = 120f..220f,
                colors = SliderDefaults.colors(
                    thumbColor = ControlColor,
                    activeTrackColor = ControlColor,
                    inactiveTrackColor = Color.White.copy(alpha = 0.25f)
                )
            )
        }
    }
}


@Preview
@Composable
fun HeightSelectorPreview() {
    HeightSelector(193f, {})
}