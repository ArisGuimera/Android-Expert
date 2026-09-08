package org.example

fun main() {
    val name: String? = null
    val description: String? = null
    val surname: String = "Lopez"
    val age: Int? = null

    println(surname.length)

    if (name != null) {
        println(name.length)
    }else{
        println("name es nulo")
    }

    if(description == null){
        println("No hay descripción")
    }

    showName(name)

    //Safe Call

    val myName:String? = null
    println("Pre myName")
    println(myName?.length)
    println("Post myName")

    val myName2:String? = "Pepe"
    println(myName2 ?: "Aris")

}

fun showName(name:String?){

    if(name == null){
        println("No hay nombre válido")
        return
    }


    println("User:$name")
    println("Longitud:${name.length}")
}