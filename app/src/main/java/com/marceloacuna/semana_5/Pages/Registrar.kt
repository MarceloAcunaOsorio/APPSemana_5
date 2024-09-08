package com.marceloacuna.semana_5.Pages

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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marceloacuna.semana_5.Model.User
import com.marceloacuna.semana_5.Model.UserDatabase
import com.marceloacuna.semana_5.R
import java.text.DateFormat
import java.time.LocalDate


@Composable
fun RegisterScreen(onRegisterSuccess: () -> Unit) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var fechaNac by remember { mutableStateOf(LocalDate.now().toString()) }
    var address by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)

    {

        //imagen de pantalla de inicio
        Image(painter = painterResource(id = R.drawable.icono_mano), contentDescription = "Login Image",
            modifier = Modifier.size(150.dp))

        //texto de pantalla de inicio y su estilo
        androidx.compose.material3.Text(
            text = "Registro de Usuario",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        //salto de linea
        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = { Text("Full Name") },
            modifier = Modifier.size(width = 380.dp, height = 60.dp),
            shape = RoundedCornerShape(40)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            modifier = Modifier.size(width = 380.dp, height = 60.dp),
            shape = RoundedCornerShape(40)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.size(width = 380.dp, height = 60.dp),
            shape = RoundedCornerShape(40)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.size(width = 380.dp, height = 60.dp),
            shape = RoundedCornerShape(40)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = fechaNac,
            onValueChange = { fechaNac = it },
            label = { Text("Birth Date (YYYY-MM-DD)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            modifier = Modifier.size(width = 380.dp, height = 60.dp),
            shape = RoundedCornerShape(40)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Address") },
            modifier = Modifier.size(width = 380.dp, height = 60.dp),
            shape = RoundedCornerShape(40)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            val birthDateParsed = try {
                LocalDate.parse(fechaNac)
            } catch (e: Exception) {
                null
            }

            when {
                fullName == "" -> errorMessage = "Nombre no debe quedar vacio"
                email == "" -> errorMessage = "Email no debe quedar vacio"
                password == "" -> errorMessage = "Password no debe quedar vacio"
                address == "" -> errorMessage = "Direccion no debe quedar vacio"

                password != confirmPassword -> errorMessage = "las contraseñas no coinciden"
                UserDatabase.users.any { it.email == email } -> errorMessage = "Email ya existe"
                birthDateParsed == null -> errorMessage = "Formato de fecha no válido (yyyy-mm-dd)"
                else -> {
                    UserDatabase.users.add(User(fullName, email, password, fechaNac, address))
                    errorMessage = "Usuario Registrado"
                    UserDatabase.printUsers() // Print users to console
                    onRegisterSuccess()
                }
            }
        }) {
            Text("Registrarse")
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = Color.Red)
        }


        //volver al login
        TextButton(
            onClick = onRegisterSuccess)
        { Text("Volver al Login") }

    }
}