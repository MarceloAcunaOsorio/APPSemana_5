package com.marceloacuna.semana_5.Model

import com.marceloacuna.semana_5.R

class Model_Abecedario (
    val id:Int,
    val nombre:String,
    val descripcion: String,
    val imgen: Int
){
}





val abecedario = listOf(

    Model_Abecedario(
        id = 1,
        nombre = "letra A",
        descripcion = "",
        R.drawable.letra_a
    ),
    Model_Abecedario(
        id = 2,
        nombre = "letra B",
        descripcion = "",
        R.drawable.letra_b
    ),
    Model_Abecedario(
        id = 3,
        nombre = "letra C",
        descripcion = "",
        R.drawable.letra_c
    )
)