package org.example

fun main() {
//    filterExample()
//    mapExample()
//    findExample()
    combinationExample()
}

fun combinationExample() {
    val prices: List<Int> = listOf(10, 25, 5, 87)

    val result = prices
        .filter { it > 20 }
        .map { it * 1.07 }
        .filter { it > 30 }
}

fun findExample() {
    val products = listOf("Ordenador", "Teclado", "Ratón", "Cable", "Monitor", "Torre")

    val result: String? = products.find { product -> product.startsWith("T") }
    val result2: String? = products.findLast { product -> product.startsWith("T") }

    print(result)
    print(result2)
}

fun mapExample() {
    val prices: List<Int> = listOf(10, 25, 5, 87)

    val priceWithTaxes: List<Double> = prices.map { price ->
        price * 1.07
    }

    print(priceWithTaxes)
}

fun filterExample() {
    val prices = listOf(10, 25, 5, 87)

    val filteredPrices = prices.filter { price ->
        price > 20
    }

    print(filteredPrices)
}
