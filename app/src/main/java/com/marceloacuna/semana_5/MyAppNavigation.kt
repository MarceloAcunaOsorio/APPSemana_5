package com.marceloacuna.semana_5

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.marceloacuna.semana_5.Pages.HomeScreen
import com.marceloacuna.semana_5.Pages.LoginScreen
import com.marceloacuna.semana_5.Pages.RegisterScreen

@Composable
fun App() {
    var currentScreen by remember { mutableStateOf("login") }

    when (currentScreen) {
        "login" -> LoginScreen(
            onLoginSuccess = { currentScreen = "home"  },
            onNavigateToRegister = { currentScreen = "register" }
        )
        "register" -> RegisterScreen(
            onRegisterSuccess = { currentScreen = "login" }
        )
        "home" -> HomeScreen(
            onNavigateToLogin = { currentScreen = "login" }
        )

    }
}