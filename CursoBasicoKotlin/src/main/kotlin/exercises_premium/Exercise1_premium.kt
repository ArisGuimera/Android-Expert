package org.example.exercises_premium

/**
PROYECTO FINAL — CALCULADORA COMPLETA DE PRESUPUESTOS

Crea un programa en Kotlin que genere el presupuesto completo de un proyecto
de desarrollo de software.

El presupuesto debe incluir los siguientes datos:

- Nombre de la empresa.
- Nombre del cliente.
- Nombre del proyecto.
- Precio por hora.
- Número de horas estimadas.
- Coste del diseño.
- Coste de las licencias.
- Otros gastos.
- Porcentaje para imprevistos.
- Porcentaje de descuento.
- Porcentaje de impuestos.
- Porcentaje del pago inicial.

El programa debe calcular:

1. Coste total del trabajo según las horas estimadas.
2. Suma de todos los costes adicionales.
3. Precio base del proyecto.
4. Cantidad añadida para imprevistos.
5. Subtotal antes del descuento.
6. Cantidad descontada.
7. Precio después del descuento.
8. Cantidad correspondiente a los impuestos.
9. Precio final del presupuesto.
10. Cantidad que debe pagarse inicialmente.
11. Cantidad que quedará pendiente.


Fórmulas necesarias:

- Coste del trabajo: precio por hora multiplicado por el número de horas estimadas.
- Costes adicionales: suma del coste del diseño, el coste de las licencias y otros gastos.
- Precio base: suma del coste del trabajo y los costes adicionales.
- Cantidad para imprevistos: precio base multiplicado por el porcentaje de imprevistos y dividido entre la base porcentual.
- Subtotal: suma del precio base y la cantidad añadida para imprevistos.
- Cantidad descontada: subtotal multiplicado por el porcentaje de descuento y dividido entre la base porcentual.
- Precio después del descuento: subtotal menos la cantidad descontada.
- Cantidad de impuestos: precio después del descuento multiplicado por el porcentaje de impuestos y dividido entre la base porcentual.
- Precio final: precio después del descuento más la cantidad de impuestos.
- Pago inicial: precio final multiplicado por el porcentaje del pago inicial y dividido entre la base porcentual.
- Cantidad pendiente: precio final menos el pago inicial.

Requisitos:

- Utiliza nombres de variables claros y descriptivos.
- Utiliza val siempre que el valor no necesite modificarse.
- Guarda como constantes las reglas generales del presupuesto.
- Utiliza Int para cantidades enteras y Double para precios y porcentajes.
- Evita utilizar números o textos mágicos directamente en los cálculos.
- Divide los cálculos en pasos pequeños y fáciles de entender.
- Muestra al final un resumen completo mediante String.

No utilices todavía:

- Funciones adicionales.
- Condicionales.
- Bucles.
- Clases.
- Lectura de datos por consola.
 */

const val COMPANY_NAME = "AristiDevs SL"
const val CURRENCY_SYMBOL = "$"
const val TAX_PERCENTAGE = 7.0
const val CONTINGENCY_PERCENTAGE = 5.0
const val INITIAL_PAYMENT_PERCENTAGE = 30.0
const val PERCENTAGE_BASE = 100.0

fun main() {

    val clientName = "Bimbo SL"
    val projectName = "Buscador de árboles para hacer pipí"

    val hourlyRate = 45.0
    val estimatedHours = 80
    val discountPercent = 10.0

    val designCost = 600.0
    val licenseCost = 150.0
    val otherExpenses = 100.0

    //RESULT:
    println("=======================================")
    println("              PRESUPUESTO              ")
    println("=======================================")
    println("Empresa: $COMPANY_NAME")
    println("Cliente: $clientName")
    println("PROYECTO: $projectName")
    println("=======================================")

    val laborCost = hourlyRate * estimatedHours
    println("Coste total del trabajo según las horas estimadas: $laborCost")

    val additionalCost = designCost + licenseCost + otherExpenses
    println("Suma de todos los costes adicionales: $additionalCost")

    val basePrice = laborCost + additionalCost
    println("Precio base del proyecto: $basePrice $CURRENCY_SYMBOL")

    val contingencyAmount = (basePrice * CONTINGENCY_PERCENTAGE) / PERCENTAGE_BASE
    println("Cantidad añadida para imprevistos: $contingencyAmount")

    val subtotal = basePrice + contingencyAmount
    println("Subtotal antes del descuento: $subtotal")

    val discountAmount = (subtotal * discountPercent) / PERCENTAGE_BASE
    val priceAfterDiscount = subtotal - discountAmount
    println("Descuento del $discountPercent%: $discountAmount $CURRENCY_SYMBOL")
    println("Precio después del descuento: $priceAfterDiscount $CURRENCY_SYMBOL")

    val taxAmount = (priceAfterDiscount * TAX_PERCENTAGE)/PERCENTAGE_BASE
    val finalPrice = priceAfterDiscount + taxAmount
    println("Impuestos ($TAX_PERCENTAGE%): $taxAmount $CURRENCY_SYMBOL")
    println("Precio final: $finalPrice$CURRENCY_SYMBOL")

    val initialPayment = (finalPrice * INITIAL_PAYMENT_PERCENTAGE) /PERCENTAGE_BASE
    val remainingAmount = finalPrice - initialPayment

    println("Pago inicial ($INITIAL_PAYMENT_PERCENTAGE%): $initialPayment$CURRENCY_SYMBOL")
    println("Cantidad pendiente: $remainingAmount$CURRENCY_SYMBOL")

    println("=======================================")
}
