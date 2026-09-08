package com.aristidevs.androidmaster.sintaxis

data class UserDataClass(val name: String, val nickname: String, var isHappy: Boolean)

data class SuperHero(
    var superhero: String,
    var publisher: String,
    var realName: String,
    var photo: String
)

class ExampleDataClass {

    val batman: SuperHero = SuperHero(
        "Batman",
        "DC",
        "Bruce Wayne",
        "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg"
    )

    fun example(){
        batman.superhero = "El hombre murciélago"
        batman.component4()
    }

}