package org.example

fun main(){

    val example = mutableSetOf(
        "Perro",
        "Gato",
        "Perro",
        "perro"
    )

    example.add("dawda")
    example.remove("Perro")

    print(example)
}