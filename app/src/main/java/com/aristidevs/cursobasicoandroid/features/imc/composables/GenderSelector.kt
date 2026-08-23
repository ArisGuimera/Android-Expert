package com.aristidevs.cursobasicoandroid.features.imc.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.aristidevs.cursobasicoandroid.ui.theme.BackgroundComponentSelected
import com.aristidevs.cursobasicoandroid.ui.theme.SecondaryText

@Preview
@Composable
fun GenderSelector(
    isMaleSelected: Boolean = true, onGenderSelected: (Boolean) -> Unit = {}
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        GenderCard(
            Modifier.weight(1f),
            gender = "Hombre",
            symbol = "♂",
            isSelected = isMaleSelected,
            onClick = { onGenderSelected(true) })
        GenderCard(
            Modifier.weight(1f),
            gender = "Mujer",
            isSelected = !isMaleSelected,
            symbol = "♀",
            onClick = { onGenderSelected(false) })
    }

}

@Preview
@Composable
fun GenderCard(
    modifier: Modifier = Modifier,
    isSelected: Boolean = true,
    gender: String = "",
    symbol: String = "",
    onClick: () -> Unit = {}
) {

    val containerColor = if (isSelected) {
        BackgroundComponentSelected
    } else {
        BackgroundComponent
    }
    Card(
        modifier = modifier
            .height(150.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = containerColor, contentColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                symbol, fontSize = 64.sp, fontWeight = FontWeight.ExtraBold, color = Color.White
            )
            Text(gender, fontSize = 18.sp, fontWeight = FontWeight.Medium,
                color = SecondaryText,
            )
        }
    }
}