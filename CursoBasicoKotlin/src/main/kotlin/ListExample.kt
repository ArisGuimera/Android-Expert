package org.example


fun main(){
    forListExample()
    val product1 = "Ratón"
    val product2 = "Pantalla"
    val product3 = "Teclado"

//    val products:List<String> = listOf("Ratón", "Pantalla", "Teclado")
    val products = mutableListOf("Ratón", "Pantalla", "Teclado")


    println(products.last())
    println(products.first())
    println(products.size)

    products.add("Webcam")
    products.add(0, "Portatil")
    products.remove("Ratón")
    products.removeAt(1)

    println(products)

}

fun forListExample(){

    val products = mutableListOf("Ratón", "Pantalla", "Teclado")
    val emptyProducts: MutableList<String> = mutableListOf()

//    for(product in products){
//        println("El producto es $product")
//    }

    products.forEach { product ->
        print(product)
    }

//    for(index in products.indices){
//        println("Para la posición $index el valor es ${products[index]}")
//    }

    for ((index, product) in products.withIndex()){
        println("Para lo posición $index el valor es $product")
    }

    if("Raton" in products){
        println("Ratón disponible")
    }

    if(emptyProducts.isNotEmpty()){

    }



}









