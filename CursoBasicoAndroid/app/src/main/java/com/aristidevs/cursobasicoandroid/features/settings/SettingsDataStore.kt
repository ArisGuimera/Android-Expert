package com.aristidevs.cursobasicoandroid.features.settings

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.aristidevs.cursobasicoandroid.features.settings.PreferencesKey.NOTIFICATIONS
import com.aristidevs.cursobasicoandroid.features.settings.PreferencesKey.SOUNDS
import com.aristidevs.cursobasicoandroid.features.settings.PreferencesKey.USERNAME
import com.aristidevs.cursobasicoandroid.features.settings.PreferencesKey.VIBRATION
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.datastore by preferencesDataStore("settings")

private object PreferencesKey{
    val NOTIFICATIONS = booleanPreferencesKey("notifications")
    val VIBRATION = booleanPreferencesKey("vibration")
    val SOUNDS = booleanPreferencesKey("sounds")
    val USERNAME = stringPreferencesKey("username")
}

class SettingsDataStore(private val context: Context){

    val notificationsEnabled: Flow<Boolean> = context.datastore.data.map {  preferences ->
        preferences[NOTIFICATIONS] ?: true
    }
    val vibrationEnabled: Flow<Boolean> = context.datastore.data.map {  preferences ->
        preferences[VIBRATION] ?: true
    }
    val soundsEnabled: Flow<Boolean> = context.datastore.data.map {  preferences ->
        preferences[SOUNDS] ?: true
    }

    val username:Flow<String> = context.datastore.data.map { preferences ->
        preferences[USERNAME] ?: ""
    }

    suspend fun setNotificationsEnabled(enabled:Boolean){
        context.datastore.edit { preferences ->
            preferences[NOTIFICATIONS] = enabled
        }
    }

    suspend fun setUsername(username:String){
        context.datastore.edit { preferences ->
            preferences[USERNAME] = username
        }
    }
    suspend fun setVibrationEnabled(enabled:Boolean){
        context.datastore.edit { preferences ->
            preferences[VIBRATION] = enabled
        }
    }

    suspend fun setSoundsEnabled(enabled:Boolean){
        context.datastore.edit { preferences ->
            preferences[SOUNDS] = enabled
        }
    }

    suspend fun resetSettings(){
        context.datastore.edit { preferences ->
            preferences.clear()
        }
    }
}