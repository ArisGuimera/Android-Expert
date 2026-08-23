package com.aristidevs.cursobasicoandroid.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aristidevs.cursobasicoandroid.ViewModelExample

@Composable
fun CounterScreen(modifier: Modifier, viewModelExample: ViewModelExample = viewModel()) {

    var counter2 by rememberSaveable { mutableStateOf(16) }
    var name by remember { mutableStateOf("") }

    val uiState by viewModelExample.uiState.collectAsStateWithLifecycle()

    Column(modifier) {
        Counter(counter = uiState.counter, onIncrement = { viewModelExample.onIncreaseCounter() })
        if(uiState.isLoading){
            CircularProgressIndicator()
        }
        Counter(counter = counter2, onIncrement = { counter2++ })
        TextFieldCounter(name = name, onValueChange = { myText -> name = myText })
    }
}

@Composable
fun Counter(
    modifier: Modifier = Modifier,
    counter: Int,
    onIncrement: () -> Unit
) {


    Column(modifier = modifier.padding(30.dp)) {
        Text("Pulsaciones: $counter")

        Button(onClick = { onIncrement() }) {
            Text("Sumar")
        }
    }
}

@Composable
fun TextFieldCounter(
    modifier: Modifier = Modifier,
    name: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = name,
        onValueChange = { onValueChange(it) },
        label = { Text("Example") })
}

