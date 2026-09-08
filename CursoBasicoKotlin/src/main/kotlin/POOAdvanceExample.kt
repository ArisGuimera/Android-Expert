package org.example

fun main() {

    val myAccount = BankAccount(
        "ES25727653678373",
        1000.0
    )

    myAccount.accountNumber
    myAccount.withdraw(40.0)

    val GTA_VI = DigitalGameProduct("GTA 6", price = 80.0)

    GTA_VI.redeem()

    val zelda = PhysicalGameProduct("Ocarine", 49.99, 4.99)
    zelda.calculateFinalPrice()


}

abstract class GameProduct(
    val name: String,
    protected val price: Double
) {
    abstract fun calculateFinalPrice(): Double
}

class PhysicalGameProduct(
    name: String,
    price: Double,
    private val shippingCost: Double
) : GameProduct(name, price) {

    override fun calculateFinalPrice(): Double {
        return price + shippingCost
    }
}

class DigitalGameProduct(name: String, price: Double): GameProduct(name, price){

    override fun calculateFinalPrice(): Double {
        return price
    }

    fun redeem(){

    }

}


class BankAccount(
    var accountNumber: String,
    var balance: Double
) {

    fun showBalance() {
        println("Current balance: $balance")
    }

    fun withdraw(amount: Double) {
        if (amount <= 0) {
            println("The amount must be greater than zero")
        } else if (amount > balance) {
            println("Insufficient balance")
        } else {
            balance -= amount
            print("Withdraw: $balance")
        }
    }

}

