package com.marceloacuna.semana_5.Pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun HomeScreen(onNavigateToLogin: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Welcome to Home Screen", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateToLogin) {
            Text("Logout")
        }
    }
}