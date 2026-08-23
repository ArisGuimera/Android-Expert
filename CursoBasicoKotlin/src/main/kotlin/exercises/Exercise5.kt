package org.example.exercises

/**
Agenda de contactos:
Crea un programa que permita gestionar una agenda mediante un menú.

La agenda debe comenzar con estos contactos:
- Ana
- Carlos
- Lucía

El programa debe mostrar continuamente estas opciones:

1. Mostrar agenda
2. Añadir contacto
3. Eliminar contacto
4. Salir

Funcionamiento:
- Si el usuario selecciona 1, se debe mostrar la agenda completa.
- Si selecciona 2, se debe pedir el nombre de un contacto y añadirlo.
- Si selecciona 3, se debe pedir el nombre de un contacto y eliminarlo.
- Si el contacto no existe, se debe mostrar "Contacto no encontrado".
- Si selecciona 4, el programa debe finalizar.
- Si introduce otra opción, se debe mostrar "Opción no válida".

Ejemplo:

1. Mostrar agenda
2. Añadir contacto
3. Eliminar contacto
4. Salir

Selecciona una opción:
2

Escribe el nombre del contacto:
Pedro

Contacto añadido correctamente.

Conceptos que debes utilizar:
- MutableList
- mutableListOf()
- add()
- remove()
- while
- when
- if
- readln()
- toInt()
 */

fun main() {

    val contacts = mutableListOf("Ana", "Carlos", "Lucía")
    var selectedOption = 0

    while (selectedOption != 4) {
        println("AGENDA")
        println("1. Mostrar agenda")
        println("2. Añadir contacto")
        println("3. Borrar contacto")
        println("4. Salir")
        println("")
        println("Selecciona una opción:")

        selectedOption = readln().toInt()

        when (selectedOption) {
            1 -> {
                println("")
                println("Contactos:")
                println(contacts)
                println("")
            }

            2 -> {
                println("")
                println("Nombre del contacto a añadir:")
                val newContact: String = readln()
                contacts.add(newContact)
                println("")
            }

            3 -> {
                println("")
                println("Nombre del contacto para borrarlo:")
                val newContact: String = readln()
                contacts.remove(newContact)
                println("")
            }

            4 -> {
                println("")
                println("Un besi de fresi")
                println("")
            }
            else -> {
                println("")
                println("Opción no válida")
                println("")
            }
        }
    }
}

