package com.aristidevs.cursobasicoandroid.features.dogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.aristidevs.cursobasicoandroid.R
import com.aristidevs.cursobasicoandroid.ui.theme.BackgroundApp
import com.aristidevs.cursobasicoandroid.ui.theme.BackgroundComponent
import com.aristidevs.cursobasicoandroid.ui.theme.ControlColor
import com.aristidevs.cursobasicoandroid.ui.theme.PrimaryButton
import com.aristidevs.cursobasicoandroid.ui.theme.SecondaryText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogsScreen(onBackSelected: () -> Unit) {

    var query by remember {
        mutableStateOf("")
    }

    var isLoading by remember {
        mutableStateOf(true)
    }

    var error by remember {
        mutableStateOf<String?>(null)
    }

    var dogs by remember {
        mutableStateOf<List<Dog>>(emptyList())
    }

    val filteredDogs = remember(dogs, query){
        dogs.filter { dog ->
            dog.name.contains(query, ignoreCase = true) ||
                    dog.breed.contains(query, ignoreCase = true)
        }
    }

    LaunchedEffect(Unit) {
        try {
            dogs = DogApi.services.getDogs()
        } catch (e: Exception) {
            error = e.message ?: "SE JODIÓ"
        } finally {
            isLoading = false
        }
    }

    Scaffold(
        containerColor = BackgroundApp, topBar = {
            TopAppBar(
                title = { Text("Busca tu chucho") }, navigationIcon = {
                IconButton(onClick = { onBackSelected() }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_back), contentDescription = ""
                    )
                }
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = BackgroundApp,
                titleContentColor = Color.White,
                navigationIconContentColor = Color.White
            )
            )
        }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            DogSearchBar(query, { query = it })
            Spacer(Modifier.height(32.dp))
            when {
                isLoading -> {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(color = ControlColor)
                    }
                }

                error != null -> {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(error.orEmpty(), color = SecondaryText)
                    }
                }

                filteredDogs.isEmpty() -> {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("No hay resultados", color = SecondaryText)
                    }
                }

                else -> {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(bottom = 16.dp)
                    ) {
                        items(filteredDogs, key = { dog -> dog.id }) { dog ->
                            DogItem(dog)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun DogSearchBar(query: String, onValueChanged: (String) -> Unit) {
    OutlinedTextField(
        value = query,
        onValueChange = onValueChanged,
        placeholder = { Text("Buscar perro...") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = SecondaryText,
            unfocusedTextColor = SecondaryText,
            cursorColor = ControlColor,
        )
    )
}

@Composable
fun DogItem(dog: Dog) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = BackgroundComponent)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp), verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = BASE_URL + dog.image,
                contentDescription = dog.name,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.width(16.dp))

            Column(Modifier.weight(1f)) {
                Text(dog.name, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(Modifier.height(4.dp))
                Text(dog.breed, fontSize = 14.sp, color = PrimaryButton)
                Spacer(Modifier.height(4.dp))
                Text("${dog.age} años", fontSize = 14.sp, color = SecondaryText)
                Spacer(Modifier.height(8.dp))
                Text(dog.description, fontSize = 14.sp, color = Color.White)
            }

        }
    }
}









