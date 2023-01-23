package simulacionParking.models

import simulacionParking.enums.Color

class Conductor(// Constructor primario
    private val id_AUTO: Int,
    private val nombre: String,
    private val DNI: String,
    var ownerVehicle: Array<Vehiculo?>,
    var quantityParking_AUTO: Int
) {
    
    /**
     * El conductor se presenta y da sus datos
     */
    fun presentarse() {
        println((Color.YELLOW_UNDERLINED.get() + "CONDUCTOR" + Color.RESET.get()) + "-> Hola soy: " + nombre)
        println("DNI: $DNI, vehículos aparcados: $quantityParking_AUTO")
        imprimirVector()
        println()
    }

    /**
     * Datos de los vehículos que tiene en propiedad el Conductor
     */
    fun imprimirVector() {
        println(Color.YELLOW_UNDERLINED.get() + "VEHÍCULOS EN PROPIEDAD" + Color.RESET.get())
        for (i in ownerVehicle.indices) {
            print("VEHÍCULO " + (i + 1) + " ")
            println(ownerVehicle[i].toString() + " ")
        }
    }

}