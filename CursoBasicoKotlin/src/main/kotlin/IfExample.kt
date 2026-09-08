package org.example

fun main() {
    val age = 8
    val isAdult: Boolean = age >= 18


    if (isAdult) {
        println("Soy mayor de edad")
    } else {
        println("Soy menor de edad")
    }

//    if(isAdult){
//        println("Soy menor de edad")
//    }

//    if(age <= 18){
//        println("Soy menor de edad")
//    }


    val orderTotal = 90.0

    if (orderTotal >= 100) {
        println("Envío gratis")
    } else if (orderTotal >= 50) {
        println("Envío con descuento")
    } else if (orderTotal >= 25) {
        println("Te regalamos un chupete")
    } else {
        print("Gastos de envío normales")
    }

    val score = 95

    if (score > 50) {
        println("aprobado")
    }

    if (score > 90) {
        println("Sobresaliente")
    }

    val price = 175.0
    val isPremiumCustomer = false

    if (price >= 100 || isPremiumCustomer) {
        println("Envío gratis")
    }


    val myAge = 33

    val accessMessage = if (myAge >= 18) {
        println("Pepe")
        "Mayor de edad"
    } else {
        "Menor de edad"
    }

    println(accessMessage)

    val score2 = 95

    val resultMessage = if(score2 >= 90){
        "Aris"
    }else{
        "Pepe"
    }


}