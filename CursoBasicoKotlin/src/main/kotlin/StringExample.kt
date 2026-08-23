package org.example

fun main(){
    val name = "Aris"
    val age = 33

    println("Me llamo $name y tengo $age años")

    val price:Double = 20.0
    val quantity:Int  = 3

    println("El precio total es de ${price * quantity} euros")

    println("Es mayor de edad? ${age >= 18}")

    println("Esto es un \"ejemplo\"")

    val example:String = "3"
    val example2:Int = 4

    val result = example2.toString() + example

    print(result)

}