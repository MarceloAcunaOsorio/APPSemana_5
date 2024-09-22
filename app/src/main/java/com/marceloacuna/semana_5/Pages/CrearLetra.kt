package com.marceloacuna.semana_5.Pages

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.ButtonDefaults.shape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.database.FirebaseDatabase
import com.marceloacuna.semana_5.Model.Model_Abecedario
import com.marceloacuna.semana_5.Model.User
import com.marceloacuna.semana_5.Model.UserDatabase
import com.marceloacuna.semana_5.R
import java.text.DateFormat
import java.time.LocalDate



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrearLetraScreen(onNavigateHome: () -> Unit) {
    var nombreLetra by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var imagen by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var context = LocalContext.current




    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)

    {

        //imagen de pantalla crear
        Image(painter = painterResource(id = R.drawable.iconocrear2), contentDescription = "Login Image",modifier = Modifier.size(300.dp))

        //texto de pantalla Crear y su estilo
        androidx.compose.material3.Text(text = "Letra", fontSize = 28.sp,fontWeight = FontWeight.Bold)
        //salto de linea
        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            value = nombreLetra,
            onValueChange = { nombreLetra = it },
            label = { Text("Nombre Letra") },
            modifier = Modifier.size(width = 380.dp, height = 60.dp),
            shape = RoundedCornerShape(40)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripcion Letra") },
            modifier = Modifier.size(width = 380.dp, height = 60.dp),
            shape = RoundedCornerShape(40)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = imagen,
            onValueChange = { imagen = it },
            label = { Text("Imagen") },
            modifier = Modifier.size(width = 380.dp, height = 60.dp),
            shape = RoundedCornerShape(40)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            when {
                nombreLetra == "" -> errorMessage = "Nombre no debe quedar vacio"
                descripcion == "" -> errorMessage = "Email no debe quedar vacio"
                imagen == "" -> errorMessage = "Password no debe quedar vacio"

                else -> {
                    val database = FirebaseDatabase.getInstance()
                    val ref = database.getReference("model_abecedario")

                    val model_abecedario = Model_Abecedario(
                        nombre = nombreLetra,
                        descripcion = descripcion,
                        imgen = imagen
                    )
                    ref.push().setValue(model_abecedario).addOnCompleteListener{task ->
                        if(task.isSuccessful)
                        {
                            Toast.makeText(context, "Letra creada", Toast.LENGTH_SHORT).show()
                        }
                        else
                        {
                            Toast.makeText(context, "Error al crear letra", Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            }
        },shape = RoundedCornerShape(16.dp),
            modifier = Modifier.size(width = 280.dp, height = 40.dp)
        ) {
            Text("Crear",
                style = TextStyle(
                    fontSize = 20.sp, // Tamaño de fuente
                    fontWeight = FontWeight.Bold // Peso de la fuente //
                ))
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = Color.Red)
        }


        //volver al login
        TextButton(
            onClick = onNavigateHome
        )
        { Text("Volver al Home"
            ,  style = TextStyle(
                fontSize = 20.sp, // Tamaño de fuente
                fontWeight = FontWeight.Bold // Peso de la fuente
            ))}

    }
}