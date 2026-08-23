package org.example

fun main(){

    val keyboard:Product = Product(productName = "Keyboard", productPrice = 29.99, productStock = 783 )
    val mouse = Product("Mouse", 19.99, 23)

    mouse.productStock = mouse.productStock--

    mouse.showInformation()
    mouse.applyDiscount(20)
    mouse.showInformation()
}

class Product(
    val productName:String,
    var productPrice: Double,
    var productStock:Int
){

    fun showInformation(){
        println("El nombre del producto es $productName y su precio es $productPrice")
    }

    fun applyDiscount(discount:Int){
        val discountAmount = productPrice * discount/100
        productPrice = productPrice-discountAmount
//        productPrice -= discountAmount
    }

}