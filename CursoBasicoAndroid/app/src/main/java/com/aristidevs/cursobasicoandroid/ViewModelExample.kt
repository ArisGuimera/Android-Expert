package com.aristidevs.cursobasicoandroid

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModelExample: ViewModel() {

    private val _uiState = MutableStateFlow(CounterUiState())
    val uiState = _uiState.asStateFlow()

    fun onIncreaseCounter(){
//        _counter.value++
//        _counter.update { value ->  value + 1 }
        _uiState.update { state ->
           state.copy(
               counter = state.counter + 1,
               isLoading = false
           )
        }
    }
}

data class CounterUiState(
    val counter:Int = 0,
    val isLoading: Boolean = true,
    val error:String? = null
)