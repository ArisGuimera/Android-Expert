package com.aristidevs.cursobasicoandroid.features.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aristidevs.cursobasicoandroid.R
import com.aristidevs.cursobasicoandroid.ui.theme.BackgroundApp
import com.aristidevs.cursobasicoandroid.ui.theme.BackgroundComponent
import com.aristidevs.cursobasicoandroid.ui.theme.BackgroundComponentSelected
import com.aristidevs.cursobasicoandroid.ui.theme.ControlColor
import com.aristidevs.cursobasicoandroid.ui.theme.PrimaryButton
import com.aristidevs.cursobasicoandroid.ui.theme.SecondaryText
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(onBackSelected: () -> Unit) {

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val settingsDataStore = remember { SettingsDataStore(context) }

    val notificationsEnabled by settingsDataStore.notificationsEnabled.collectAsState(true)
    val vibrationEnabled by settingsDataStore.vibrationEnabled.collectAsState(true)
    val soundsEnabled by settingsDataStore.soundsEnabled.collectAsState(true)
    val username by settingsDataStore.username.collectAsState("")
    var usernameText by remember(username) {
        mutableStateOf(username)
    }

    Scaffold(
        containerColor = BackgroundApp, topBar = {
            TopAppBar(
                title = { Text("Ajustes") }, navigationIcon = {
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
            Text(
                "CUENTA", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = SecondaryText
            )
            Spacer(Modifier.height(12.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = BackgroundComponent)
            ) {
                UsernameSetting(username = usernameText, onUsernameChanged = {
                    usernameText = it
                }, onSave = {
                    coroutineScope.launch {
                        settingsDataStore.setUsername(usernameText)
                    }
                })
            }

            Spacer(Modifier.height(32.dp))

            Text(
                "PREFERENCIAS",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = SecondaryText
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = BackgroundComponent)
            ) {
                Column() {
                    SettingsSwitch(
                        "Notificaciones",
                        "Recibir avisos de la aplicación.",
                        notificationsEnabled,
                        {
                            coroutineScope.launch {
                                settingsDataStore.setNotificationsEnabled(it)
                            }
                        })
                    SettingsSwitch("Vibración", "Vibrar al recibir acciones.", vibrationEnabled, {
                        coroutineScope.launch {
                            settingsDataStore.setVibrationEnabled(it)
                        }
                    })
                    SettingsSwitch(
                        "Sonidos",
                        "Reproducir sonidos en la aplicación",
                        soundsEnabled,
                        {
                            coroutineScope.launch {
                                settingsDataStore.setSoundsEnabled(it)
                            }
                        })
                }
            }

            Spacer(Modifier.height(32.dp))

            OutlinedButton(
                onClick = {
                    coroutineScope.launch {
                        settingsDataStore.resetSettings()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(2.dp, PrimaryButton),
            ) {
                Text(
                    "RESTABLECER AJUSTES", fontSize = 16.sp,
                    fontWeight = FontWeight.Bold, color = PrimaryButton
                )
            }

        }
    }
}

@Composable
fun UsernameSetting(username: String, onUsernameChanged: (String) -> Unit, onSave: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = onUsernameChanged,
            label = { Text("Nombre") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = SecondaryText,
                unfocusedTextColor = SecondaryText,
                cursorColor = ControlColor,
                focusedLabelColor = ControlColor,
            )
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = onSave,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryButton, contentColor = Color.White
            )
        ) {
            Text("Guardar", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
    }

}

@Composable
fun SettingsSwitch(
    title: String,
    description: String,
    enabled: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f)) {
            Text(
                title, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.White
            )
            Spacer(Modifier.height(4.dp))
            Text(
                description, fontSize = 14.sp, fontWeight = FontWeight.Light, color = SecondaryText
            )
        }
        Switch(
            enabled, onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                uncheckedThumbColor = SecondaryText,
                checkedTrackColor = ControlColor,
                uncheckedTrackColor = BackgroundComponentSelected,
                uncheckedBorderColor = SecondaryText
            )
        )
    }
}
















