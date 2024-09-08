package com.marceloacuna.semana_5.Model

data class User(
    val nombreCompleto: String,
    val email:String,
    val password:String,
    val fechaNac: String,
    val direccion: String


)
{}


object UserDatabase {
    val users = ArrayList<User>()

    // Método para verificar las credenciales del usuario
    fun authenticate(email: String, password: String): User? {
        return users.find { it.email == email && it.password == password }
    }


    fun printUsers() {
        println("Users in database:")
        users.forEach { user ->
            println("Full Name: ${user.nombreCompleto}, Email: ${user.email}, Password: ${user.password},Fecha Nacimiento: ${user.fechaNac}, Direccion: ${user.direccion}")
        }
    }
}