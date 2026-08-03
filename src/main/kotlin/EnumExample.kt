package org.example

//Technology
//Home
//Food
//Sports

fun main(){

    val computer = Item(ItemCategory.TECHNOLOGY)
    val ps5 = Item(ItemCategory.TECHNOLOGY)

    when(ps5.category){
        ItemCategory.TECHNOLOGY -> println("")
        ItemCategory.HOME -> println("")
        ItemCategory.FOOD -> println("")
        ItemCategory.SPORT -> println("")
        ItemCategory.CLOTES -> println("")
    }
}

data class Item(val category: ItemCategory){

}

enum class ItemCategory{
    TECHNOLOGY,
    HOME,
    FOOD,
    SPORT,
    CLOTES
}