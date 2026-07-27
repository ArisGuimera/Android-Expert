package org.example.exercises

/**
Mes y estación del año:
Crea un programa que pida al usuario un número del 1 al 12.

El programa debe calcular:
- El nombre del mes.
- La estación del año a la que pertenece ese mes.

Reglas:
- 12, 1 y 2 pertenecen a "Winter".
- 3, 4 y 5 pertenecen a "Spring".
- 6, 7 y 8 pertenecen a "Summer".
- 9, 10 y 11 pertenecen a "Autumn".

Ejemplos:
- Si el usuario escribe 1, el programa debe mostrar "January" y "Winter".
- Si el usuario escribe 4, el programa debe mostrar "April" y "Spring".
- Si el usuario escribe 8, el programa debe mostrar "August" y "Summer".
- Si el usuario escribe 10, el programa debe mostrar "October" y "Autumn".
- Si el usuario escribe un número que no está entre 1 y 12, debe mostrar "Invalid month".

Conceptos que debes utilizar:
- readln()
- toInt()
- if
- rangos con in
- when
- else
 */

fun main(){
    println("Escribe el mes que quieras:")
    val monthOfTheYear = readln().toInt()

    val monthName = when(monthOfTheYear){
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

    if(monthOfTheYear in 1..12){
        val seasonName = when(monthOfTheYear){
            12, 1, 2 -> "Winter"
            3, 4, 5 -> "Spring"
            6, 7, 8 -> "Summer"
            else -> "Autumn"
        }
        println("El mes seleccionado es: $monthName y la estación $seasonName")
    }else{
        println(monthName)
    }
}