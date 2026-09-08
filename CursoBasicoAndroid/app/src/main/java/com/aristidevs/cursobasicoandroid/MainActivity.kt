package com.aristidevs.cursobasicoandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.aristidevs.cursobasicoandroid.composables.CounterScreen
import com.aristidevs.cursobasicoandroid.core.AppNavigation
import com.aristidevs.cursobasicoandroid.features.MenuScreen
import com.aristidevs.cursobasicoandroid.ui.theme.CursoBasicoAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoBasicoAndroidTheme(dynamicColor = false) {
                AppNavigation()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Example() {
    Text(text = "Hola, es ", fontSize = 40.sp)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CursoBasicoAndroidTheme {
        Greeting("Android")
    }
}