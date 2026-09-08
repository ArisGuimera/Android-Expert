package com.aristidevs.cursobasicoandroid.features.dogs

import kotlinx.serialization.Serializable

@Serializable
data class Dog(
    val id:Int,
    val name:String,
    val breed:String,
    val age:Int,
    val description:String,
    val image:String,
)