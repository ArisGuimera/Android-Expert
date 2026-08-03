package org.example.exercises_premium

/**
Gestión de productos:
Crea un programa que permita gestionar productos y sus precios mediante un menú.

La aplicación debe comenzar con estos productos:
- Keyboard: 49.99
- Mouse: 24.99
- Monitor: 199.99

El programa debe mostrar continuamente estas opciones:

1. Mostrar productos
2. Añadir producto
3. Eliminar producto
4. Buscar producto
5. Filtrar productos por precio
6. Salir

Funcionamiento:
- Si el usuario selecciona 1, se deben mostrar todos los productos y sus precios.
- Si selecciona 2, se debe pedir el nombre y el precio de un producto y añadirlo.
- Si selecciona 3, se debe pedir el nombre de un producto y eliminarlo.
- Si el producto no existe, se debe mostrar "Product not found".
- Si selecciona 4, se debe buscar un producto por su nombre y mostrar su precio.
- La búsqueda no debe distinguir entre mayúsculas y minúsculas.
- Si selecciona 5, se debe pedir un precio mínimo y mostrar los productos
que tengan un precio igual o superior.
- Si selecciona 6, el programa debe finalizar.
- Si introduce otra opción, se debe mostrar "Invalid option".

Ejemplo:

1. Show products
2. Add product
3. Delete product
4. Search product
5. Filter products by price
6. Exit

Select an option:
4

Enter the product name:
mouse

Mouse - £24.99

Conceptos que debes utilizar:
- MutableMap
- mutableMapOf()
- claves y valores
- put o acceso mediante corchetes
- remove()
- keys
- find()
- filter()
- while
- when
- if
- readln()
- toInt()
- toDouble()
 */

fun main() {
    val products = mutableMapOf(
        "Keyboard" to 49.99,
        "Mouse" to 24.99,
        "Monitor" to 199.99
    )

    var selectedOption = 0

    while (selectedOption != 6) {
        println()
        println("       PRODUCT MANAGER      ")
        println("1.Show products")
        println("2.Add product")
        println("3.Delete product")
        println("4.Search product")
        println("5.Filter products by price")
        println("6.Exit")
        println()
        println("Select an option:")
        selectedOption = readln().toInt()

        when (selectedOption) {
            1 -> {
                println("Products:")
                println(products)
            }

            2 -> {
                println("Enter the product name:")
                val productName = readln()

                println("Enter the product price:")
                val productPrice = readln().toDouble()

                products[productName] = productPrice

                println("Product added successfully")
            }

            3 -> {
                println("Enter the product name:")
                val productName = readln()

                val deletedProductPrice: Double? = products.remove(productName)

                if (deletedProductPrice != null) {
                    println("Product deleted successfully")
                } else {
                    println("Product not found")
                }
            }

            4 -> {
                println("Enter the product name:")
                val productName = readln()

                val foundProduct: String? = products.keys.find {
//                    it.lowercase() == productName.lowercase()
                    it.equals(productName, ignoreCase = true)
                }

                if(foundProduct!=null){
                    val productPrice = products[foundProduct]
                    println("$foundProduct - $productPrice")
                }else{
                    println("Product not found")
                }

//                if (productPrice != null) {
//                    println("$productName - $productPrice")
//                } else {
//                    println("Product not found")
//                }
            }

            5 -> {
                println("Enter the minimum price:")
                val minimumPrice = readln().toDouble()

                val filteredProducts = products.filter { it.value > minimumPrice }

                if (filteredProducts.isEmpty()) {
                    println("Products not found")
                } else {
                    println(filteredProducts)
                }
            }

            6 -> {
                println("Product manager closed")
            }

            else -> {
                println("Invalid Option")
            }
        }

    }
}