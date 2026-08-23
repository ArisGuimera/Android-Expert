package org.example

fun main(){
//    println("Clase número 1")
//    println("Clase número 2")
//    println("Clase número 3")
//    println("Clase número 4")
//    println("Clase número 5")


    var firstLesson = 1
    var lastLesson = 100

    for (lessonNumber in firstLesson..lastLesson step 2){

        println("Clase número $lessonNumber")
    }
}