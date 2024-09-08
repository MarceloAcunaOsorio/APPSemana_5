package com.marceloacuna.semana_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.marceloacuna.semana_5.Pages.RegisterScreen
import com.marceloacuna.semana_5.ui.theme.Semana_5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Semana_5Theme {
                App()
            }
            }
        }
    }
