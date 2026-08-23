package org.example

fun main(){

    var batteryLevel = 100

    while(batteryLevel > 100){
        println(batteryLevel)
        batteryLevel -=25
    }

    do{
        println(batteryLevel)
        batteryLevel -=25
    }while (batteryLevel > 100)

    var number = 10
    var favNumber = 4

    while (number>0){
        println(number)
        if(number == favNumber){
            break
        }
        number -=1
    }
}