package org.example.exercises_premium

/**
Sistema de alquiler de vehículos:
Crea un programa que permita gestionar el alquiler de vehículos mediante un menú.

La aplicación debe comenzar con estos vehículos:
- Toyota Corolla: coche, precio de alquiler £40 por día y seguro de £5 por día.
- Ford Focus: coche, precio de alquiler £45 por día y seguro de £5 por día.
- Xiaomi Scooter: patinete eléctrico, precio de alquiler £15 por día y batería al 60%.

Cada vehículo debe tener:
- Un identificador.
- Un nombre.
- Un precio de alquiler por día.
- Un tipo de vehículo.
- Una función para calcular el precio total del alquiler.

Reglas:
- Los coches deben añadir el precio del seguro por cada día de alquiler.
- Los patinetes eléctricos no tienen seguro.
- Los vehículos eléctricos deben poder recargarse.
- Cuando se recarga un vehículo, su batería debe pasar al 100%.
- Cada alquiler debe guardar el vehículo y el número de días.
- La lista de alquileres debe ser privada.

El programa debe mostrar continuamente estas opciones:

1. Mostrar vehículos
2. Recargar vehículo
3. Alquilar vehículo
4. Mostrar alquileres
5. Salir

Funcionamiento:
- Si el usuario selecciona 1, se deben mostrar todos los vehículos.
- Si selecciona 2, se debe pedir el identificador de un vehículo.
- Si el vehículo es recargable, se debe recargar.
- Si no es recargable, se debe mostrar "Vehicle is not rechargeable".
- Si selecciona 3, se debe pedir el identificador y el número de días.
- Si el vehículo existe, se debe registrar el alquiler.
- Si el vehículo no existe, se debe mostrar "Vehicle not found".
- Si selecciona 4, se deben mostrar todos los alquileres y el precio total.
- Si no hay alquileres, se debe mostrar "There are no rentals".
- Si selecciona 5, el programa debe finalizar.
- Si introduce otra opción, se debe mostrar "Invalid option".

Conceptos que debes utilizar:
- Clases y objetos
- Propiedades y constructores
- Funciones dentro de clases
- Data class
- Enum class
- Encapsulación
- private
- Herencia
- Clase abstracta
- protected
- Interfaces
- override
- MutableList
- find()
- while
- when
- if
 */


//Toyota Corolla: coche, precio de alquiler £40 por día y seguro de £5 por día.
//- Ford Focus: coche, precio de alquiler £45 por día y seguro de £5 por día.
//- Xiaomi Scooter: patinete eléctrico, precio de alquiler £15 por día y batería al 60%.
fun main() {
    val vehicles: List<Vehicle> = listOf(
        Car(
            1, "Toyota Corolla", 40.0, 5.0
        ), Car(
            2, "Ford Focus", 45.0, 5.0
        ), ElectricScooter(3, "Xiaomi Scooter", 15.0, 60)
    )
    val rentalManager = RentalManager()

    var selectedOption: Int = 0

    while (selectedOption != 5) {
        println()
        println("RENTAL MANAGER")
        println("1- Show vehicles")
        println("2- Recharge vehicle")
        println("3- Rent vehicle")
        println("4- Show rentals")
        println("5- Exit")
        println()
        println("Select an option:")
        selectedOption = readln().toInt()

        when (selectedOption) {
            1 -> {
                println()
                println("VEHICLES:")
                vehicles.forEach { vehicle ->
                    vehicle.showInformation()
                }
            }
            2 -> {
                println()
                println("Enter vehicle id:")
                val vehicleId:Int = readln().toInt()

                val selectedVehicle: Vehicle? = vehicles.find { it.id == vehicleId }

                when (selectedVehicle) {
                    null -> {
                        println("Vehicle not found")
                    }
                    is Rechargeable -> {
                        selectedVehicle.recharge()
                    }

                    else -> {
                        println("Vehicle is not rechargeable")
                    }
                }
            }
            3 -> {
                println()
                println("Enter vehicle id:")
                val vehicleId:Int = readln().toInt()

                val selectedVehicle: Vehicle? = vehicles.find { it.id == vehicleId }

                if(selectedVehicle!=null){
                    println()
                    println("Enter the number of days:")
                    val days = readln().toInt()
                    rentalManager.rentVehicle(selectedVehicle, days)
                }else{
                    println("Vehicle not found")
                }
            }
            4 -> { rentalManager.showRentals() }
            5 -> {
                println("Application closed")
            }

            else -> {
                println("Invalid option")
            }
        }
    }
}


class Car(id: Int, name: String, pricePerDay: Double, val insurancePerDay: Double) :
    Vehicle(id, name, pricePerDay, VehicleType.CAR) {

    override fun calculateRentalPrice(days: Int): Double {
        return (pricePerDay + insurancePerDay) * days
    }

}

class ElectricScooter(id: Int, name: String, pricePerDay: Double, private var battery: Int) :
    Vehicle(id, name, pricePerDay, VehicleType.ELECTRIC_SCOOTER), Rechargeable {

    override fun calculateRentalPrice(days: Int): Double {
        return pricePerDay * days
    }

    override fun recharge() {
        battery = 100
        println("Recharge successfully")
    }

}


abstract class Vehicle(
    val id: Int, val name: String, val pricePerDay: Double, val type: VehicleType
) {
    abstract fun calculateRentalPrice(days: Int): Double
    fun showInformation(){
        println("$id - $name - Price: $pricePerDay, Type:$type")
    }
}

enum class VehicleType {
    CAR, ELECTRIC_SCOOTER
}

interface Rechargeable {
    fun recharge()
}

class RentalManager(){
    private val rentals: MutableList<Rental> = mutableListOf()

    //- Si selecciona 4, se deben mostrar todos los alquileres y el precio total.
    fun showRentals(){
        if(rentals.isEmpty()){
            println("There are no rentals")
            return
        }

        var totals:Double = 0.0
        rentals.forEach { rental ->
            val rentalPrice = rental.vehicle.calculateRentalPrice(rental.days)
            println("${rental.vehicle.name} - $rentalPrice")
            totals += rentalPrice
        }
        println("Total de reservas: $totals")

    }

    //- Si el vehículo existe, se debe registrar el alquiler.
    fun rentVehicle(vehicle: Vehicle, days: Int){
        if(days>0){
            val rental = Rental(vehicle, days)
            rentals.add(rental)
            println("Vehicle rented successfully")
        }else{
            println("Invalid number of days")
        }
    }
}

data class Rental(val vehicle: Vehicle, val days:Int)

