package com.marceloacuna.semana_5.Pages

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onNavigateToLogin: () -> Unit) {
    var showMenu by remember{ mutableStateOf(false) }
    var context = LocalContext.current

    TopAppBar(
        title = { androidx.compose.material3.Text(text = "My App") },
        colors = TopAppBarDefaults.topAppBarColors(Color.Cyan),
        actions = {

            IconButton(onClick = { Toast.makeText(context,"Home", Toast.LENGTH_SHORT).show()}) {
                Icon(Icons.Default.Home,"")
            }

            IconButton(onClick = {showMenu = !showMenu}) {
                Icon(Icons.Default.Menu,"")
            }

            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = {showMenu = false}
            ) {
                DropdownMenuItem(text = { androidx.compose.material3.Text(text = "Crear Receta") }, onClick = {
                    Toast.makeText(context,"Crear Receta",
                        Toast.LENGTH_SHORT).show()})

                DropdownMenuItem(text = { androidx.compose.material3.Text(text = "Cerrar Sesión") }, onClick = {onNavigateToLogin})
            }
        }
    )


    @Composable
    fun AllRecetas(platList: List<Receta>){
        LazyColumn(Modifier.fillMaxWidth(),contentPadding = PaddingValues(10.dp)) {
            item {
                Row (
                    modifier = Modifier.height(250.dp).fillMaxWidth().wrapContentHeight().padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    androidx.compose.material3.Text(text = "Recetas",
                        style = androidx.compose.material.MaterialTheme.typography.h3)
                }
            }
            items(platList){
                    Receta -> RecetasCard(name = Receta.name, descripcion = Receta.descripcion, images = Receta.imageRes)
            }
        }
    }
