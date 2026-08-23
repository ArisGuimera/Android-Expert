package org.example

fun main() {

    val userRole: String = "admin"

    val permission = if (userRole == "admin") {
        "Full access"
    } else if (userRole == "editor") {
        "Editing access"
    } else if (userRole == "viewer") {
        "Viewer access"
    } else {
        "Unknown rol"
    }

    val permission2 = when (userRole) {
        "admin" -> "Full access"
        "editor" -> "Editing access"
        "viewer" -> "Viewer access"
        else -> "Unknown rol"
    }

    val score = 67
    val example = when {
        score > 50 -> "Aprobado"
        score > 70 && permission2 == "Full access" -> "pepe"
        else -> "Ejemplo"
    }

    when (userRole) {
        "admin" -> print("Hola admin")
        "editor" -> {
            print("Hola editor")
            print("Hola editor")
            print("Hola editor")
        }

        "viewer", "guest" -> "Viewer access"
        else -> "Unknown rol"
    }

    val level = -8
    when {
        level > 0 && level <= 3 -> print("Noob")
        level > 3 && level <= 5 -> print("Beginner")
        level > 6 && level <= 8 -> print("Intermediate")
        level > 8 -> print("Bombita")
        else -> ""
    }

    val myRange: IntRange = 0..10

    when(level){
        !in -100..0 -> print("")
        in 0..3 -> print("Noob")
        in 4..5 -> print("Beginner")
        in 6..8 -> print("Intermediate")
        in 9..10-> print("Bombita")
        else -> ""
    }
}