package org.example.exercises_premium

/**
Juego de adivinar un número:
Crea un programa en el que el usuario tenga que adivinar un número secreto.

Reglas del juego:
- El número secreto será fijo.
- El usuario debe introducir números entre 1 y 10.
- El usuario tendrá un máximo de 3 intentos.
- Si el usuario introduce un número fuera del rango, debe mostrarse un mensaje de error.
- Un número fuera del rango no debe consumir un intento.
- Si el usuario acierta, debe mostrarse un mensaje de victoria y terminar el juego.
- Si el usuario falla, el programa debe indicar si el número secreto es mayor o menor.
- Si el usuario agota todos los intentos, debe mostrarse un mensaje de derrota.

Ejemplo:
- Número secreto: 7
- Intentos máximos: 3
- Rango válido: 1..10

El programa debe calcular:
- Cuántos intentos ha utilizado el usuario.
- Cuántos intentos le quedan.
- Si ha ganado o ha perdido.

Conceptos que debes utilizar:
- val
- var
- readln()
- toInt()
- if
- else if
- else
- rangos con in o !in
- while
- break
- continue
 */

fun main(){
    val secretNumber = 7
    val minNumber = 1
    val maxNumber = 10
    val maxAttempts = 3

    var attempts = 0
    var hasWon = false

    println("Adivina el número secreto entre el $minNumber y el $maxNumber")
    println("Tienes $maxAttempts intentos")

    while(attempts < maxAttempts){
        println("Introduce un número:")
        val guess = readln().toInt()

        // 1. Comprueba si el número está fuera del rango.
        //    Si está fuera, muestra un mensaje y usa continue.

        if(guess !in minNumber..maxNumber){
            println("El número tiene que estar entre $minNumber y $maxNumber")
            continue
        }

        // 2. Si el número es válido, suma un intento.
        attempts += 1

        // 3. Comprueba si el usuario ha acertado.
        //    Si acierta, cambia hasWon a true y usa break.
        if(guess == secretNumber){
            hasWon = true
            break
        }

        // 4. Si no ha acertado, indica si el número secreto es mayor o menor.
        if(guess < secretNumber){
            println("El número es mayor")
        }else{
            println("El número es menor")
        }

        // 5. Calcula los intentos restantes y muéstralos si todavía quedan.
        val remainingAttempts = maxAttempts - attempts
        if(remainingAttempts > 0){
            println("Intentos restantes: $remainingAttempts")
        }
    }

    // 6. Fuera del bucle, muestra si el usuario ha ganado o perdido.
    if(hasWon){
        println("¡Ganaste!")
        println("Intentos usados: $attempts")
    }else{
        println("Vaya perdedor asqueroso")
    }

}