package org.example.exercises

/**
Calculadora:
 Crea una calculadora que reciba los siguientes parámetros.
 - Nombre del producto
 - Precio por unidad
 - Cantidad
 - % Descuento
 - % Impuestos

 El programa debe calcular. Ej 100.
 - Subtotal (100)
 - Cantidad descontada (10)
 - Precio total después del descuento (90)
 - Cantidad de impuestos  (9)
 - Total
 */

const val TAX_PERCENTAGE = 21
const val PERCENTAGE_BASE = 100

fun main(){
    val productName:String = "Pikachu"
    val price:Double = 199.99
    val quantity:Int = 8
    val discountPercent:Int = 15
    val taxes:Int = 21

    val subtotal = quantity * price
    val totalDiscountPerUnit = (discountPercent * price) / PERCENTAGE_BASE
    val totalDiscount = totalDiscountPerUnit * quantity
    val finalTotalAfterDiscount = subtotal - totalDiscount
    val calculatedTaxes = (taxes * finalTotalAfterDiscount)/100
    val total = finalTotalAfterDiscount + calculatedTaxes

    println("El producto comprado es $productName")
    println("Se han comprado $quantity unidad/es a un precio de $price euros.")
    println("El subtotal es $subtotal")
    println("Descuento total: $totalDiscount")
    println("Precio final con descuento $finalTotalAfterDiscount")
    println("Cantidad de impuestos: $calculatedTaxes")
    println("Total a pagar: $total")

}