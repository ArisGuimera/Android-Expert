package org.example.exercises


/**
Mes del año:
Crea un programa que pida al usuario un número del 1 al 12.

El programa debe convertir ese número en el nombre del mes correspondiente.

Ejemplos:
- Si el usuario escribe 1, el programa debe mostrar "January".
- Si el usuario escribe 5, el programa debe mostrar "May".
- Si el usuario escribe 12, el programa debe mostrar "December".
- Si el usuario escribe un número que no está entre 1 y 12, debe mostrar "Invalid month".

Conceptos que debes utilizar:
- readln()
- toInt()
- when
- else
 */
fun main(){
    println("Escribe el mes que quieras:")
    val monthOfTheYear = readln().toInt()

    val result = when(monthOfTheYear){
        1-> "January"
        2-> "February"
        3 -> "March"
        4 -> "April"
        5 -> "May"
        6 -> "June"
        7 -> "July"
        8 -> "August"
        9 -> "September"
        10 -> "October"
        11 -> "November"
        12 -> "December"
        else -> "Invalid month"
    }

    println("El mes seleccionado es: $result")

}