package com.marceloacuna.semana_5.Pages

import android.content.ContentValues.TAG
import android.content.res.Configuration
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.marceloacuna.semana_5.Model.Model_Abecedario
import com.marceloacuna.semana_5.ui.theme.Semana_5Theme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onNavigateToLogin: () -> Unit, onNavigateCreaLetra:() -> Unit) {


    var showMenu by remember { mutableStateOf(false) }
    var context = LocalContext.current

    val database = FirebaseDatabase.getInstance()
    val ref = database.getReference("model_abecedario")



    TopAppBar(
        title = { androidx.compose.material3.Text(text = "My App") },
        colors = TopAppBarDefaults.topAppBarColors(Color.Cyan),

        actions = {

            IconButton(onClick = { Toast.makeText(context, "Home", Toast.LENGTH_SHORT).show() }) {
                Icon(Icons.Default.Home, "")
            }

            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(Icons.Default.Menu, "")
            }

            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(
                    text = { androidx.compose.material3.Text(text = "Crear Letra") },
                    onClick = onNavigateCreaLetra)

                DropdownMenuItem(
                    text = { androidx.compose.material3.Text(text = "Cerrar Sesión") },
                    onClick =  onNavigateToLogin )
            }
        }
    )

}




/*//crea listado de la lista abecedario
@Composable
fun AllAbecedario(platList: List<Model_Abecedario>){
    LazyColumn(
        Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(10.dp)
    ) {
        item {
            Row (
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                androidx.compose.material3.Text(text = "Letras",
                    style = androidx.compose.material.MaterialTheme.typography.h3)
            }
        }
        items(platList){
                Model_Abecedario -> AbecedarioCard(nombre = Model_Abecedario.nombre, descripcion = Model_Abecedario.descripcion, imagen = Model_Abecedario.imgen)
        }
    }
}
*/





