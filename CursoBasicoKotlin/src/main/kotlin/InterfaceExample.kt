package org.example

fun main(){
    val sms: SMSNotifier = SMSNotifier()

    val email: EmailNotifier = EmailNotifier()

    sms.send("Hello from SMS")
    email.send("Hello from Email")
}

interface Notifier{
    fun send(message:String)
}

interface PruebaInterface{

}

class EmailNotifier(): Notifier, PruebaInterface{
    //su logica
    val test1:String = "pepe"

    override fun send(message: String) {

    }
}

class SMSNotifier(): Notifier{
    //toda su logica
    val test2:Int = 23

    override fun send(message: String) {

    }
}