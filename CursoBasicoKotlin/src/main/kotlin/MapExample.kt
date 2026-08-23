package org.example

fun main(){
    val productPrices: MutableMap<String, Double> = mutableMapOf(
        "Pantalla" to 99.99,
        "Ratón" to 49.99,
        "Teclado" to 60.99
    )

    productPrices["Pepe"] = 98.8
    productPrices.remove("Pepe")

    var example: Double? = productPrices["Pepe"]

    println(example ?: "Producto no encontrado")

    for((product, price) in productPrices){
        println("Clave: $product")
        println("Valor: $price")
    }
}