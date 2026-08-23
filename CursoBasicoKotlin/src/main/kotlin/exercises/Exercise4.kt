package org.example.exercises

/**
 * Ejercicio: organiza una calculadora de productos usando funciones
 *
 * Crea un programa que calcule el precio final de un producto.
 *
 * Datos del producto:
 * - Nombre del producto: "Curso de Kotlin"
 * - Precio por unidad: 99.0
 * - Cantidad: 2
 * - Porcentaje de descuento: 10.0
 * - Porcentaje de impuestos: 7.0
 *
 * El programa debe calcular:
 * - Subtotal
 * - Cantidad descontada
 * - Precio después del descuento
 * - Cantidad de impuestos
 * - Precio final
 *
 * Requisitos:
 * - Crea funciones sin parámetros para mostrar los mensajes de bienvenida y despedida.
 * - Crea funciones con parámetros de entrada para mostrar la información del producto y el resumen final.
 * - Crea funciones con valor de retorno para calcular las diferentes cantidades.
 * - Llama a todo desde main.
 */

fun main() {
    val productName: String = "Curso Kotlin"
    val unitPrice: Double = 29.99
    val quantity = 3
    val discountPercentage = 10
    val taxPercentage = 7

    val subtotal = calculateSubtotal(unitPrice, quantity)
    val discountAmount = calculateDiscountAmount(subtotal, discountPercentage)
    val priceAfterDiscount = calculatePriceAfterDiscount(subtotal, discountAmount)
    val taxAmount = calculateTaxAmount(priceAfterDiscount, taxPercentage)
    val finalPrice = calculateFinalPrice(priceAfterDiscount, taxAmount)

    showWelcomeMessage()
    showSummary(
        subtotal,
        discountAmount,
        priceAfterDiscount,
        taxAmount,
        finalPrice
    )
    showGoodByeMessage()
}

fun showSummary(
    subtotal: Double,
    discountAmount: Double,
    priceAfterDiscount: Double,
    taxAmount: Double,
    finalPrice: Double
) {
    println("---------------------")
    println("Subtotal: $subtotal euros.")
    println("DiscountAmount: $discountAmount euros.")
    println("PriceAfterDiscount: $priceAfterDiscount euros.")
    println("TaxAmount: $taxAmount euros.")
    println("FinalPrice: $finalPrice euros.")
    println("---------------------")
}

fun calculateSubtotal(unitPrice: Double, quantity: Int): Double {
    return unitPrice * quantity
}

fun calculateDiscountAmount(subtotal: Double, discountPercentage: Int) =
    (subtotal * discountPercentage) / 100

fun calculatePriceAfterDiscount(subtotal: Double, discountAmount: Double): Double {
    return subtotal - discountAmount
}

fun calculateTaxAmount(priceAfterDiscount: Double, taxPercentage: Int): Double {
    return (priceAfterDiscount * taxPercentage) / 100
}

fun calculateFinalPrice(priceAfterDiscount: Double, taxAmount: Double): Double {
    return priceAfterDiscount + taxAmount
}

fun showWelcomeMessage() {
    println("============================")
    println("          Calculador        ")
    println("============================")
}

fun showGoodByeMessage() {
    println("============================")
    println("      Cálculo terminado     ")
    println("============================")
}



