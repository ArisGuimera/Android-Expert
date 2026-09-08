package com.aristidevs.cursobasicoandroid.core

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.aristidevs.cursobasicoandroid.features.MenuScreen
import com.aristidevs.cursobasicoandroid.features.dogs.DogsScreen
import com.aristidevs.cursobasicoandroid.features.imc.ImcResultScreen
import com.aristidevs.cursobasicoandroid.features.imc.ImcScreen
import com.aristidevs.cursobasicoandroid.features.settings.SettingsScreen

@Composable
fun AppNavigation() {

    val backStack = rememberNavBackStack(Menu)

    NavDisplay(backStack = backStack, entryProvider = entryProvider {
        entry<Menu> {
            MenuScreen(onImcSelected = { backStack.add(IMC) }, onSettingsSelected = {
                backStack.add(
                    Settings
                )
            }, onDogsSelected = {backStack.add(Dogs)}
            )
        }

        entry<IMC> {
            ImcScreen(
                onResultSelected = { result -> backStack.add(IMCResult(result)) },
                onBackSelected = { backStack.removeLastOrNull() })
        }

        entry<IMCResult> { data ->
            ImcResultScreen(data.result, { backStack.removeLastOrNull() })
        }

        entry<Settings> {
            SettingsScreen(onBackSelected = { backStack.removeLastOrNull() })
        }

        entry<Dogs>{
            DogsScreen(onBackSelected = { backStack.removeLastOrNull() })
        }
    })
}