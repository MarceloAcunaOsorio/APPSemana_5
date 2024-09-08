package com.marceloacuna.semana_5.Pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marceloacuna.semana_5.Model.UserDatabase
import com.marceloacuna.semana_5.R

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit, onNavigateToRegister: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {


        //imagen de pantalla de inicio
        Image(painter = painterResource(id = R.drawable.icono_mano), contentDescription = "Login Image",
            modifier = Modifier.size(150.dp))

        //texto de pantalla de inicio y su estilo
        androidx.compose.material3.Text(
            text = "Bienvenido My App",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )

        //salto de linea
        Spacer(modifier = Modifier.height(4.dp))

        androidx.compose.material3.Text(text = "Ingrese con su cuenta",fontWeight = FontWeight.Bold, fontSize = 20.sp)

        //salto de linea
        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email), modifier = Modifier.size(width = 370.dp, height = 60.dp)
            ,shape = RoundedCornerShape(30)
        )

        //salto de linea
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(), modifier = Modifier.size(width = 370.dp, height = 60.dp)
            ,shape = RoundedCornerShape(30)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            val user = UserDatabase.authenticate(email, password)
            if (user != null) {
                errorMessage = ""
                onLoginSuccess() // Navigate to the home screen
            } else {
                errorMessage = "Invalid email or password"
            }
        }
            ,shape = RoundedCornerShape(16.dp),
            modifier = Modifier.size(width = 280.dp, height = 40.dp)) {


            Text("Inicio de Sesión",
                style = TextStyle(
                    fontSize = 20.sp, // Tamaño de fuente
                    fontWeight = FontWeight.Bold // Peso de la fuente)
                ))}
        Spacer(modifier = Modifier.height(8.dp))
        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(
            onClick = onNavigateToRegister)
        {
            Text("Registrarse",
            style = TextStyle(
                fontSize = 20.sp, // Tamaño de fuente
                fontWeight = FontWeight.Bold // Peso de la fuente
            )
            )}

        //recuperar contraseña
        androidx.compose.material3.Text(
            text = "Recuperar Contraseña?",
            modifier = Modifier.clickable {/*codigo que realiza la accion*/ },fontSize = 20.sp)




        //salto de linea
        Spacer(modifier = Modifier.height(32.dp))

        androidx.compose.material3.Text(text = "o iniciar seción con")


        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        )

        {

            //imagen de registro -> google
            Image(painter = painterResource(id = R.drawable.logo_google1), contentDescription = "google Image",
                modifier = Modifier
                    .size(50.dp)
                    .clickable { /*se agrega codigo al hacer click*/ })


            //imagen de registro -> facebook
            Image(painter = painterResource(id = R.drawable.logo_facebook), contentDescription = "facebook Image",
                modifier = Modifier
                    .size(45.dp)
                    .clickable { /*se agrega codigo al hacer click*/ })


            //imagen de registro -> twiter
            Image(painter = painterResource(id = R.drawable.logo_twiter1), contentDescription = "twiter Image",
                modifier = Modifier
                    .size(50.dp)
                    .clickable { /*se agrega codigo al hacer click*/ })

        }
    }
}