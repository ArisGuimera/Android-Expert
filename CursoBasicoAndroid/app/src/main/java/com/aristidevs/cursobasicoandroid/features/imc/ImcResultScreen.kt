package com.aristidevs.cursobasicoandroid.features.imc

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aristidevs.cursobasicoandroid.ui.theme.BackgroundApp
import com.aristidevs.cursobasicoandroid.ui.theme.BackgroundComponent
import com.aristidevs.cursobasicoandroid.ui.theme.PrimaryButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImcResultScreen(result: Float, onBackSelected: () -> Unit) {

    val category = getBmiCategory(result)
    val description = getBmiDescription(result)
    val color = getBmiColor(result)

    Scaffold(
        containerColor = BackgroundApp,
        topBar = {
            TopAppBar(
                title = { Text("Analizando...") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundApp,
                    titleContentColor = Color.White
                )
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                "Tu resultado",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(32.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = BackgroundComponent)
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        category, color = color,
                        fontSize = 28.sp, fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        String.format("%.2f", result), color = Color.White,
                        fontSize = 74.sp, fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        description, color = Color.White,
                        fontSize = 24.sp, fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(Modifier.height(32.dp))
            Button(
                onClick = { onBackSelected() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryButton,
                    contentColor = Color.White
                )
            ) {
                Text("Recalcular", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}

fun getBmiCategory(bmi: Float): String {
    return when {
        bmi < 18.5f -> "Bajo peso"
        bmi < 25f -> "Normal"
        bmi < 30f -> "Sobrepeso"
        else -> "Obesidad"
    }
}

fun getBmiDescription(bmi: Float): String {
    return when {
        bmi < 18.5f -> "Estás por debajo del peso recomendado."
        bmi < 25f -> "Estás en lo óptimo. Titán, Mastodonte, Velociraptor, Jabalí."
        bmi < 30f -> "Empieza a caminar, coleguita."
        else -> "Quizás ese tercer paquete de oreos no es necesario."
    }
}

fun getBmiColor(bmi: Float): Color {
    return when {
        bmi < 18.5f -> Color(0xFFFFEB3B)
        bmi < 25f -> Color(0xFF4CAF50)
        bmi < 30f -> Color(0xFFFF5722)
        else -> Color(0xFFFF1100)
    }
}







