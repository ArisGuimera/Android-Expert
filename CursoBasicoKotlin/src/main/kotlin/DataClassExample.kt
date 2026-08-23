package org.example

fun main(){
    val example1 = Example("aris", price = 398.93)
    val example2 = Example("aris")
    val result: Boolean = example1 == example2
    print(example1)
    val example3 = example1.copy(price = 32.3)
    print(example3)
}

data class Example(val name:String, val price:Double = 67.4)