package org.example

fun main() {
//    showKotlinProduct()
//    showIOSProduct()
    showProduct(productName = "Curso de SuperKotlin")
    showProduct(price = 19.99, productName = "Curso de SuperIOS")

    val total = showProductTotal(10.0, 3)

    val firstSC = calculateShippingCost(45.99)
    val secondSC = calculateShippingCost(87.98)

    println(firstSC)
    println(secondSC)

    calculateFinalPrice(discountPercentage = 76.78, price = 37.0)
    calculateFinalPrice(76.98, 10.5)

    showProductId("23dwkdka")

}

fun showProductTotal(price: Double, quantity: Int): Double {
    val total = price * quantity
    return total
}

fun showProductTotal2(price: Double, quantity: Int) = price * quantity

fun showProduct(productName: String, price: Double = 8.88) {
    println("Product: $productName")
    println("Precio: $price euros")
}

fun showKotlinProduct() {
    println("Product: Curso de Kotlin")
    println("Precio: 9.99 euros")
}

fun showIOSProduct() {
    println("Product: Curso de iOS")
    println("Precio: 19.99 euros")
}


fun separator() {
    println("===========================")
}

fun showProductName() {
    println("El producto es: Manzana")
}

fun calculateSubtotal(price: Double, quantity: Int): Double {
    val subtotal = price * quantity
    return subtotal
}

fun calculateShippingCost(subtotal: Double): Double {
    if (subtotal > 50) {
        return 0.0
    }
    return 4.99
}

fun example() {
    val a = 34
    require(a < 50)
    val b = a * a
    val c = a * a
    val d = a * a
}

fun calculateFinalPrice(price: Double): Double {
    //logica
    return price
}

fun calculateFinalPrice(price: Double, discountPercentage: Double): Double {
    //logica
    return price
}

fun showProductId(productId: Int) {
    print("La id es $productId")
}

fun showProductId(productId: String) {
    print("La id es $productId")
}


fun processOrder(price: Double, discountPercentage: Double) {
    val discountPrice = calculateDiscount(price, discountPercentage)
    val finalPrice = price - discountPrice

    println("Precio inicial: $price")
    println("Descuento: $discountPercentage")
    println("Precio final: $finalPrice")
    println("Pedido procesado correctamente")
}

fun calculateDiscount(price: Double, discountPercentage: Double) = price * discountPercentage / 100







