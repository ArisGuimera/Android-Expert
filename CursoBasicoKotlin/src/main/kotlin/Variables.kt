
package org.example
fun main(){

    //Numéricas

    var score = 1 //Int
    var score2:Int = 1

    var score3:Long = 312378123789

    var score4:Float = 4.8F

    var score5:Double = 5.8321747

    //Alfanuméricas

    var example:String = "DAwda292412:@#@>#"
    var miniExample:Char = '%'

    //Booleanas
    var isPremium2: Boolean = true

    val firstNumber = 8
    val secondNumber = 2

    print("Sumar:")
    val result = firstNumber + secondNumber
    println(result)

    print("Restar:")
    println(firstNumber - secondNumber)

    print("Multiplicar:")
    println(firstNumber * secondNumber)

    print("División:")
    println(firstNumber / secondNumber)

    print("Resto(módulo):")
    println(firstNumber % secondNumber)

    val result2 = (4 + 4) * 2


    //Operadores de comparación
    /**
     * == (igual a)
     * != (diferente de)
     * > (mayor que)
     * < (menor que)
     * >= (mayor o igual que)
     * <= (menor o igual que)
     */

    val age = 30
    val isThirty: Boolean = age == 30
    val isNotThirty: Boolean = age != 37
    val isAdult:Boolean = age >= 18

    println(isAdult)


        /**
        Operadores lógicos
         && (Ambas opciones tienen que ser verdaderas)
         || (al menos una condición verdadera)
         ! (invertir el valor)
         */

    val age2 = 25
    val hasTicket = true

    val canAccess = age2 >= 18  && hasTicket

    println(canAccess)

    val isPremium = false
    val hasFreeTrial = true

    val canEnter = isPremium || hasFreeTrial
    println(canEnter)

    val isBlocked = false
    val isNotBlocked = !isBlocked

    //lowerCamelCase
    val productPrice = 63
    val productPriceWithDiscount = 56

    val ProductPrice = 32 //NO
    val product_price = 23 //NO
    val data = "Mi producto" //NO
    val value = 54 //NO

    //is: Estado
    val isAvailable = true

    //has: Posee algo
    val hasDiscount = true

    //can: Puede hacer algo
    val canAccessToDetail = true

    //should: Si debería poder hacer algo
    val shouldApplyDiscount = true
    val shouldSendNotification = false



}